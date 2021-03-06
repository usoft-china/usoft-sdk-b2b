package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * @author open
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
     * 分页查询订单产品回复
     *
     * @param req
     * @return
     */
    public PagingBuyerOrderProductReplyResp pagingBuyerOrderProductReply(PagingBuyerOrderProductReplyReq.Builder req) throws Exception {
        String url = baseUrl + "/open/buyer/order/product/reply/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerOrderProductReplyResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerOrderProductReplyResp.newBuilder(), respJson);
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
     * 分页查询订单产品回复
     *
     * @param req
     * @return
     */
    public PagingSellerOrderProductReplyResp pagingSellerOrderProductReply(PagingSellerOrderProductReplyReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/product/reply/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderProductReplyResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderProductReplyResp.newBuilder(), respJson);
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

    /**
     * 批量查询订单产品
     *
     * @param req
     * @return
     */
    public BatchGetOrderProductResp batchGetOrderProduct(BatchGetOrderProductReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/product/get/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchGetOrderProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchGetOrderProductResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购发货提醒单详情
     *
     * @param req
     * @return
     */
    public GetOrderRemindDetailResp getOrderRemindDetail(GetOrderRemindDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/remind/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderRemindDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderRemindDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购发货单详情
     *
     * @param req
     * @return
     */
    public GetOrderDeliveryDetailResp getOrderDeliveryDetail(GetOrderDeliveryDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/delivery/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderDeliveryDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderDeliveryDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购收货单详情
     *
     * @param req
     * @return
     */
    public GetOrderReceiveDetailResp getOrderReceiveDetail(GetOrderReceiveDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/receive/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderReceiveDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderReceiveDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购验收单详情
     *
     * @param req
     * @return
     */
    public GetOrderAcceptDetailResp getOrderAcceptDetail(GetOrderAcceptDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/accept/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderAcceptDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderAcceptDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询采购验退单详情
     *
     * @param req
     * @return
     */
    public GetOrderReturnDetailResp getOrderReturnDetail(GetOrderReturnDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/open/order/return/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetOrderReturnDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetOrderReturnDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家MRB单
     *
     * @param req
     * @return
     */
    public PagingSellerOrderMrbResp pagingSellerOrderMrb(PagingSellerOrderMrbReq.Builder req) throws Exception {
        String url = baseUrl + "/open/seller/order/mrb/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerOrderMrbResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerOrderMrbResp.newBuilder(), respJson);
        return resp.build();
    }
}
