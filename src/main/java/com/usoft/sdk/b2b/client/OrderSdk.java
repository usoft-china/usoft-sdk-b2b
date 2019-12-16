package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.order.api.entity.SaleDown;
import com.usoft.b2b.external.erp.order.api.protobuf.GetSaleDownListReq;
import com.usoft.b2b.external.erp.order.api.protobuf.GetSaleDownListResp;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusReq;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusResp;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangcanyi
 * @date: 2019-12-12 17:41
 **/
public class OrderSdk extends BaseSdk {


	public OrderSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public OrderSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 获取所有待上传到卖家erp的订单
	 *
	 * @param req
	 * @return
	 */
	public GetSaleDownListResp getSaleDownList(GetSaleDownListReq req) throws IOException {
		String url = baseUrl + "/erp/sale";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleDown> saleDownList = ProtoBufUtil.toProtoBufList(SaleDown.newBuilder().build(), respJson);
		GetSaleDownListResp.Builder result = GetSaleDownListResp.newBuilder();
		result.addAllSaleDownList(saleDownList);
		return result.build();
	}

	/**
	 * 平台的订单传到卖方ERP之后，修改平台里面的订单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleDownStatusResp updateSaleDownStatus(UpdateSaleDownStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		params.put("data", req.getIdStr());
		HttpUtil.doPost(url, params, timeout);
		return UpdateSaleDownStatusResp.newBuilder().build();
	}
}
