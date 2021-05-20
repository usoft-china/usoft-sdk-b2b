package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 招投标sdk
 * @author open
 * @date 2020/5/27 16:32
 */
public class OpenBiddingSdk extends BaseSdk {
    public OpenBiddingSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenBiddingSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

	/**
	 * 新增招标单
	 *
	 * @param req
	 * @return
	 */
	public CreateBiddingResp createBidding(CreateBiddingReq.Builder req) throws Exception {
		String url = baseUrl + "/open/bidding/create";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		CreateBiddingResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateBiddingResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 分页查询买家招标单
	 *
	 * @param req
	 * @return
	 */
	public PagingBuyerBiddingResp pagingBuyerBidding(PagingBuyerBiddingReq.Builder req) throws Exception {
		String url = baseUrl + "/open/buyer/bidding/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingBuyerBiddingResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerBiddingResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询买家招标单详情
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetBuyerBiddingDetailResp getBuyerBiddingDetail(GetBuyerBiddingDetailReq.Builder req) throws Exception {
		String url = baseUrl + "/open/buyer/bidding/detail/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetBuyerBiddingDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerBiddingDetailResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 回复招标单产品投标 定标或不定标
	 *
	 * @param req
	 * @return
	 */
	public ReplyBiddingProductTenderResp replyBiddingProductTender(ReplyBiddingProductTenderReq.Builder req) throws Exception {
		String url = baseUrl + "/open/bidding/product/tender/reply";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		ReplyBiddingProductTenderResp.Builder resp = ProtoBufUtil.toProtoBuf(ReplyBiddingProductTenderResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 分页查询卖家招标单
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public PagingSellerBiddingResp pagingSellerBidding(PagingSellerBiddingReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/bidding/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerBiddingResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerBiddingResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询卖家招标单详情
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetSellerBiddingDetailResp getSellerBiddingDetail(GetSellerBiddingDetailReq.Builder req) throws Exception {
		String url = baseUrl + "/open/seller/bidding/detail/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSellerBiddingDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerBiddingDetailResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 招标单产品投标与修改
	 *
	 * @param req
	 * @return
	 */
	public TenderBiddingProductResp tenderBiddingProduct(TenderBiddingProductReq.Builder req) throws Exception {
		String url = baseUrl + "/open/bidding/product/tender";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		TenderBiddingProductResp.Builder resp = ProtoBufUtil.toProtoBuf(TenderBiddingProductResp.newBuilder(), respJson);
		return resp.build();
	}
}
