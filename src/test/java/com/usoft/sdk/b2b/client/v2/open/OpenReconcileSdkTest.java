package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.entity.SendReconcileProduct;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/6/17 11:02
 */
public class OpenReconcileSdkTest {
    /**
     * 测试地址
     */
    private OpenReconcileSdk openReconcileSdk = new OpenReconcileSdk("https://b2btraderest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");
    @Test
    public void pagingBuyerReconcile() throws Exception {
        PagingBuyerReconcileReq.Builder req = PagingBuyerReconcileReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingBuyerReconcileResp resp = openReconcileSdk.pagingBuyerReconcile(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerReconcileDetail() throws Exception {
        GetBuyerReconcileDetailReq.Builder req = GetBuyerReconcileDetailReq.newBuilder();
        req.setCode("TR200526047454719711");
        GetBuyerReconcileDetailResp resp = openReconcileSdk.getBuyerReconcileDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void sendBuyerReconcile() throws Exception {
        SendBuyerReconcileReq.Builder req = SendBuyerReconcileReq.newBuilder();
        SendReconcileProduct.Builder builder = SendReconcileProduct.newBuilder();
        builder.setCategory(10);
        builder.setCategoryCode("AP200616229560001108");
        builder.setOrdinal(1);
        req.setStartTime("2020-03-09 16:14:56");
        req.setEndTime("2020-07-09 16:14:56");
        req.addReconcileProduct(builder);
        req.setUu(200040196);
        SendBuyerReconcileResp resp = openReconcileSdk.sendBuyerReconcile(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void confirmBuyerReconcile() throws Exception {
        ConfirmBuyerReconcileReq.Builder req = ConfirmBuyerReconcileReq.newBuilder();
        req.setReconcileCode("TR200617235885919601");
        req.setStatus(20);
        req.setUu(200040196);
        ConfirmBuyerReconcileResp resp = openReconcileSdk.confirmBuyerReconcile(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerReconcile() throws Exception {
        PagingSellerReconcileReq.Builder req = PagingSellerReconcileReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingSellerReconcileResp resp = openReconcileSdk.pagingSellerReconcile(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerReconcileDetail() throws Exception {
        GetSellerReconcileDetailReq.Builder req = GetSellerReconcileDetailReq.newBuilder();
        req.setCode("TR200526047454719711");
        GetSellerReconcileDetailResp resp = openReconcileSdk.getSellerReconcileDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void sendSellerReconcile() throws Exception {
        SendSellerReconcileReq.Builder req = SendSellerReconcileReq.newBuilder();
        SendReconcileProduct.Builder builder = SendReconcileProduct.newBuilder();
        builder.setCategory(10);
        builder.setCategoryCode("AP200616229560001108");
        builder.setOrdinal(1);
        req.setStartTime("2020-03-09 16:14:56");
        req.setEndTime("2020-07-09 16:14:56");
        req.addReconcileProduct(builder);
        req.setUu(200040196);
        SendSellerReconcileResp resp = openReconcileSdk.sendSellerReconcile(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void confirmSellerReconcile() throws Exception {
        ConfirmSellerReconcileReq.Builder req = ConfirmSellerReconcileReq.newBuilder();
        req.setReconcileCode("TR200617235885919601");
        req.setStatus(20);
        req.setUu(200040196);
        ConfirmSellerReconcileResp resp = openReconcileSdk.confirmSellerReconcile(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
