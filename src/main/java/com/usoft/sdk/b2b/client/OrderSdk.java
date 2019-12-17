package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.order.api.entity.*;
import com.usoft.b2b.external.erp.order.api.protobuf.*;
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
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleDownStatusResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取在平台回复的记录
	 *
	 * @param req
	 * @return
	 */
	public GetSaleReplyListResp getSaleReplyList(GetSaleReplyListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/reply";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleReply> resultList = ProtoBufUtil.toProtoBufList(SaleReply.newBuilder().build(), respJson);
		GetSaleReplyListResp.Builder result = GetSaleReplyListResp.newBuilder();
		result.addAllSaleReplyList(resultList);
		return result.build();
	}

	/**
	 * 平台的回复记录传到供应商ERP之后，修改平台里面的回复记录的上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleReplyStatusResp updateSaleReplyStatus(UpdateSaleReplyStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale/reply/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleReplyStatusResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取结案、反结案客户采购单
	 *
	 * @param req
	 * @return
	 */
	public GetSaleDownDetailEndResp getSaleDownDetailEnd(GetSaleDownDetailEndReq req) throws IOException {
		String url = baseUrl + "/erp/sale/end";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleDownDetailEnd> resultList = ProtoBufUtil.toProtoBufList(SaleDownDetailEnd.newBuilder().build(), respJson);
		GetSaleDownDetailEndResp.Builder result = GetSaleDownDetailEndResp.newBuilder();
		result.addAllDetailEndList(resultList);
		return result.build();
	}

	/**
	 * 平台的结案、反结案客户采购单传到供应商ERP之后，修改平台里面的上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleDownDetailEndResp updateSaleDownDetailEnd(UpdateSaleDownDetailEndReq req) throws IOException {
		String url = baseUrl + "/erp/sale/end/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleDownDetailEndResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取待上传的采购变更单
	 *
	 * @param req
	 * @return
	 */
	public GetSaleDownChangeListResp getSaleDownChangeList(GetSaleDownChangeListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/change";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleDownChange> resultList = ProtoBufUtil.toProtoBufList(SaleDownChange.newBuilder().build(), respJson);
		GetSaleDownChangeListResp.Builder result = GetSaleDownChangeListResp.newBuilder();
		result.addAllSaleDownChangeList(resultList);
		return result.build();
	}

	/**
	 * 平台的变更单传到供应商ERP之后，修改平台里面的变更单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleDownChangeStatusResp updateSaleDownChangeStatus(UpdateSaleDownChangeStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale/change";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleDownChangeStatusResp.newBuilder().build();
	}

	/**
	 * 将卖家ERP的变更单回复信息写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveSaleDownChangeReplyResp saveSaleDownChangeReply(SaveSaleDownChangeReplyReq req) throws IOException {
		String url = baseUrl + "/erp/sale/change/reply";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getChangeReplyListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveSaleDownChangeReplyResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取在平台回复的记录
	 *
	 * @param req
	 * @return
	 */
	public GetSaleDownChangeReplyListResp getSaleDownChangeReplyList(GetSaleDownChangeReplyListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/change/reply";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleDownChangeReply> resultList = ProtoBufUtil.toProtoBufList(SaleDownChangeReply.newBuilder().build(), respJson);
		GetSaleDownChangeReplyListResp.Builder result = GetSaleDownChangeReplyListResp.newBuilder();
		result.addAllChangeReplyList(resultList);
		return result.build();
	}

	/**
	 * 平台的回复信息传到供应商ERP之后，修改平台里面的变更单的回复信息上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleDownChangeReplyStatusResp updateSaleDownChangeReplyStatus(UpdateSaleDownChangeReplyStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale/change/reply/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleDownChangeReplyStatusResp.newBuilder().build();
	}

	/**
	 * 将ERP的采购订单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseListResp savePurchaseList(SavePurchaseListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<Purchase> resultList = ProtoBufUtil.toProtoBufList(Purchase.newBuilder().build(), respJson);
		SavePurchaseListResp.Builder result = SavePurchaseListResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 买家ERP获取平台的订单回复
	 *
	 * @param req
	 * @return
	 */
	public GetPurchaseReplyListResp getPurchaseReplyList(GetPurchaseReplyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/reply";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<PurchaseReply> resultList = ProtoBufUtil.toProtoBufList(PurchaseReply.newBuilder().build(), respJson);
		GetPurchaseReplyListResp.Builder result = GetPurchaseReplyListResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 保存买家ERP主动回复的记录到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseReplyListResp savePurchaseReplyList(SavePurchaseReplyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/reply";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SavePurchaseReplyListResp.newBuilder().build();
	}

	/**
	 * 平台的订单回复传到ERP之后，修改平台里面的回复记录的状态
	 *
	 * @param req
	 * @return
	 */
	public UpdatePurchaseReplyStatusResp updatePurchaseReplyStatus(UpdatePurchaseReplyStatusReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/reply/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdatePurchaseReplyStatusResp.newBuilder().build();
	}

	/**
	 * 买家结案、反结案采购单后，传到平台
	 *
	 * @param req
	 * @return
	 */
	public UpdatePurchaseDetailEndResp updatePurchaseDetailEnd(UpdatePurchaseDetailEndReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/end";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return UpdatePurchaseDetailEndResp.newBuilder().build();
	}

	/**
	 * 买家ERP获取平台的打印状态
	 *
	 * @param req
	 * @return
	 */
	public GetMessageLogListResp getMessageLogList(GetMessageLogListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/print";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<MessageLog> resultList = ProtoBufUtil.toProtoBufList(MessageLog.newBuilder().build(), respJson);
		GetMessageLogListResp.Builder result = GetMessageLogListResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的打印记录传到ERP之后，修改平台里面的打印记录的传输状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateMessageLogStatusResp updateMessageLogStatus(UpdateMessageLogStatusReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/print/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateMessageLogStatusResp.newBuilder().build();
	}

	/**
	 * 将未上传的采购明细上传到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseDetailListResp savePurchaseDetailList(SavePurchaseDetailListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/item";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SavePurchaseDetailListResp.newBuilder().build();
	}


	/**
	 * 将买家ERP的采购变更单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseChangeListResp savePurchaseChangeList(SavePurchaseChangeListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/change";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseChangeListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SavePurchaseChangeListResp.newBuilder().build();
	}

	/**
	 * 买家ERP从平台获取变更单的回复信息
	 *
	 * @param req
	 * @return
	 */
	public GetPurchaseChangeReplyListResp getPurchaseChangeReplyList(GetPurchaseChangeReplyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/change/reply";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<PurchaseChangeReply> resultList = ProtoBufUtil.toProtoBufList(PurchaseChangeReply.newBuilder().build(), respJson);
		GetPurchaseChangeReplyListResp.Builder result = GetPurchaseChangeReplyListResp.newBuilder();
		result.addAllReplyList(resultList);
		return result.build();
	}

	/**
	 * 平台的变更单回复信息传到ERP之后，修改平台里面的变更单的回复状态
	 *
	 * @param req
	 * @return
	 */
	public UpdatePurchaseChangeReplyStatusResp updatePurchaseChangeReplyStatus(UpdatePurchaseChangeReplyStatusReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/change/reply";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdatePurchaseChangeReplyStatusResp.newBuilder().build();
	}
}
