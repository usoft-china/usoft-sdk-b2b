package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * @author uas
 * @date 2020/5/28 14:21
 */
public class OpenOrderGetSdk extends BaseSdk {
    public OpenOrderGetSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenOrderGetSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 分页查询买家采购订单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderResp pagingBuyerOrder(PagingBuyerOrderReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家采购订单详情
     *
     * @param req
     * @return
     */
    public GetBuyerOrderDetailResp getBuyerOrderDetail(GetBuyerOrderDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerOrderDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerOrderDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询可以变更的订单列表
     *
     * @param req
     * @return
     */
    public GetMayChgOrderListResp getMayChgOrderList(GetMayChgOrderListReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/list/may/chg/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetMayChgOrderListResp.Builder resp = ProtoBufUtil.toProtoBuf(GetMayChgOrderListResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家采购变更单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderChgResp pagingBuyerOrderChg(PagingBuyerOrderChgReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/chg/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderChgResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderChgResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家采购变更单详情
     *
     * @param req
     * @return
     */
    public GetBuyerOrderChgDetailResp getBuyerOrderChgDetail(GetBuyerOrderChgDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/chg/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerOrderChgDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerOrderChgDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询可以发货提醒的订单列表
     *
     * @param req
     * @return
     */
    public GetMayRemindOrderListResp getMayRemindOrderList(GetMayRemindOrderListReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/list/may/remind/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetMayRemindOrderListResp.Builder resp = ProtoBufUtil.toProtoBuf(GetMayRemindOrderListResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家采购发货提醒单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderRemindResp pagingBuyerOrderRemind(PagingBuyerOrderRemindReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/remind/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderRemindResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderRemindResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家采购发货单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderDeliveryResp pagingBuyerOrderDelivery(PagingBuyerOrderDeliveryReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/delivery/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderDeliveryResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderDeliveryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家采购收货单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderReceiveResp pagingBuyerOrderReceive(PagingBuyerOrderReceiveReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/receive/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderReceiveResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderReceiveResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家采购验收单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderAcceptResp pagingBuyerOrderAccept(PagingBuyerOrderAcceptReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/accept/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderAcceptResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderAcceptResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家采购验退单
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderReturnResp pagingBuyerOrderReturn(PagingBuyerOrderReturnReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/return/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderReturnResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderReturnResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购订单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderResp pagingSellerOrder(PagingSellerOrderReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家采购订单详情
     *
     * @param req
     * @return
     */
    public GetSellerOrderDetailResp getSellerOrderDetail(GetSellerOrderDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerOrderDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerOrderDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购变更单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderChgResp pagingSellerOrderChg(PagingSellerOrderChgReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/chg/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderChgResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderChgResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家采购变更单详情
     *
     * @param req
     * @return
     */
    public GetSellerOrderChgDetailResp getSellerOrderChgDetail(GetSellerOrderChgDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/chg/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerOrderChgDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerOrderChgDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购发货提醒单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderRemindResp pagingSellerOrderRemind(PagingSellerOrderRemindReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/remind/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderRemindResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderRemindResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购发货单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderDeliveryResp pagingSellerOrderDelivery(PagingSellerOrderDeliveryReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/delivery/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderDeliveryResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderDeliveryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购收货单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderReceiveResp pagingSellerOrderReceive(PagingSellerOrderReceiveReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/receive/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderReceiveResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderReceiveResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购验收单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderAcceptResp pagingSellerOrderAccept(PagingSellerOrderAcceptReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/accept/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderAcceptResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderAcceptResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家采购验退单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderReturnResp pagingSellerOrderReturn(PagingSellerOrderReturnReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/return/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderReturnResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderReturnResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购订单产品回复历史
     *
     * @param req
     * @return
     */
    public GetOrderProductReplyHistoryResp getOrderProductReplyHistory(GetOrderProductReplyHistoryReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/product/reply/history/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderProductReplyHistoryResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderProductReplyHistoryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购发货提醒单产品发货历史
     *
     * @param req
     * @return
     */
    public GetOrderDeliveryProductHistoryResp getOrderDeliveryProductHistory(GetOrderDeliveryProductHistoryReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/delivery/product/history/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderDeliveryProductHistoryResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderDeliveryProductHistoryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购发货单产品收货历史
     *
     * @param req
     * @return
     */
    public GetOrderReceiveProductHistoryResp getOrderReceiveProductHistory(GetOrderReceiveProductHistoryReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/receive/product/history/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderReceiveProductHistoryResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderReceiveProductHistoryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购收货单产品验收历史
     *
     * @param req
     * @return
     */
    public GetOrderAcceptProductHistoryResp getOrderAcceptProductHistory(GetOrderAcceptProductHistoryReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/accept/product/history/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderAcceptProductHistoryResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderAcceptProductHistoryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量查询订单详情
     *
     * @param req
     * @return
     */
    public BatchGetOrderDetailResp batchGetOrderDetail(BatchGetOrderDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/detail/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchGetOrderDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchGetOrderDetailResp.newBuilder(), respJson);
        return resp.build();
    }
}
