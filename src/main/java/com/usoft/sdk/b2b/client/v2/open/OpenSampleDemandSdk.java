package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 样品询报价sdk
 * @author open
 * @date 2020/6/19 13:59
 */
public class OpenSampleDemandSdk extends BaseSdk {
    public OpenSampleDemandSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenSampleDemandSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 新增询价单
     *
     * @param req
     * @return
     */
    public CreateSampleDemandResp createSampleDemand(CreateSampleDemandReq.Builder req) throws Exception {
        String url = baseUrl + "/open/sample/demand/create";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreateSampleDemandResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateSampleDemandResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家询价单
     *
     * @param req
     * @return
     */
    public PagingBuyerSampleDemandResp pagingBuyerSampleDemand(PagingBuyerSampleDemandReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/sample/demand/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerSampleDemandResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerSampleDemandResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家询价单详情
     *
     * @param req
     * @return
     */
    public GetBuyerSampleDemandDetailResp getBuyerSampleDemandDetail(GetBuyerSampleDemandDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/sample/demand/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerSampleDemandDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerSampleDemandDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 回复询价单产品报价 采纳或拒绝
     *
     * @param req
     * @return
     */
    public ReplySampleDemandProductOfferResp replySampleDemandProductOffer(ReplySampleDemandProductOfferReq.Builder req) throws Exception {
        String url = baseUrl + "/open/sample/demand/product/offer/reply";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ReplySampleDemandProductOfferResp.Builder resp = ProtoBufUtil.toProtoBuf(ReplySampleDemandProductOfferResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家询价单详情列表
     *
     * @param req
     * @return
     */
    public GetBuyerSampleDemandListResp getBuyerSampleDemandList(GetBuyerSampleDemandListReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/sample/demand/list/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerSampleDemandListResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerSampleDemandListResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家询价单
     *
     * @param req
     * @return
     */
    public PagingSellerSampleDemandResp pagingSellerSampleDemand(PagingSellerSampleDemandReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/sample/demand/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerSampleDemandResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerSampleDemandResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家询价单详情
     *
     * @param req
     * @return
     */
    public GetSellerSampleDemandDetailResp getSellerSampleDemandDetail(GetSellerSampleDemandDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/sample/demand/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerSampleDemandDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerSampleDemandDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 询价单产品报价与修改
     *
     * @param req
     * @return
     */
    public OfferSampleDemandProductResp offerSampleDemandProduct(OfferSampleDemandProductReq.Builder req) throws Exception {
        String url = baseUrl + "/open/sample/demand/product/offer";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        OfferSampleDemandProductResp.Builder resp = ProtoBufUtil.toProtoBuf(OfferSampleDemandProductResp.newBuilder(), respJson);
        return resp.build();
    }
}
