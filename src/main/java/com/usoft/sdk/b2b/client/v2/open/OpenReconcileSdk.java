package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import com.usoft.b2b.trade.external.open.api.protobuf.*;

import java.util.Map;

/**
 * @author uas
 * @date 2020/5/27 16:49
 */
public class OpenReconcileSdk extends BaseSdk {
    public OpenReconcileSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenReconcileSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 分页查询买家应收应付企业
     *
     * @param req
     * @return
     */
    public PagingBuyerReconcileEntResp pagingBuyerReconcileEnt(PagingBuyerReconcileEntReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/reconcile/ent/paging";
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
        String url = baseUrl + "/open/buyer/reconcile/ent/detail/get";
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
        String url = baseUrl + "/open/buyer/reconcile/paging";
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
        String url = baseUrl + "/open/buyer/reconcile/detail/get";
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
        String url = baseUrl + "/open/buyer/reconcile/confirm";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ConfirmBuyerReconcileResp.Builder resp = ProtoBufUtil.toProtoBuf(ConfirmBuyerReconcileResp.newBuilder(), respJson);
        return resp.build();
    }
}
