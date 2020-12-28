package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * @author open
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
	 * 批量新增或修改产品
	 *
	 * @param req
	 * @return
	 */
	public BatchCreateOrUpdateProductResp batchCreateOrUpdateProduct(BatchCreateOrUpdateProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/createorupdate/batch";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		BatchCreateOrUpdateProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchCreateOrUpdateProductResp.newBuilder(), respJson);
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

	/**
	 * 获取产品
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetProductResp getProduct(GetProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetProductResp.Builder resp = ProtoBufUtil.toProtoBuf(GetProductResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 批量删除产品
	 *
	 * @param req
	 * @return
	 */
	public BatchDeleteProductResp batchDeleteProduct(BatchDeleteProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/product/delete/batch";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		BatchDeleteProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchDeleteProductResp.newBuilder(), respJson);
		return resp.build();
	}
}
