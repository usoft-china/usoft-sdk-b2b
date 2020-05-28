package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * @author uas
 * @date 2020/5/27 16:49
 */
public class UasReconcileSdk extends BaseSdk {
    public UasReconcileSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public UasReconcileSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 分页查询买家应收应付企业
     *
     * @param req
     * @return
     */
    public PagingBuyerReconcileEntResp pagingBuyerReconcileEnt(PagingBuyerReconcileEntReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/reconcile/ent/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerReconcileEntResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerReconcileEntResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家应收应付企业详情
     *
     * @param req
     * @return
     */
    public GetBuyerReconcileEntDetailResp getBuyerReconcileEntDetail(GetBuyerReconcileEntDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/reconcile/ent/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerReconcileEntDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerReconcileEntDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家对账单
     *
     * @param req
     * @return
     */
    public PagingBuyerReconcileResp pagingBuyerReconcile(PagingBuyerReconcileReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/reconcile/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerReconcileResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerReconcileResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家对账单详情
     *
     * @param req
     * @return
     */
    public GetBuyerReconcileDetailResp getBuyerReconcileDetail(GetBuyerReconcileDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/reconcile/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerReconcileDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerReconcileDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 买家确认对账
     *
     * @param req
     * @return
     */
    public ConfirmBuyerReconcileResp confirmBuyerReconcile(ConfirmBuyerReconcileReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/reconcile/confirm";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ConfirmBuyerReconcileResp.Builder resp = ProtoBufUtil.toProtoBuf(ConfirmBuyerReconcileResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家应收应付企业
     *
     * @param req
     * @return
     */
    public PagingSellerReconcileEntResp pagingSellerReconcileEnt(PagingSellerReconcileEntReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/reconcile/ent/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerReconcileEntResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerReconcileEntResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家应收应付企业详情
     *
     * @param req
     * @return
     */
    public GetSellerReconcileEntDetailResp getSellerReconcileEntDetail(GetSellerReconcileEntDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/reconcile/ent/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerReconcileEntDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerReconcileEntDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家对账单
     *
     * @param req
     * @return
     */
    public PagingSellerReconcileResp pagingSellerReconcile(PagingSellerReconcileReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/reconcile/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerReconcileResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerReconcileResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家对账单详情
     *
     * @param req
     * @return
     */
    public GetSellerReconcileDetailResp getSellerReconcileDetail(GetSellerReconcileDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/reconcile/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerReconcileDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerReconcileDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 卖家确认对账
     *
     * @param req
     * @return
     */
    public ConfirmSellerReconcileResp confirmSellerReconcile(ConfirmSellerReconcileReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/reconcile/confirm";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ConfirmSellerReconcileResp.Builder resp = ProtoBufUtil.toProtoBuf(ConfirmSellerReconcileResp.newBuilder(), respJson);
        return resp.build();
    }
}
