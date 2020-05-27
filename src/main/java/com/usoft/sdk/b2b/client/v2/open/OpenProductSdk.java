package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * @author uas
 * @date 2020/5/27 16:32
 */
public class OpenProductSdk extends BaseSdk {
    public OpenProductSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenProductSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
	 * 新增或修改产品
	 *
	 * @param req
	 * @return
	 */
	public CreateOrUpdateProductResp createOrUpdateProduct(CreateOrUpdateProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/createorupdate";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreateOrUpdateProductResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateOrUpdateProductResp.newBuilder(), respJson);
		return resp.build();
	}

    /**
	 * 批量导入产品
	 *
	 * @param req
	 * @return
	 */
	public ImportProductResp importProduct(ImportProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/import";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		ImportProductResp.Builder resp = ProtoBufUtil.toProtoBuf(ImportProductResp.newBuilder(), respJson);
		return resp.build();
	}

    /**
	 * 导出产品
	 *
	 * @param req
	 * @return
	 */
	public ExportProductResp exportProduct(ExportProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/export";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		ExportProductResp.Builder resp = ProtoBufUtil.toProtoBuf(ExportProductResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 分页查询产品
	 *
	 * @param req
	 * @return
	 */
	public PagingProductResp pagingProduct(PagingProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingProductResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingProductResp.newBuilder(), respJson);
		return resp.build();
	}
}
