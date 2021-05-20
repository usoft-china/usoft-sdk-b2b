package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.api.entity.Ent;
import com.usoft.b2b.trade.external.open.api.entity.ImportBiddingProduct;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class OpenBiddingSdkTest {
    /**
     * 测试地址
     */
    private OpenBiddingSdk openBiddingSdk = new OpenBiddingSdk("https://b2btraderest.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//    private OpenProductSdk productSdk = new OpenProductSdk("https://b2bentrest.usoftchina.com", "20002873", "1067591a3adb44a8ab9605790969b30a");

    @Test
    public void createBidding() throws Exception{
        CreateBiddingReq.Builder req = CreateBiddingReq.newBuilder();
        req.setCategory(10);
        req.addSellerEnuu(10050624);
        req.setTitle("Title");
        req.setContactName("ContactName");
        req.setContactMobile("1231231231");
        req.setCurrency("RMB");
        req.setTaxInclusive(true);
        req.setPaymentMethod("现结");
        req.setInvCategory(10);
        req.setDeliveryAddrCode("DA200226268678882100");
        req.setDeadline("2020-05-14");
        req.setShowResultDate("2020-05-13");
        req.addAttachFC("11181025046410721735");

        ImportBiddingProduct.Builder op1 = ImportBiddingProduct.newBuilder();
        op1.setProductModel("Model1");
        op1.setProductBrand("Brand1");
        op1.setProductName("Name1");
        op1.setProductSpec("Spec1");
        op1.setQuantity(10);
        op1.setUnit("KPCS");
        req.addBiddingProduct(op1);

        ImportBiddingProduct.Builder op2 = ImportBiddingProduct.newBuilder();
        op2.setProductMaterialCode("MaterialCode");
        op2.setProductModel("Model2");
        op2.setProductBrand("Brand2");
        op2.setProductName("Name2");
        op2.setProductSpec("Spec2");
        op2.setQuantity(20);
        req.addBiddingProduct(op2);
        CreateBiddingResp resp = openBiddingSdk.createBidding(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerBidding() throws Exception{
        PagingBuyerBiddingReq.Builder req = PagingBuyerBiddingReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingBuyerBiddingResp resp = openBiddingSdk.pagingBuyerBidding(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerBiddingDetail() throws Exception{
        GetBuyerBiddingDetailReq.Builder req = GetBuyerBiddingDetailReq.newBuilder();
        req.setCode("TB200512926874996100");
        GetBuyerBiddingDetailResp resp = openBiddingSdk.getBuyerBiddingDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void replyBiddingProductTender() throws Exception {
        ReplyBiddingProductTenderReq.Builder req = ReplyBiddingProductTenderReq.newBuilder();
        req.setBiddingProductTenderCode("PT200512926875009602");
        req.setCategory(20);
        req.setReplyRemark("ReplyRemark");
        ReplyBiddingProductTenderResp resp = openBiddingSdk.replyBiddingProductTender(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerBidding() throws Exception {
        PagingSellerBiddingReq.Builder req = PagingSellerBiddingReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingSellerBiddingResp resp = openBiddingSdk.pagingSellerBidding(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerBiddingDetail() throws Exception {
        GetSellerBiddingDetailReq.Builder req = GetSellerBiddingDetailReq.newBuilder();
        req.setCode("TB201229923748832282");
        GetSellerBiddingDetailResp resp = openBiddingSdk.getSellerBiddingDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void tenderBiddingProduct() throws Exception {
        TenderBiddingProductReq.Builder req = TenderBiddingProductReq.newBuilder();
        req.setBiddingProductCode("BP200512926875022103");
        req.setBiddingProductTenderCode("PT200512926875034504");
        req.setDeliveryTime(1);
        req.setTaxRate(1);
        req.setUnitPrice(1.5);
        req.addAttachFC("11181025046410721735");

        Ent.Builder ent = Ent.newBuilder();
        ent.setContact("Contact");
        ent.setMobile("Mobile");
        req.setEnt(ent);
        TenderBiddingProductResp resp = openBiddingSdk.tenderBiddingProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
