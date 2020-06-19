package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.api.entity.AttachFile;
import com.usoft.b2b.trade.external.open.api.entity.ImportDemandProduct;
import com.usoft.b2b.trade.external.open.api.entity.LadderPrice;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/6/19 16:26
 */
public class OpenDemandSdkTest {
    /**
     * 测试地址
     */
    private OpenDemandSdk openDemandSdk = new OpenDemandSdk("https://b2btraderest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");

    @Test
    public void pagingBuyerInvoice() throws Exception {
        CreateDemandReq.Builder req = CreateDemandReq.newBuilder();
        req.setCategory(20);
//		req.addSellerEnuu(10050624);
        req.setCurrency("RMB");
        req.setOfferDeadline("2020-05-09");

        ImportDemandProduct.Builder op1 = ImportDemandProduct.newBuilder();
        op1.setProductModel("Model1");
        op1.setProductBrand("Brand1");
        op1.setProductName("Name1");
        op1.setProductSpec("Spec1");
        op1.setQuantity(10);
        op1.setUnit("KPCS");
        op1.setOfferDeadline("2020-05-09");
        req.addDemandProduct(op1);

        ImportDemandProduct.Builder op2 = ImportDemandProduct.newBuilder();
        op2.setProductMaterialCode("MaterialCode");
        op2.setProductModel("Model2");
        op2.setProductBrand("Brand2");
        op2.setProductName("Name2");
        op2.setProductSpec("Spec2");
        op2.setQuantity(20);
        op2.setOfferDeadline("2020-05-09");
        req.addDemandProduct(op2);
        AttachFile.Builder file1 = AttachFile.newBuilder();
        file1.setCode("11200618246794932149");
        AttachFile.Builder file2 = AttachFile.newBuilder();
        file2.setUrl("https://static.uuzcc.cn/appmall/12200604123893460688.jpg");
        file2.setName("测试.jpg");
        req.addAttachFile(file1);
        req.addAttachFile(file2);
        req.setSourceId("123");
        req.setBizCode("666666");
        req.setDemandTime("2020-06-19 08:08:08");
        req.setUu(200040196);
        CreateDemandResp resp = openDemandSdk.createDemand(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerDemand() throws Exception {
        PagingBuyerDemandReq.Builder req = PagingBuyerDemandReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingBuyerDemandResp resp = openDemandSdk.pagingBuyerDemand(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerDemandDetail() throws Exception {
        GetBuyerDemandDetailReq.Builder req = GetBuyerDemandDetailReq.newBuilder();
        req.setCode("DD200619255039749100");
        GetBuyerDemandDetailResp resp = openDemandSdk.getBuyerDemandDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void replyDemandProductOffer() throws Exception {
        ReplyDemandProductOfferReq.Builder req = ReplyDemandProductOfferReq.newBuilder();
        req.setDemandProductOfferCode("PO200509900506414803");
        req.setCategory(20);
        ReplyDemandProductOfferResp resp = openDemandSdk.replyDemandProductOffer(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerDemandList() throws Exception {
        GetBuyerDemandListReq.Builder req = GetBuyerDemandListReq.newBuilder();
        req.setBizCode("777777");
        GetBuyerDemandListResp resp = openDemandSdk.getBuyerDemandList(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerDemand() throws Exception {
        PagingSellerDemandReq.Builder req = PagingSellerDemandReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingSellerDemandResp resp = openDemandSdk.pagingSellerDemand(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerDemandDetail() throws Exception {
        GetSellerDemandDetailReq.Builder req = GetSellerDemandDetailReq.newBuilder();
        req.setCode("DD200509900416450200");
        GetSellerDemandDetailResp resp = openDemandSdk.getSellerDemandDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void offerDemandProduct() throws Exception {
        OfferDemandProductReq.Builder req = OfferDemandProductReq.newBuilder();
        req.setDemandProductCode("MP200619254984927037");
        req.setDemandProductOfferCode("PO200619255294707203");
        req.setDeliveryTime(1);
        req.setTaxRate(1);
        req.setMpq(2);
        req.setMoq(2);
        req.setMaterialBrand("MaterialBrand");
        req.setMaterialCode("MaterialCode");
//		req.setAttachFileCode("");
        req.setUu(200040196);
        req.addLadderP(LadderPrice.newBuilder().setStart(1).setPrice(1.0));
        req.addLadderP(LadderPrice.newBuilder().setStart(10).setPrice(10.0));
        AttachFile.Builder file2 = AttachFile.newBuilder();
        file2.setUrl("https://static.uuzcc.cn/appmall/12200604123893460688.jpg");
        file2.setName("test1.jpg");
        req.setAttachFile(file2);
        OfferDemandProductResp resp = openDemandSdk.offerDemandProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchInvalidDemandProduct() throws Exception {
        BatchInvalidDemandProductReq.Builder req = BatchInvalidDemandProductReq.newBuilder();
        req.addCode("MP200619254984927037");
        req.addCode("MP200619254984927238");
        BatchInvalidDemandProductResp resp = openDemandSdk.batchInvalidDemandProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
