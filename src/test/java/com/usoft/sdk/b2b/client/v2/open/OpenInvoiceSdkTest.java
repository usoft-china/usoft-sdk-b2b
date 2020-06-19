package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.entity.OpenInvoiceProduct;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/6/17 10:53
 */
public class OpenInvoiceSdkTest {
    /**
     * 测试地址
     */
    private OpenInvoiceSdk openInvoiceSdk = new OpenInvoiceSdk("https://b2btraderest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");

    @Test
    public void pagingBuyerInvoice() throws Exception {
        PagingBuyerInvoiceReq.Builder req = PagingBuyerInvoiceReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingBuyerInvoiceResp resp = openInvoiceSdk.pagingBuyerInvoice(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerInvoiceDetail() throws Exception {
        GetBuyerInvoiceDetailReq.Builder req = GetBuyerInvoiceDetailReq.newBuilder();
        req.setCode("TI200605135228880002");
        GetBuyerInvoiceDetailResp resp = openInvoiceSdk.getBuyerInvoiceDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerInvoice() throws Exception {
        PagingSellerInvoiceReq.Builder req = PagingSellerInvoiceReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingSellerInvoiceResp resp = openInvoiceSdk.pagingSellerInvoice(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerInvoiceDetail() throws Exception {
        GetSellerInvoiceDetailReq.Builder req = GetSellerInvoiceDetailReq.newBuilder();
        req.setCode("TI200605135228880002");
        GetSellerInvoiceDetailResp resp = openInvoiceSdk.getSellerInvoiceDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void openInvoice() throws Exception {
        OpenInvoiceReq.Builder req = OpenInvoiceReq.newBuilder();
        OpenInvoiceProduct.Builder builder = OpenInvoiceProduct.newBuilder();
        req.setInvCode("InvCode");
        req.setSellerEnuu(10050624);
        req.setUu(200040196);
        req.setCurrency("RMB");
        req.setPaymentMethod("现结");
        req.setBizCode("bizcode");
        builder.setCategory(10);
        builder.setCategoryCode("AP200526047360616108");
        builder.setOrderProductCode("OP200526046405685404");
        builder.setUnitPrice(0.2);
        builder.setTaxRate(0.2);
        req.addInvoiceProduct(builder);
        OpenInvoiceResp resp = openInvoiceSdk.openInvoice(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchDeleteInvoice() throws Exception {
        BatchDeleteInvoiceReq.Builder req = BatchDeleteInvoiceReq.newBuilder();
        req.addCode("InvCode");
        BatchDeleteInvoiceResp resp = openInvoiceSdk.batchDeleteInvoice(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
