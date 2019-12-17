package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.order.api.entity.SaleDown;
import com.usoft.b2b.external.erp.order.api.protobuf.GetSaleDownListReq;
import com.usoft.b2b.external.erp.order.api.protobuf.GetSaleDownListResp;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusReq;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusResp;
import com.usoft.b2b.external.erp.reconciliation.api.entity.PurchaseApCheck;
import com.usoft.b2b.external.erp.reconciliation.api.protobuf.*;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangcanyi
 * @date: 2019-12-17 14:34
 **/
public class ReconciliationSdk extends BaseSdk {

	public ReconciliationSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public ReconciliationSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 买获取B2B新增的对账单信息
	 *
	 * @param req
	 * @return
	 */
	public GetApCheckListResp getApCheckList(GetApCheckListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/APCheck";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<PurchaseApCheck> resultList = ProtoBufUtil.toProtoBufList(PurchaseApCheck.newBuilder().build(), respJson);
		GetApCheckListResp.Builder result = GetApCheckListResp.newBuilder();
		result.addAllApCheckList(resultList);
		return result.build();
	}

	/**
	 * 平台的应收对账传到供应商ERP之后，修改平台里面的订单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnApChcekSuccessResp onApCheckSuccess(OnApChcekSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/APCheck";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnApChcekSuccessResp.newBuilder().build();
	}
	/**
	 * 买家ERP回复平台传入的应收账单(不同意和确认)
	 *
	 * @param req
	 * @return
	 */
	public ReplyApCheckResp replyApCheck(ReplyApCheckReq req) throws IOException {
		String url = baseUrl + "/erp/sale/APCheck/reply";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getApCheckListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return ReplyApCheckResp.newBuilder().build();
	}
}