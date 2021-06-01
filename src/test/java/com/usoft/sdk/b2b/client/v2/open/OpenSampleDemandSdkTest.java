package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.api.entity.AttachFile;
import com.usoft.b2b.trade.external.open.api.entity.ImportSampleDemandProduct;
import com.usoft.b2b.trade.external.open.api.entity.LadderPrice;
import com.usoft.b2b.trade.external.open.api.entity.SampleLadderPrice;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.DateUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/6/19 16:26
 */
public class OpenSampleDemandSdkTest {
    /**
     * 测试地址
     */
    private OpenSampleDemandSdk openSampleDemandSdk = new OpenSampleDemandSdk("https://b2btraderest.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");

    @Test
    public void createSampleDemand() throws Exception {
        CreateSampleDemandReq.Builder req = CreateSampleDemandReq.newBuilder();
        req.setCategory(20);
//		req.addSellerEnuu(10050624);
        req.setCurrency("RMB");
        req.setOfferDeadline("2021-10-09");
        req.setAddr("广东省1111");

        ImportSampleDemandProduct.Builder op1 = ImportSampleDemandProduct.newBuilder();
        op1.setProductMaterialCode("MaterialCode");
        op1.setProductName("Name");
        op1.setProductSpec("Spec");
        op1.setQuantity(20);
        op1.setUnit("KPCS");
        op1.setSourceId("66");
        op1.setTechnicalRequirement("技术要求1");
        req.addDemandProduct(op1);
        AttachFile.Builder file1 = AttachFile.newBuilder();
        file1.setCode("11200618246794932149");
        op1.setAttachFile(file1);

        ImportSampleDemandProduct.Builder op2 = ImportSampleDemandProduct.newBuilder();
        op2.setProductMaterialCode("MaterialCode1");
        op2.setProductName("Name2");
        op2.setProductSpec("Spec2");
        op2.setQuantity(20);
        op2.setSourceId("12");
        op2.setTechnicalRequirement("技术要求2");
        AttachFile.Builder file2 = AttachFile.newBuilder();
        file2.setUrl("https://static.uuzcc.cn/appmall/12200604123893460688.jpg");
        file2.setName("测试.jpg");
        op2.setAttachFile(file2);
        req.addDemandProduct(op2);
        req.setSourceId("123123");
        req.setBizCode("666666");
        req.setDemandTime(DateUtil.getCurrentDate(DateUtil.PATTERN_DATE_TIME));
        req.setUu(1000027480);
        req.setUu(200040196);
        CreateSampleDemandResp resp = openSampleDemandSdk.createSampleDemand(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingBuyerSampleDemand() throws Exception {
        PagingBuyerSampleDemandReq.Builder req = PagingBuyerSampleDemandReq.newBuilder();
        req.setPageNumber(1);
        req.setPageSize(999);
//        req.setCategory(10);
//        req.setStatus(20);
//        req.setStartTime("2021-02-10 00:00:00");
//        req.setEndTime("2022-03-01 23:59:59");
        PagingBuyerSampleDemandResp resp = openSampleDemandSdk.pagingBuyerSampleDemand(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerSampleDemandDetail() throws Exception {
        GetBuyerSampleDemandDetailReq.Builder req = GetBuyerSampleDemandDetailReq.newBuilder();
        req.setCode("DD210531245320641000");
        GetBuyerSampleDemandDetailResp resp = openSampleDemandSdk.getBuyerSampleDemandDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void replySampleDemandProductOffer() throws Exception {
        ReplySampleDemandProductOfferReq.Builder req = ReplySampleDemandProductOfferReq.newBuilder();
        req.setSampleDemandProductOfferCode("PO200509900506414803");
        req.setCategory(20);
        ReplySampleDemandProductOfferResp resp = openSampleDemandSdk.replySampleDemandProductOffer(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getBuyerSampleDemandList() throws Exception {
        GetBuyerSampleDemandListReq.Builder req = GetBuyerSampleDemandListReq.newBuilder();
        req.setBizCode("777777");
        GetBuyerSampleDemandListResp resp = openSampleDemandSdk.getBuyerSampleDemandList(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerSampleDemand() throws Exception {
        PagingSellerSampleDemandReq.Builder req = PagingSellerSampleDemandReq.newBuilder();
        req.setPageNumber(10);
        req.setPageSize(1);
        PagingSellerSampleDemandResp resp = openSampleDemandSdk.pagingSellerSampleDemand(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerSampleDemandDetail() throws Exception {
        GetSellerSampleDemandDetailReq.Builder req = GetSellerSampleDemandDetailReq.newBuilder();
        req.setCode("DD200509900416450200");
        GetSellerSampleDemandDetailResp resp = openSampleDemandSdk.getSellerSampleDemandDetail(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void offerSampleDemandProduct() throws Exception {
        OfferSampleDemandProductReq.Builder req = OfferSampleDemandProductReq.newBuilder();
        req.setSampleDemandProductCode("MP200619254984927037");
        req.setSampleDemandProductOfferCode("PO200619255294707203");
        req.setDeliveryTime(1);
        req.setTaxRate(1);
        req.setMpq(2);
        req.setMoq(2);
//		req.setAttachFileCode("");
        req.setUu(200040196);
        req.addLadderP(SampleLadderPrice.newBuilder().setStart(1).setPrice(1.0));
        req.addLadderP(SampleLadderPrice.newBuilder().setStart(10).setPrice(10.0));
        OfferSampleDemandProductResp resp = openSampleDemandSdk.offerSampleDemandProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
