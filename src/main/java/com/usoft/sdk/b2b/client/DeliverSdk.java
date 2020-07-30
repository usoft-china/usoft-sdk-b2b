package com.usoft.sdk.b2b.client;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.usoft.b2b.external.erp.deliver.api.entity.*;
import com.usoft.b2b.external.erp.deliver.api.protobuf.*;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uas
 * @date 2019/12/16 15:46
 * @deprecated 废弃，请使用V2版
 */
@Deprecated
public class DeliverSdk extends BaseSdk {

	public DeliverSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public DeliverSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 将ERP的送货提醒写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseNotifyResp savePurchaseNotify(SavePurchaseNotifyReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseNotify> list = ProtoBufUtil.toProtoBufList(PurchaseNotify.newBuilder().build(), respJson);
		SavePurchaseNotifyResp.Builder resp = SavePurchaseNotifyResp.newBuilder();
		resp.addAllPurchaseNotifyList(list);
		return resp.build();
	}

	/**
	 * 从买家ERP获取平台的发货单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetAcceptNotifyListResp getAcceptNotifyList(GetAcceptNotifyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/accept";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<AcceptNotify> list = ProtoBufUtil.toProtoBufList(AcceptNotify.newBuilder().build(), respJson);
		GetAcceptNotifyListResp.Builder resp = GetAcceptNotifyListResp.newBuilder();
		resp.addAllAcceptNotifyList(list);
		return resp.build();
	}

	/**
	 * 从买家ERP获取平台的发货单
	 *
	 * @param req
	 * @return
	 */
	public UpdateAcceptNotifyStatusResp updateAcceptNotifyStatus(UpdateAcceptNotifyStatusReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/accept/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdstr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateAcceptNotifyStatusResp.newBuilder().build();
	}

	/**
	 * 买家ERP主动收料的记录上传到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveAcceptNotifyListResp saveAcceptNotify(SaveAcceptNotifyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/accept";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getAcceptNotifyListList()));

		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<AcceptNotify> list = ProtoBufUtil.toProtoBufList(AcceptNotify.newBuilder().build(), respJson);
		SaveAcceptNotifyListResp.Builder resp = SaveAcceptNotifyListResp.newBuilder();
		resp.addAllAcceptNotifyList(list);
		return resp.build();
	}

	/**
	 * 买家结案送货提醒后，传到平台
	 *
	 * @param req
	 * @return
	 */
	public UpdatePurchaseNotifyEndResp updatePurchaseNotifyEnd(UpdatePurchaseNotifyEndReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/end";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));

		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<String> list = JSONObject.parseArray(respJson, String.class);
		UpdatePurchaseNotifyEndResp.Builder resp = UpdatePurchaseNotifyEndResp.newBuilder();
//        resp.addAllIdStr(list);
		return resp.build();
	}

	/**
	 * 每天定时观察校验送货提醒
	 *
	 * @param req
	 * @return
	 */
	public CheckPurchaseNotifyResp checkPurchaseNotify(CheckPurchaseNotifyReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/endCheck";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return CheckPurchaseNotifyResp.newBuilder().build();
	}

	/**
	 * 买家修改收料通知的数量后，写回到平台（UAS点全部拒收）
	 *
	 * @param req
	 * @return
	 */
	public SaveAcceptNotifyConfirmListResp saveAcceptNotifyConfirm(SaveAcceptNotifyConfirmListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/accept/confirm";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getAcceptNotifyConfirmListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveAcceptNotifyConfirmListResp.newBuilder().build();
	}

	/**
	 * 买家收料通知转收料单的数量，写回到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveAcceptNotifyVerifyListResp saveAcceptNotifyVerify(SaveAcceptNotifyVerifyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/accept/verify";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getVerifyListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveAcceptNotifyVerifyListResp.newBuilder().build();
	}

	/**
	 * 买家反审核收料单的数量，写回到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveUnAcceptNotifyVerifyListResp saveUnAcceptNotifyVerify(SaveUnAcceptNotifyVerifyListReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/notice/accept/unverify";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getVerifyListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveUnAcceptNotifyVerifyListResp.newBuilder().build();
	}

	/**
	 * 通过上传id查询平台送货提醒对应的id
	 *
	 * @param req
	 * @return
	 */
	public GetPurchaseNotifyB2bIdResp getPurchaseNotifyB2bId(GetPurchaseNotifyB2bIdReq req) throws IOException {
		String url = baseUrl + "/erp/buyer/notify";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseNotify> resultList = ProtoBufUtil.toProtoBufList(PurchaseNotify.newBuilder().build(), respJson);
		GetPurchaseNotifyB2bIdResp.Builder result = GetPurchaseNotifyB2bIdResp.newBuilder();
		result.addAllPurchaseNotifyList(resultList);
		return result.build();
	}

	/**
	 * 将ERP的采购验收单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseProdInOutResp savePurchaseProdInOut(SavePurchaseProdInOutReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodInOut";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));

		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseProdInOut> list = ProtoBufUtil.toProtoBufList(PurchaseProdInOut.newBuilder().build(), respJson);
		SavePurchaseProdInOutResp.Builder resp = SavePurchaseProdInOutResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 将ERP的反过账的采购验收单写到平台
	 *
	 * @param req
	 * @return
	 */
	public NonPostingProdInOutResp nonPostingProdInOut(NonPostingProdInOutReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodInOut/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return NonPostingProdInOutResp.newBuilder().build();
	}

	/**
	 * 批量更新采购验收单单价
	 *
	 * @param req
	 * @return
	 */
	public RefreshPriceResp refreshPrice(RefreshPriceReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodInOut/refreshPrice";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return RefreshPriceResp.newBuilder().build();
	}


	/**
	 * 将ERP的不良品入库单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseProdBadInResp savePurchaseProdBadIn(SavePurchaseProdBadInReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodBadIn";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));

		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseProdInOut> list = ProtoBufUtil.toProtoBufList(PurchaseProdInOut.newBuilder().build(), respJson);
		SavePurchaseProdBadInResp.Builder resp = SavePurchaseProdBadInResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 将ERP的反过账的不良品入库单写到平台
	 *
	 * @param req
	 * @return
	 */
	public NonPostingProdBadInResp nonPostingProdBadIn(NonPostingProdBadInReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodBadIn/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return NonPostingProdBadInResp.newBuilder().build();
	}

	/**
	 * 将ERP的采购验退单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseProdReturnResp savePurchaseProdReturn(SavePurchaseProdReturnReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodReturn";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));

		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseProdInOut> list = ProtoBufUtil.toProtoBufList(PurchaseProdInOut.newBuilder().build(), respJson);
		SavePurchaseProdReturnResp.Builder resp = SavePurchaseProdReturnResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 将ERP的反过账的采购验退单写到平台
	 *
	 * @param req
	 * @return
	 */
	public NonPostingProdReturnResp nonPostingProdReturn(NonPostingProdReturnReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodReturn/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return NonPostingProdReturnResp.newBuilder().build();
	}

	/**
	 * 批量更新采购验退单单价
	 *
	 * @param req
	 * @return
	 */
	public RefreshPriceForPurcReturnResp refreshPriceForPurcReturn(RefreshPriceForPurcReturnReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodInOut/refreshPrice/purc/return";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return RefreshPriceForPurcReturnResp.newBuilder().build();
	}

	/**
	 * 将ERP的不良品出库单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseProdBadOutResp savePurchaseProdBadOut(SavePurchaseProdBadOutReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodBadOut";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));

		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseProdInOut> list = ProtoBufUtil.toProtoBufList(PurchaseProdInOut.newBuilder().build(), respJson);
		SavePurchaseProdBadOutResp.Builder resp = SavePurchaseProdBadOutResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 将ERP的反过账的不良品出库单写到平台
	 *
	 * @param req
	 * @return
	 */
	public NonPostingProdBadOutResp nonPostingProdBadOut(NonPostingProdBadOutReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/prodBadOut/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return NonPostingProdBadOutResp.newBuilder().build();
	}

	/**
	 * 将ERP的MRB单据上传到平台
	 *
	 * @param req
	 * @return
	 */
	public SavePurchaseMrbResp savePurchaseMrb(SavePurchaseMrbReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/MRB";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<PurchaseQuaMRB> list = ProtoBufUtil.toProtoBufList(PurchaseQuaMRB.newBuilder().build(), respJson);
		SavePurchaseMrbResp.Builder resp = SavePurchaseMrbResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 卖家ERP从平台获取客户送货提醒
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleNotifyDownListResp getSaleNotifyDownList(GetSaleNotifyDownListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleNotifyDown> list = ProtoBufUtil.toProtoBufList(SaleNotifyDown.newBuilder().build(), respJson);
		GetSaleNotifyDownListResp.Builder resp = GetSaleNotifyDownListResp.newBuilder();
		resp.addAllSaleNotifyDownList(list);
		return resp.build();
	}

	/**
	 * 卖家ERP从平台获取客户送货提醒
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleNotifyDownStatusResp updateSaleNotifyDownStatus(UpdateSaleNotifyDownStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleNotifyDownStatusResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取客户送货提醒
	 *
	 * @param req
	 * @return
	 */
	public SaveSaleOutListResp saveSaleOutList(SaveSaleOutListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice/send";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getSaleOutListList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveSaleOutListResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取在平台维护的发货单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleOutListResp getSaleOutList(GetSaleOutListReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice/send";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleOut> list = ProtoBufUtil.toProtoBufList(SaleOut.newBuilder().build(), respJson);
		GetSaleOutListResp.Builder resp = GetSaleOutListResp.newBuilder();
		resp.addAllSaleOutList(list);
		return resp.build();
	}

	/**
	 * 平台的发货单传到供应商ERP之后，修改平台里面的发货单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleOutStatusResp updateSaleOutStatus(UpdateSaleOutStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice/send/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleOutStatusResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取结案、反结案客户送货提醒
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleNotifyEndResp getSaleNotifyEnd(GetSaleNotifyEndReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice/end";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleNotifyDownEnd> list = ProtoBufUtil.toProtoBufList(SaleNotifyDownEnd.newBuilder().build(), respJson);
		GetSaleNotifyEndResp.Builder resp = GetSaleNotifyEndResp.newBuilder();
		resp.addAllEndList(list);
		return resp.build();
	}

	/**
	 * 平台的结案、反结案客户送货提醒单传到供应商ERP之后，修改平台里面的上传状态
	 *
	 * @param req
	 * @return
	 */
	public UpdateSaleNotifyDownEndStatusResp updateSaleNotifyDownEndStatus(UpdateSaleNotifyDownEndStatusReq req) throws IOException {
		String url = baseUrl + "/erp/sale/notice/end/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return UpdateSaleNotifyDownEndStatusResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载的客户采购验收单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleProdInOutResp getSaleProdInOut(GetSaleProdInOutReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodInOut";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleProdInOutDown> list = ProtoBufUtil.toProtoBufList(SaleProdInOutDown.newBuilder().build(), respJson);
		GetSaleProdInOutResp.Builder resp = GetSaleProdInOutResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户采购验收单传到供应商ERP之后，修改平台里面的客户采购验收单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSaleProdInOutSuccessResp onSaleProdInOutSuccess(OnSaleProdInOutSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodInOut";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSaleProdInOutSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载客户已反过帐的的客户采购验收单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetNonPostingSaleProdInOutResp getNonPostingSaleProdInOut(GetNonPostingSaleProdInOutReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodInOut/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<Long> list = JSON.parseArray(respJson, Long.class);
		GetNonPostingSaleProdInOutResp.Builder resp = GetNonPostingSaleProdInOutResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户采购验收单传到供应商ERP之后，修改平台里面的客户采购验收单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnNonPostingSaleProdInOutSuccessResp onNonPostingSaleProdInOutSuccess(OnNonPostingSaleProdInOutSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodInOut/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnNonPostingSaleProdInOutSuccessResp.newBuilder().build();
	}


	/**
	 * 卖家ERP从平台获取未下载的客户不良品入库单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleProdBadInResp getSaleProdBadIn(GetSaleProdBadInReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadIn";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleProdInOutDown> list = ProtoBufUtil.toProtoBufList(SaleProdInOutDown.newBuilder().build(), respJson);
		GetSaleProdBadInResp.Builder resp = GetSaleProdBadInResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户不良品入库单传到供应商ERP之后，修改平台里面的客户不良品入库单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSaleProdBadInSuccessResp onSaleProdBadInSuccess(OnSaleProdBadInSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadIn";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSaleProdBadInSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载客户已反过帐的的客户不良品入库单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetNonPostingSaleProdBadInResp getNonPostingSaleProdBadIn(GetNonPostingSaleProdBadInReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadIn/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<Long> list = JSON.parseArray(respJson, Long.class);
		GetNonPostingSaleProdBadInResp.Builder resp = GetNonPostingSaleProdBadInResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户不良品入库单传到供应商ERP之后，修改平台里面的客户不良品入库单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnNonPostingSaleProdBadInSuccessResp onNonPostingSaleProdBadInSuccess(OnNonPostingSaleProdBadInSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadIn/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnNonPostingSaleProdBadInSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载的客户采购验退单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleProdReturnResp getSaleProdReturn(GetSaleProdReturnReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodReturn";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleProdInOutDown> list = ProtoBufUtil.toProtoBufList(SaleProdInOutDown.newBuilder().build(), respJson);
		GetSaleProdReturnResp.Builder resp = GetSaleProdReturnResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户采购验退单传到供应商ERP之后，修改平台里面的客户采购验退单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSaleProdReturnSuccessResp onSaleProdReturnSuccess(OnSaleProdReturnSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodReturn";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSaleProdReturnSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载客户已反过帐的的客户采购验退单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetNonPostingSaleProdReturnResp getNonPostingSaleProdReturn(GetNonPostingSaleProdReturnReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodReturn/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<Long> list = JSON.parseArray(respJson, Long.class);
		GetNonPostingSaleProdReturnResp.Builder resp = GetNonPostingSaleProdReturnResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户采购验退单传到供应商ERP之后，修改平台里面的客户采购验退单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnNonPostingSaleProdReturnSuccessResp onNonPostingSaleProdReturnSuccess(OnNonPostingSaleProdReturnSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodReturn/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnNonPostingSaleProdReturnSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载的客户不良品出库单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleProdBadOutResp getSaleProdBadOut(GetSaleProdBadOutReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadOut";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleProdInOutDown> list = ProtoBufUtil.toProtoBufList(SaleProdInOutDown.newBuilder().build(), respJson);
		GetSaleProdBadOutResp.Builder resp = GetSaleProdBadOutResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户不良品出库单传到供应商ERP之后，修改平台里面的客户不良品出库单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSaleProdBadOutSuccessResp onSaleProdBadOutSuccess(OnSaleProdBadOutSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadOut";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSaleProdBadOutSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载客户已反过帐的的客户不良品出库单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetNonPostingSaleProdBadOutResp getNonPostingSaleProdBadOut(GetNonPostingSaleProdBadOutReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadOut/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<Long> list = JSON.parseArray(respJson, Long.class);
		GetNonPostingSaleProdBadOutResp.Builder resp = GetNonPostingSaleProdBadOutResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户不良品出库单传到供应商ERP之后，修改平台里面的客户不良品出库单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnNonPostingSaleProdBadOutSuccessResp onNonPostingSaleProdBadOutSuccess(OnNonPostingSaleProdBadOutSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/prodBadOut/nonPosting";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnNonPostingSaleProdBadOutSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未下载的MRB单
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleMrbResp getSaleMrb(GetSaleMrbReq req) throws IOException {
		String url = baseUrl + "/erp/sale/MRB";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleQuaMRB> list = ProtoBufUtil.toProtoBufList(SaleQuaMRB.newBuilder().build(), respJson);
		GetSaleMrbResp.Builder resp = GetSaleMrbResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的MRB单传到供应商ERP之后，修改平台里面的MRB单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSaleMrbSuccessResp onSaleMrbSuccess(OnSaleMrbSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/MRB";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSaleMrbSuccessResp.newBuilder().build();
	}
}
