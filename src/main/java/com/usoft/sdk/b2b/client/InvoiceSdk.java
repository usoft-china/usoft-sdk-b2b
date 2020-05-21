package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.invoice.api.entity.APBill;
import com.usoft.b2b.external.erp.invoice.api.protobuf.*;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uas
 * @deprecated 废弃，请使用V2版
 * @date 2019/12/16 10:57
 */
@Deprecated
public class InvoiceSdk extends BaseSdk {


	public InvoiceSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public InvoiceSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 买家ERP-将ERP的应付发票写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveApBillsResp saveApBills(SaveApBillsReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/APBill";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<APBill> list = ProtoBufUtil.toProtoBufList(APBill.newBuilder().build(), respJson);
		SaveApBillsResp.Builder resp = SaveApBillsResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 卖家ERP-从平台获取未下载的客户应付票据
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public GetSaleAPBillsResp getSaleAPBills(GetSaleAPBillsReq req) throws IOException {
		String url = baseUrl + "/erp/sale/APBill";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<APBill> list = ProtoBufUtil.toProtoBufList(APBill.newBuilder().build(), respJson);
		GetSaleAPBillsResp.Builder resp = GetSaleAPBillsResp.newBuilder();
		resp.addAllData(list);
		return resp.build();
	}

	/**
	 * 平台的客户应付票据传到供应商ERP之后，修改平台里面的客户应付票据的上传状态
	 *
	 * @param req
	 * @return
	 * @throws IOException
	 */
	public OnSaleAPBillDownSuccessResp onSaleAPBillDownSuccess(OnSaleAPBillDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/APBill";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSaleAPBillDownSuccessResp.newBuilder().build();
	}
}
