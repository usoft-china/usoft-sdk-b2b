package com.usoft.sdk.b2b.client;

import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.encry.HmacUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 基础SDK
 *
 * @author: wangcanyi
 * @date: 2019-12-12 17:26
 **/
public abstract class BaseSdk {
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

	public BaseSdk(String baseUrl, String secretId, String secretKey) {
		this(baseUrl, secretId, secretKey, DEFAULT_TIMEOUT);
	}

	public BaseSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		this.baseUrl = baseUrl;
		this.secretId = secretId;
		this.secretKey = secretKey;
		this.timeout = timeout;
	}

	/**
	 * 生成签名
	 *
	 * @param url
	 * @param map
	 * @return
	 */
	protected Map<String, String> generateSignature(String url, Map<String, String> map) {
		if (map == null) {
			map = new LinkedHashMap<>();
		}
		map.put("access_id", secretId);
		String path = HttpUtil.getPath(url, map);
		String signature = HmacUtils.encode(path, secretKey);
		map.put("_signature", signature);
		return map;
	}
}
