package com.usoft.sdk.b2b.client.v2;

import com.google.protobuf.Descriptors;
import com.google.protobuf.Message;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import com.usoft.security.utils.OpenApiSignUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLEncoder;
import java.util.Map;

/**
 * 基础SDK
 *
 * @author: wangcanyi
 * @date: 2019-12-12 17:26
 **/
public abstract class BaseSdk {
	private static final Logger LOGGER = LoggerFactory.getLogger(BaseSdk.class);
	/**
	 * 默认超时时间
	 */
	protected static int DEFAULT_TIMEOUT = 60000;

	/**
	 * 域名地址
	 */
	protected String baseUrl = "";
	/**
	 * 超时时间，单位毫秒
	 */
	protected int timeout = DEFAULT_TIMEOUT;
	/**
	 * 企业UU号
	 */
	protected String secretId = "";
	/**
	 * 密钥
	 */
	protected String secretKey = "";
	/**
	 * 身份ID，Key
	 */
	private String SECRET_ID_KEY = "secretId";

	public BaseSdk(String baseUrl, String secretId, String secretKey) {
		this(baseUrl, secretId, secretKey, DEFAULT_TIMEOUT);
	}

	public BaseSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		if (StringUtils.isBlank(baseUrl)) {
			throw new RuntimeException("baseUrl 不能为空");
		}
		if (StringUtils.isBlank(secretId)) {
			throw new RuntimeException("secretId 不能为空");
		}
		if (StringUtils.isBlank(secretKey)) {
			throw new RuntimeException("secretKey 不能为空");
		}
		this.baseUrl = baseUrl;
		this.secretId = secretId;
		this.secretKey = secretKey;
		this.timeout = timeout;
	}

	/**
	 * 生成签名
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	protected Map<String, String> genSignToMap(Message.Builder req) throws Exception {
		Map<String, String> paramMap = ProtoBufUtil.toMap(req);
		//统一设置身份ID
		paramMap.put(SECRET_ID_KEY, secretId);
		if (paramMap.containsKey(OpenApiSignUtil.SIGNATURE_KEY)) {
			//清空签名
			paramMap.remove(OpenApiSignUtil.SIGNATURE_KEY);
		}
		String paramStr = HttpUtil.getParamStr(paramMap);
		LOGGER.debug("[BaseSdk.genSignToMap]待签名串：{}", paramStr);
		String signatureValue = OpenApiSignUtil.sign(paramStr, secretKey);
		signatureValue = URLEncoder.encode(signatureValue, "UTF-8");
		//设置签名
		paramMap.put(OpenApiSignUtil.SIGNATURE_KEY, signatureValue);
		return paramMap;
	}

	/**
	 * 生成签名
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	protected String genSignToJson(Message.Builder req) throws Exception {
		Descriptors.FieldDescriptor secretIdFd = req.getDescriptorForType().findFieldByName(SECRET_ID_KEY);
		if (secretIdFd != null) {
			//统一设置身份ID
			req.setField(secretIdFd, secretId);
		}
		Descriptors.FieldDescriptor signatureFd = req.getDescriptorForType().findFieldByName(OpenApiSignUtil.SIGNATURE_KEY);
		if (signatureFd != null) {
			//清空签名
			req.setField(signatureFd, signatureFd.getDefaultValue());
		}
		String paramJson = ProtoBufUtil.toJSON(req);
		String signatureValue = OpenApiSignUtil.sign(paramJson, secretKey);
		if (signatureFd != null) {
			//设置签名
			req.setField(signatureFd, signatureValue);
		}
		return ProtoBufUtil.toJSON(req);
	}
}
