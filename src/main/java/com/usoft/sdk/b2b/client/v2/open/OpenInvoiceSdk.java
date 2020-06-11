package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 发票sdk
 *
 * @author open
 * @date 2020/6/5 9:27
 */
public class OpenInvoiceSdk extends BaseSdk {
	public OpenInvoiceSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public OpenInvoiceSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 分页查询买家发票单
	 *
	 * @param req
	 * @return
	 */
	public PagingBuyerInvoiceResp pagingBuyerInvoice(PagingBuyerInvoiceReq.Builder req) throws Exception {
		String url = baseUrl + "/open/buyer/invoice/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingBuyerInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerInvoiceResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询买家发票单详情
	 *
	 * @param req
	 * @return
	 */
	public GetBuyerInvoiceDetailResp getBuyerInvoiceDetail(GetBuyerInvoiceDetailReq.Builder req) throws Exception {
		String url = baseUrl + "/open/buyer/invoice/detail/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetBuyerInvoiceDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerInvoiceDetailResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 开票
	 *
	 * @param req
	 * @return
	 */
	public OpenInvoiceResp openInvoice(OpenInvoiceReq.Builder req) throws Exception {
		String url = baseUrl + "/open/invoice/open";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		OpenInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(OpenInvoiceResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 分页查询卖家发票单
	 *
	 * @param req
	 * @return
	 */
	public PagingSellerInvoiceResp pagingSellerInvoice(PagingSellerInvoiceReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/invoice/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerInvoiceResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询卖家发票单详情
	 *
	 * @param req
	 * @return
	 */
	public GetSellerInvoiceDetailResp getSellerInvoiceDetail(GetSellerInvoiceDetailReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/invoice/detail/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSellerInvoiceDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerInvoiceDetailResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 批量删除发票单
	 *
	 * @param req
	 * @return
	 */
	public BatchDeleteInvoiceResp batchDeleteInvoice(BatchDeleteInvoiceReq.Builder req) throws Exception {
		String url = baseUrl + "/open/invoice/delete/batch";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		BatchDeleteInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchDeleteInvoiceResp.newBuilder(), respJson);
		return resp.build();
	}
}
