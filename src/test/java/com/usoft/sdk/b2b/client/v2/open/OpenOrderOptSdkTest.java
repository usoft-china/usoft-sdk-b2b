package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.entity.*;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/6/17 11:46
 */
public class OpenOrderOptSdkTest {
    /**
     * 测试地址
     */
    private OpenOrderOptSdk openOrderOptSdk = new OpenOrderOptSdk("https://b2btraderest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");
    @Test
    public void createOrder() throws Exception {
        CreateOrderReq.Builder req = CreateOrderReq.newBuilder();
        req.setUu(200040196);
        req.setSellerEnuu(10050624);
        req.setSellerLinkmanUu(1000027480);
        req.setCategory(10);
        req.setPaymentMethod("现结");
        req.setCurrency("RMB");
//		req.setExchangeRate(1.1);
        req.setRemark("Remarksd中");
        DeliveryAddr.Builder deliveryAddr = DeliveryAddr.newBuilder();
        deliveryAddr.setCode("DA200226268678882100");
        req.setDeliveryAddr(deliveryAddr);
        CreateOrderResp resp = openOrderOptSdk.createOrder(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void createOrderChg() throws Exception {
        CreateOrderChgReq.Builder req = CreateOrderChgReq.newBuilder();
        req.setOrderCode("OR200616229460235201");
        req.setCategory(10);
        req.setPaymentMethod("月结30天");
        req.setCurrency("RMB");
        req.setExchangeRate(2.2);
        req.setIsSellerConfirm(true);
        req.setRemark("Remarksd中");
//		req.setProcessStart("2020-03-16");
//		req.setProcessEnd("2020-04-16");
//		req.setOutsourceType("OutsourceTypeDss");
//		req.setDeliveryFactory("DeliveryFactoryDsdf");

        CreateOrderChgProduct.Builder op1 = CreateOrderChgProduct.newBuilder();
        op1.setOrderProductCode("OP200616229460235502");
        op1.setUnitPrice(0.3);
        op1.setTaxRate(0.3);
        op1.setQuantity(30);
        op1.setUnit("KPCS");
        op1.setDeliveryTime("2020-07-15");
        req.addOrderChgProduct(op1);
        req.setUu(200040196);
        CreateOrderChgResp resp = openOrderOptSdk.createOrderChg(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void createOrderRemind() throws Exception {
        CreateOrderRemindReq.Builder req = CreateOrderRemindReq.newBuilder();

        RemindOrderProduct.Builder rop = RemindOrderProduct.newBuilder();
        rop.setOrderProductCode("OP200616229460235502");
        rop.setQuantityRemind(5);
        req.addRemindOP(rop);
        req.setUu(200040196);
        CreateOrderRemindResp resp = openOrderOptSdk.createOrderRemind(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void receiveOrderDelivery() throws Exception {
        ReceiveOrderDeliveryReq.Builder req = ReceiveOrderDeliveryReq.newBuilder();
        ReceiveOrderDeliveryProduct.Builder rodp = ReceiveOrderDeliveryProduct.newBuilder();
        rodp.setOrderDeliveryProductCode("DP200616229549287104");
        rodp.setQuantityReceive(5);
        req.addReceiveODP(rodp);
        req.setUu(200040196);
        ReceiveOrderDeliveryResp resp = openOrderOptSdk.receiveOrderDelivery(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void acceptOrderReceive() throws Exception {
        AcceptOrderReceiveReq.Builder req = AcceptOrderReceiveReq.newBuilder();
        AcceptOrderReceiveProduct.Builder acceptORP = AcceptOrderReceiveProduct.newBuilder();
        acceptORP.setOrderReceiveProductCode("VP200616229554312806");
        acceptORP.setQuantityAccept(5);
        req.addAcceptORP(acceptORP);
        req.setUu(200040196);
        AcceptOrderReceiveResp resp = openOrderOptSdk.acceptOrderReceive(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void returnOrderAccept() throws Exception {
        ReturnOrderAcceptReq.Builder req = ReturnOrderAcceptReq.newBuilder();
        ReturnOrderAcceptProduct.Builder returnOAP = ReturnOrderAcceptProduct.newBuilder();
        returnOAP.setOrderAcceptProductCode("AP200616229560001108");
        returnOAP.setQuantityReturn(2);
        req.addReturnOAP(returnOAP);
        req.setUu(200040196);
        ReturnOrderAcceptResp resp = openOrderOptSdk.returnOrderAccept(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void closeOrder() throws Exception {
        CloseOrderReq.Builder req = CloseOrderReq.newBuilder();
        req.addOrderProductCode("");
        req.setUu(200040196);
        CloseOrderResp resp = openOrderOptSdk.closeOrder(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void closeOrderRemind() throws Exception {
        CloseOrderRemindReq.Builder req = CloseOrderRemindReq.newBuilder();
        req.addOrderRemindProductCode("");
        req.setUu(200040196);
        CloseOrderRemindResp resp = openOrderOptSdk.closeOrderRemind(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void replyOrderChg() throws Exception {
        ReplyOrderChgReq.Builder req = ReplyOrderChgReq.newBuilder();
        req.setOrderChgCode("CO200526046475222302");
        req.setReplyRemark("ReplyRemarksd");
        req.setReplyStatus(10);
        ReplyOrderChgResp resp = openOrderOptSdk.replyOrderChg(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void deliverOrderRemind() throws Exception {
        DeliverOrderRemindReq.Builder req = DeliverOrderRemindReq.newBuilder();
        DeliveryOrderRemindProduct.Builder dorp = DeliveryOrderRemindProduct.newBuilder();
        dorp.setOrderRemindProductCode("RP200616229527104201");
        dorp.setQuantityDelivery(5);
        req.addDeliveryORP(dorp);
        req.setUu(200040196);
        DeliverOrderRemindResp resp = openOrderOptSdk.deliverOrderRemind(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void replyOrderProduct() throws Exception {
        ReplyOrderProductReq.Builder req = ReplyOrderProductReq.newBuilder();
        ReplyOrderProductContent.Builder builder = ReplyOrderProductContent.newBuilder();
        req.setCategory(1);
        builder.setOrderProductCode("OP200616229460249003");
        builder.setQuantity(10);
        builder.setDeliveryTime("2020-07-18");
        builder.setRemark("测试");
        req.setReplyContent(builder.build());
        req.setUu(200040196);
        ReplyOrderProductResp resp = openOrderOptSdk.replyOrderProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchReplyOrderProduct() throws Exception {
        BatchReplyOrderProductReq.Builder req = BatchReplyOrderProductReq.newBuilder();
        ReplyOrderProductContent.Builder builder = ReplyOrderProductContent.newBuilder();
        req.setCategory(10);
        builder.setOrderProductCode("OP200526046405671403");
        builder.setQuantity(10);
        builder.setDeliveryTime("2020-05-18");
        builder.setRemark("测试");
        req.setUu(200040196);
        req.addReplyContent(builder.build());
        BatchReplyOrderProductResp resp = openOrderOptSdk.batchReplyOrderProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchUpdateAcceptProduct() throws Exception {
        BatchUpdateAcceptProductReq.Builder req = BatchUpdateAcceptProductReq.newBuilder();
        UpdateReq.Builder builder = UpdateReq.newBuilder();
        builder.setCode("AP200616229151040746");
        builder.setTaxRate(1);
        builder.setUnitPrice(20);
        req.addUpdateReq(builder);
        BatchUpdateAcceptProductResp resp = openOrderOptSdk.batchUpdateAcceptProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchUpdateReturnProduct() throws Exception {
        BatchUpdateReturnProductReq.Builder req = BatchUpdateReturnProductReq.newBuilder();
        UpdateReq.Builder builder = UpdateReq.newBuilder();
        builder.setCode("OP200526046405671403");
        builder.setTaxRate(1);
        builder.setUnitPrice(1);
        req.addUpdateReq(builder);
        BatchUpdateReturnProductResp resp = openOrderOptSdk.batchUpdateReturnProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchDeleteOrderAccept() throws Exception {
        BatchDeleteOrderAcceptReq.Builder req = BatchDeleteOrderAcceptReq.newBuilder();
        req.addCode("OA200616229559969107");
        BatchDeleteOrderAcceptResp resp = openOrderOptSdk.batchDeleteOrderAccept(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchDeleteOrderReturn() throws Exception {
        BatchDeleteOrderReturnReq.Builder req = BatchDeleteOrderReturnReq.newBuilder();
        req.addCode("OT200616229641056523");
        BatchDeleteOrderReturnResp resp = openOrderOptSdk.batchDeleteOrderReturn(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateDeliveryQuantity() throws Exception {
        UpdateDeliveryQuantityReq.Builder req = UpdateDeliveryQuantityReq.newBuilder();
        req.setCode("DP200624296517171307");
        req.setQuantityDelivery(8);
        UpdateDeliveryQuantityResp resp = openOrderOptSdk.updateDeliveryQuantity(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
