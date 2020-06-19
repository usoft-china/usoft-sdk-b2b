package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 询报价sdk
 * @author open
 * @date 2020/6/19 13:59
 */
public class OpenDemandSdk extends BaseSdk {
    public OpenDemandSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenDemandSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 新增询价单
     *
     * @param req
     * @return
     */
    public CreateDemandResp createDemand(CreateDemandReq.Builder req) throws Exception {
        String url = baseUrl + "/open/demand/create";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreateDemandResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateDemandResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家询价单
     *
     * @param req
     * @return
     */
    public PagingBuyerDemandResp pagingBuyerDemand(PagingBuyerDemandReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/demand/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerDemandResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerDemandResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家询价单详情
     *
     * @param req
     * @return
     */
    public GetBuyerDemandDetailResp getBuyerDemandDetail(GetBuyerDemandDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/demand/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerDemandDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerDemandDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 回复询价单产品报价 采纳或拒绝
     *
     * @param req
     * @return
     */
    public ReplyDemandProductOfferResp replyDemandProductOffer(ReplyDemandProductOfferReq.Builder req) throws Exception {
        String url = baseUrl + "/open/demand/product/offer/reply";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ReplyDemandProductOfferResp.Builder resp = ProtoBufUtil.toProtoBuf(ReplyDemandProductOfferResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家询价单详情列表
     *
     * @param req
     * @return
     */
    public GetBuyerDemandListResp getBuyerDemandList(GetBuyerDemandListReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/demand/list/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerDemandListResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerDemandListResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家询价单
     *
     * @param req
     * @return
     */
    public PagingSellerDemandResp pagingSellerDemand(PagingSellerDemandReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/demand/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerDemandResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerDemandResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家询价单详情
     *
     * @param req
     * @return
     */
    public GetSellerDemandDetailResp getSellerDemandDetail(GetSellerDemandDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/demand/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerDemandDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerDemandDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 询价单产品报价与修改
     *
     * @param req
     * @return
     */
    public OfferDemandProductResp offerDemandProduct(OfferDemandProductReq.Builder req) throws Exception {
        String url = baseUrl + "/open/demand/product/offer";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        OfferDemandProductResp.Builder resp = ProtoBufUtil.toProtoBuf(OfferDemandProductResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量失效询价单产品
     *
     * @param req
     * @return
     */
    public BatchInvalidDemandProductResp batchInvalidDemandProduct(BatchInvalidDemandProductReq.Builder req) throws Exception {
        String url = baseUrl + "/open/demand/product/invalid/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchInvalidDemandProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchInvalidDemandProductResp.newBuilder(), respJson);
        return resp.build();
    }
}
