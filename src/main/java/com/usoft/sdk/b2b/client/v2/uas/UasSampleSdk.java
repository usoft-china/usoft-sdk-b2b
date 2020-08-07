package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 样品sdk
 *
 * @author uas
 * @date 2020/8/7 16:27
 */
public class UasSampleSdk extends BaseSdk {
	public UasSampleSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public UasSampleSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 新增样品申请单
	 *
	 * @param req
	 * @return
	 */
	public CreateSampleApplyResp createSampleApply(CreateSampleApplyReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/sample/apply/create";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		CreateSampleApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateSampleApplyResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 作废样品申请单
	 *
	 * @param req
	 * @return
	 */
	public CancelSampleApplyResp cancelSampleApply(CancelSampleApplyReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/sample/apply/cancel";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		CancelSampleApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(CancelSampleApplyResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 买家分页查询样品送样单
	 *
	 * @param req
	 * @return
	 */
	public PagingBuyerSampleSendResp pagingBuyerSampleSend(PagingBuyerSampleSendReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/buyer/sample/send/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingBuyerSampleSendResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerSampleSendResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 新增样品认定单
	 *
	 * @param req
	 * @return
	 */
	public CreateSampleApprovalResp createSampleApproval(CreateSampleApprovalReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/sample/approval/create";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		CreateSampleApprovalResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateSampleApprovalResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 买家分页查询样品送样单
	 *
	 * @param req
	 * @return
	 */
	public PagingSellerSampleApplyResp pagingSellerSampleApply(PagingSellerSampleApplyReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/seller/sample/apply/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerSampleApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerSampleApplyResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 送样
	 *
	 * @param req
	 * @return
	 */
	public SendSampleResp sendSample(SendSampleReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/sample/send";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		SendSampleResp.Builder resp = ProtoBufUtil.toProtoBuf(SendSampleResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家分页查询认定单
	 *
	 * @param req
	 * @return
	 */
	public PagingSellerSampleApprovalResp pagingSellerSampleApproval(PagingSellerSampleApprovalReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/seller/sample/approval/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerSampleApprovalResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerSampleApprovalResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询样品申请单列表
	 *
	 * @param req
	 * @return
	 */
	public GetSampleApplyListResp getSampleApplyList(GetSampleApplyListReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/sample/apply/list";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSampleApplyListResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSampleApplyListResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 批量修改样品卖家买家数据状态
	 *
	 * @param req
	 * @return
	 */
	public BatchUpdateSampleDataStatusResp batchUpdateSampleDataStatus(BatchUpdateSampleDataStatusReq.Builder req) throws Exception {
		String url = baseUrl + "/uas/sample/datastatus/update/batch";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		BatchUpdateSampleDataStatusResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchUpdateSampleDataStatusResp.newBuilder(), respJson);
		return resp.build();
	}
}
