package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 样品sdk
 * @author open
 * @date 2020/5/27 16:32
 */
public class OpenSampleSdk extends BaseSdk {
    public OpenSampleSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenSampleSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

	/**
	 * 卖家分页查询样品申请单
	 *
	 * @param req
	 * @return
	 */
	public PagingSellerSampleApplyResp pagingSellerSampleApply(PagingSellerSampleApplyReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/sample/apply/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerSampleApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerSampleApplyResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家查询样品申请单详情
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetSellerSampleApplyResp getSellerSampleApply(GetSellerSampleApplyReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/sample/apply/detail/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSellerSampleApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerSampleApplyResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家分页查询认定单
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public PagingSellerSampleApprovalResp pagingSellerSampleApproval(PagingSellerSampleApprovalReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/sample/approval/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerSampleApprovalResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerSampleApprovalResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 送样
	 *
	 * @param req
	 * @return
	 */
	public SendSampleResp sendSample(SendSampleReq.Builder req) throws Exception {
		String url = baseUrl + "/open/sample/send";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		SendSampleResp.Builder resp = ProtoBufUtil.toProtoBuf(SendSampleResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询样品申请单送样历史
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetSampleSendHistoryResp getSampleSendHistory(GetSampleSendHistoryReq.Builder req) throws Exception {
		String url = baseUrl + "/open/sample/send/history";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSampleSendHistoryResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSampleSendHistoryResp.newBuilder(), respJson);
		return resp.build();
	}
}
