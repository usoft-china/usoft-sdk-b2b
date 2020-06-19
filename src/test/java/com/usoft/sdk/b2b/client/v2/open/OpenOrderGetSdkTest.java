package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/6/17 11:25
 */
public class OpenOrderGetSdkTest {
    /**
     * 测试地址
     */
    private OpenOrderGetSdk openOrderGetSdk = new OpenOrderGetSdk("https://b2btraderest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");
    @Test
    public void pagingBuyerOrder() throws Exception {
        PagingBuyerOrderReq.Builder req = PagingBuyerOrderReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderResp resp = openOrderGetSdk.pagingBuyerOrder(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerOrderDetail() throws Exception {
        GetBuyerOrderDetailReq.Builder req = GetBuyerOrderDetailReq.newBuilder();
        req.setOrderCode("OR200526046405671102");
        GetBuyerOrderDetailResp resp = openOrderGetSdk.getBuyerOrderDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerOrderChg() throws Exception {
        PagingBuyerOrderChgReq.Builder req = PagingBuyerOrderChgReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderChgResp resp = openOrderGetSdk.pagingBuyerOrderChg(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerOrderChgDetail() throws Exception {
        GetBuyerOrderChgDetailReq.Builder req = GetBuyerOrderChgDetailReq.newBuilder();
        req.setCode("CO200526046475222302");
        GetBuyerOrderChgDetailResp resp = openOrderGetSdk.getBuyerOrderChgDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerOrderRemind() throws Exception {
        PagingBuyerOrderRemindReq.Builder req = PagingBuyerOrderRemindReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderRemindResp resp = openOrderGetSdk.pagingBuyerOrderRemind(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerOrderDelivery() throws Exception {
        PagingBuyerOrderDeliveryReq.Builder req = PagingBuyerOrderDeliveryReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderDeliveryResp resp = openOrderGetSdk.pagingBuyerOrderDelivery(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerOrderReceive() throws Exception {
        PagingBuyerOrderReceiveReq.Builder req = PagingBuyerOrderReceiveReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderReceiveResp resp = openOrderGetSdk.pagingBuyerOrderReceive(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerOrderAccept() throws Exception {
        PagingBuyerOrderAcceptReq.Builder req = PagingBuyerOrderAcceptReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderAcceptResp resp = openOrderGetSdk.pagingBuyerOrderAccept(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerOrderReturn() throws Exception {
        PagingBuyerOrderReturnReq.Builder req = PagingBuyerOrderReturnReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingBuyerOrderReturnResp resp = openOrderGetSdk.pagingBuyerOrderReturn(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }



    @Test
    public void pagingSellerOrder() throws Exception {
        PagingSellerOrderReq.Builder req = PagingSellerOrderReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderResp resp = openOrderGetSdk.pagingSellerOrder(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerOrderDetail() throws Exception {
        GetSellerOrderDetailReq.Builder req = GetSellerOrderDetailReq.newBuilder();
        req.setOrderCode("OR200526046405671102");
        GetSellerOrderDetailResp resp = openOrderGetSdk.getSellerOrderDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerOrderChg() throws Exception {
        PagingSellerOrderChgReq.Builder req = PagingSellerOrderChgReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderChgResp resp = openOrderGetSdk.pagingSellerOrderChg(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerOrderChgDetail() throws Exception {
        GetSellerOrderChgDetailReq.Builder req = GetSellerOrderChgDetailReq.newBuilder();
        req.setCode("CO200526046475222302");
        GetSellerOrderChgDetailResp resp = openOrderGetSdk.getSellerOrderChgDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerOrderRemind() throws Exception {
        PagingSellerOrderRemindReq.Builder req = PagingSellerOrderRemindReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderRemindResp resp = openOrderGetSdk.pagingSellerOrderRemind(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerOrderDelivery() throws Exception {
        PagingSellerOrderDeliveryReq.Builder req = PagingSellerOrderDeliveryReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderDeliveryResp resp = openOrderGetSdk.pagingSellerOrderDelivery(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerOrderReceive() throws Exception {
        PagingSellerOrderReceiveReq.Builder req = PagingSellerOrderReceiveReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderReceiveResp resp = openOrderGetSdk.pagingSellerOrderReceive(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerOrderAccept() throws Exception {
        PagingSellerOrderAcceptReq.Builder req = PagingSellerOrderAcceptReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderAcceptResp resp = openOrderGetSdk.pagingSellerOrderAccept(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerOrderReturn() throws Exception {
        PagingSellerOrderReturnReq.Builder req = PagingSellerOrderReturnReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        req.setKeywords("wc");
        req.setStartTime("2020-03-24");
        req.setEndTime("2020-07-24");
        PagingSellerOrderReturnResp resp = openOrderGetSdk.pagingSellerOrderReturn(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchGetOrderDetail() throws Exception {
        BatchGetOrderDetailReq.Builder req = BatchGetOrderDetailReq.newBuilder();
        req.addCode("OR200508892251984128");
        req.addCode("OR200506875276648009");
        BatchGetOrderDetailResp resp = openOrderGetSdk.batchGetOrderDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchGetOrderProduct() throws Exception {
        BatchGetOrderProductReq.Builder req = BatchGetOrderProductReq.newBuilder();
        req.addCode("OR200508892251984128");
        req.addCode("OR200506875276648009");
        BatchGetOrderProductResp resp = openOrderGetSdk.batchGetOrderProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getOrderRemindDetail() throws Exception {
        GetOrderRemindDetailReq.Builder req = GetOrderRemindDetailReq.newBuilder();
        req.setOrderRemindCode("OR200508892251984128");
        GetOrderRemindDetailResp resp = openOrderGetSdk.getOrderRemindDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getOrderDeliveryDetail() throws Exception {
        GetOrderDeliveryDetailReq.Builder req = GetOrderDeliveryDetailReq.newBuilder();
        req.setOrderDeliveryCode("OR200508892251984128");
        GetOrderDeliveryDetailResp resp = openOrderGetSdk.getOrderDeliveryDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getOrderReceiveDetail() throws Exception {
        GetOrderReceiveDetailReq.Builder req = GetOrderReceiveDetailReq.newBuilder();
        req.setOrderReceiveCode("OR200508892251984128");
        GetOrderReceiveDetailResp resp = openOrderGetSdk.getOrderReceiveDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getOrderAcceptDetail() throws Exception {
        GetOrderAcceptDetailReq.Builder req = GetOrderAcceptDetailReq.newBuilder();
        req.setOrderAcceptCode("OR200508892251984128");
        GetOrderAcceptDetailResp resp = openOrderGetSdk.getOrderAcceptDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getOrderReturnDetail() throws Exception {
        GetOrderReturnDetailReq.Builder req = GetOrderReturnDetailReq.newBuilder();
        req.setOrderReturnCode("OR200508892251984128");
        GetOrderReturnDetailResp resp = openOrderGetSdk.getOrderReturnDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
