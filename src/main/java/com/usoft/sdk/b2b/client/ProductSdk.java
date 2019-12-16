package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangcanyi
 * @date: 2019-12-12 17:41
 **/
public class ProductSdk extends BaseSdk {


	public ProductSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public ProductSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 定时任务更新物料信息
	 *
	 * @param req
	 * @return
	 */
	public UpdateProductsResp updateProducts(UpdateProductsReq req) throws IOException {
		String url = baseUrl + "/product/cycleupdate";
		Map<String, String> map = new HashMap<>();
		map.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		map.put("enUU", req.getEnUU() + "");
		String respJson = HttpUtil.doPost(url, map, timeout);
		ProtoBufUtil.toProtoBuf(UpdateProductsResp.newBuilder(), respJson);
		return UpdateProductsResp.newBuilder().build();
	}
}
