package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import com.usoft.sdk.b2b.utils.ResponseUtil;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2019-12-12 17:41
 **/
public class ProductSdk extends BaseSdk {

	public ProductSdk(String baseUrl) {
		super(baseUrl);
	}

	public ProductSdk(String baseUrl, int timeout) {
		super(baseUrl, timeout);
	}

	/**
	 * 定时任务更新物料信息
	 *
	 * @param req
	 * @return
	 */
	public UpdateProductsResp updateProducts(UpdateProductsReq req) throws IOException {
		String url = baseUrl + "/product/cycleupdate";
		String json = ProtoBufUtil.toJSON(req);
		String respJson = HttpUtil.doPost(url, json, timeout);
		UpdateProductsResp.Builder resp = ProtoBufUtil.toProtoBuf(UpdateProductsResp.newBuilder(), respJson);
		ResponseUtil.checkRespHeader(resp.getRespHeader().getCode(), resp.getRespHeader().getMsg());
		return resp.build();
	}
}
