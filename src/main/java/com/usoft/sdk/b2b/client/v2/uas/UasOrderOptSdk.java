package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

/**
 * @author uas
 * @date 2020/5/28 15:00
 */
public class UasOrderOptSdk extends BaseSdk {
    public UasOrderOptSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public UasOrderOptSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 新增采购订单
     *
     * @param req
     * @return
     */
    public CreateOrderResp createOrder(CreateOrderReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/create";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreateOrderResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateOrderResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 新增采购变更单
     *
     * @param req
     * @return
     */
    public CreateOrderChgResp createOrderChg(CreateOrderChgReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/chg/create";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreateOrderChgResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateOrderChgResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 新增采购发货提醒单
     *
     * @param req
     * @return
     */
    public CreateOrderRemindResp createOrderRemind(CreateOrderRemindReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/remind/create";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreateOrderRemindResp.Builder resp = ProtoBufUtil.toProtoBuf(CreateOrderRemindResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 收货采购发货单
     *
     * @param req
     * @return
     */
    public ReceiveOrderDeliveryResp receiveOrderDelivery(ReceiveOrderDeliveryReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/delivery/receive";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ReceiveOrderDeliveryResp.Builder resp = ProtoBufUtil.toProtoBuf(ReceiveOrderDeliveryResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 验收采购收货单
     *
     * @param req
     * @return
     */
    public AcceptOrderReceiveResp acceptOrderReceive(AcceptOrderReceiveReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/receive/accept";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        AcceptOrderReceiveResp.Builder resp = ProtoBufUtil.toProtoBuf(AcceptOrderReceiveResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 验退采购验收单
     *
     * @param req
     * @return
     */
    public ReturnOrderAcceptResp returnOrderAccept(ReturnOrderAcceptReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/accept/return";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ReturnOrderAcceptResp.Builder resp = ProtoBufUtil.toProtoBuf(ReturnOrderAcceptResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 订单结案（反结案）
     *
     * @param req
     * @return
     */
    public CloseOrderResp closeOrder(CloseOrderReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/close";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CloseOrderResp.Builder resp = ProtoBufUtil.toProtoBuf(CloseOrderResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 发货提醒单结案（反结案）
     *
     * @param req
     * @return
     */
    public CloseOrderRemindResp closeOrderRemind(CloseOrderRemindReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/remind/close";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CloseOrderRemindResp.Builder resp = ProtoBufUtil.toProtoBuf(CloseOrderRemindResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 回复采购变更单
     *
     * @param req
     * @return
     */
    public ReplyOrderChgResp replyOrderChg(ReplyOrderChgReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/chg/reply";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ReplyOrderChgResp.Builder resp = ProtoBufUtil.toProtoBuf(ReplyOrderChgResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 采购发货提醒单 发货
     *
     * @param req
     * @return
     */
    public DeliverOrderRemindResp deliverOrderRemind(DeliverOrderRemindReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/remind/deliver";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        DeliverOrderRemindResp.Builder resp = ProtoBufUtil.toProtoBuf(DeliverOrderRemindResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 采购订单产品 确认或撤销回复
     *
     * @param req
     * @return
     */
    public ReplyOrderProductResp replyOrderProduct(ReplyOrderProductReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/product/reply";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        ReplyOrderProductResp.Builder resp = ProtoBufUtil.toProtoBuf(ReplyOrderProductResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 采购订单产品 批量回复
     *
     * @param req
     * @return
     */
    public BatchReplyOrderProductResp batchReplyOrderProduct(BatchReplyOrderProductReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/product/reply/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchReplyOrderProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchReplyOrderProductResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量修改卖家买家数据状态
     *
     * @param req
     * @return
     */
    public BatchUpdateDataStatusResp batchUpdateDataStatus(BatchUpdateDataStatusReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/datastatus/update/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchUpdateDataStatusResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchUpdateDataStatusResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量更新验收单产品
     *
     * @param req
     * @return
     */
    public BatchUpdateAcceptProductResp batchUpdateAcceptProduct(BatchUpdateAcceptProductReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/accept/product/update/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchUpdateAcceptProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchUpdateAcceptProductResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量更新验退单产品
     *
     * @param req
     * @return
     */
    public BatchUpdateReturnProductResp batchUpdateReturnProduct(BatchUpdateReturnProductReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/return/product/update/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchUpdateReturnProductResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchUpdateReturnProductResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量删除验收单
     *
     * @param req
     * @return
     */
    public BatchDeleteOrderAcceptResp batchDeleteOrderAccept(BatchDeleteOrderAcceptReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/accept/delete/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchDeleteOrderAcceptResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchDeleteOrderAcceptResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量删除验退单
     *
     * @param req
     * @return
     */
    public BatchDeleteOrderReturnResp batchDeleteOrderReturn(BatchDeleteOrderReturnReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/return/delete/batch";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        BatchDeleteOrderReturnResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchDeleteOrderReturnResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 批量删除验退单
     *
     * @param req
     * @return
     */
    public UpdateDeliveryQuantityResp updateDeliveryQuantity(UpdateDeliveryQuantityReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/order/delivery/quantity/update";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        UpdateDeliveryQuantityResp.Builder resp = ProtoBufUtil.toProtoBuf(UpdateDeliveryQuantityResp.newBuilder(), respJson);
        return resp.build();
    }
}
