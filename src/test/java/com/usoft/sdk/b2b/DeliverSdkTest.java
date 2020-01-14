package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.deliver.api.entity.AcceptNotify;
import com.usoft.b2b.external.erp.deliver.api.entity.PurchaseNotify;
import com.usoft.b2b.external.erp.deliver.api.protobuf.*;
import com.usoft.sdk.b2b.client.DeliverSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author uas
 * @date 2019/12/16 15:57
 */
public class DeliverSdkTest {
    /**
     * 测试地址
     */
    private DeliverSdk deliverSdk = new DeliverSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");

    /**
     * 正式地址
     */
//	private DeliverSdk productSdk = new DeliverSdk("http://b2b-api.usoftchina.com", "10041559", "2c1ea089876b796fe050007f01002ea6");

    @Test
    public void savePurchaseNotify() throws IOException {
        SavePurchaseNotifyReq.Builder req = SavePurchaseNotifyReq.newBuilder();
        PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
        builder.setPnB2Bid(123);
        req.addPurchaseNotifyList(builder);
        SavePurchaseNotifyResp resp = deliverSdk.savePurchaseNotify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getAcceptNotifyList() throws IOException {
        GetAcceptNotifyListReq.Builder req = GetAcceptNotifyListReq.newBuilder();
        GetAcceptNotifyListResp resp = deliverSdk.getAcceptNotifyList(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateAcceptNotifyStatus() throws IOException {
        UpdateAcceptNotifyStatusReq.Builder req = UpdateAcceptNotifyStatusReq.newBuilder();
        req.setIdstr("233");
        UpdateAcceptNotifyStatusResp resp = deliverSdk.updateAcceptNotifyStatus(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void saveAcceptNotify() throws IOException {
        SaveAcceptNotifyListReq.Builder req = SaveAcceptNotifyListReq.newBuilder();
        AcceptNotify.Builder builder = AcceptNotify.newBuilder();
        builder.setAnBuyeruu(123);
        builder.setAnRemark("frev");
        req.addAcceptNotifyList(builder);
        SaveAcceptNotifyListResp resp = deliverSdk.saveAcceptNotify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updatePurchaseNotifyEnd() throws IOException {
        UpdatePurchaseNotifyEndReq.Builder req = UpdatePurchaseNotifyEndReq.newBuilder();
        PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
        PurchaseNotify.Builder builder2 = PurchaseNotify.newBuilder();
//        builder.setAnBuyeruu(123);
//        builder.setAnRemark("frev");
//        builder2.setAnRemark("frev");
        req.addPurchaseNotifyList(builder);
        req.addPurchaseNotifyList(builder2);
        UpdatePurchaseNotifyEndResp resp = deliverSdk.updatePurchaseNotifyEnd(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void checkPurchaseNotify() throws IOException {
        CheckPurchaseNotifyReq.Builder req = CheckPurchaseNotifyReq.newBuilder();
        CheckPurchaseNotifyResp resp = deliverSdk.checkPurchaseNotify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void saveAcceptNotifyConfirm() throws IOException {
        SaveAcceptNotifyConfirmListReq.Builder req = SaveAcceptNotifyConfirmListReq.newBuilder();
        SaveAcceptNotifyConfirmListResp resp = deliverSdk.saveAcceptNotifyConfirm(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void saveAcceptNotifyVerify() throws IOException {
        SaveAcceptNotifyVerifyListReq.Builder req = SaveAcceptNotifyVerifyListReq.newBuilder();
        SaveAcceptNotifyVerifyListResp resp = deliverSdk.saveAcceptNotifyVerify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void saveUnAcceptNotifyVerify() throws IOException {
        SaveUnAcceptNotifyVerifyListReq.Builder req = SaveUnAcceptNotifyVerifyListReq.newBuilder();
        SaveUnAcceptNotifyVerifyListResp resp = deliverSdk.saveUnAcceptNotifyVerify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }


    @Test
    public void savePurchaseProdInOut() throws IOException {
        SavePurchaseProdInOutReq.Builder req = SavePurchaseProdInOutReq.newBuilder();
        SavePurchaseProdInOutResp resp = deliverSdk.savePurchaseProdInOut(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void nonPostingProdInOut() throws IOException {
        NonPostingProdInOutReq.Builder req = NonPostingProdInOutReq.newBuilder();
        NonPostingProdInOutResp resp = deliverSdk.nonPostingProdInOut(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void savePurchaseProdReturn() throws IOException {
        SavePurchaseProdReturnReq.Builder req = SavePurchaseProdReturnReq.newBuilder();
        SavePurchaseProdReturnResp resp = deliverSdk.savePurchaseProdReturn(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void nonPostingProdReturn() throws IOException {
        NonPostingProdReturnReq.Builder req = NonPostingProdReturnReq.newBuilder();
        NonPostingProdReturnResp resp = deliverSdk.nonPostingProdReturn(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSaleNotifyDownList() throws IOException {
        GetSaleNotifyDownListReq.Builder req = GetSaleNotifyDownListReq.newBuilder();
        GetSaleNotifyDownListResp resp = deliverSdk.getSaleNotifyDownList(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateSaleNotifyDownStatus() throws IOException {
        UpdateSaleNotifyDownStatusReq.Builder req = UpdateSaleNotifyDownStatusReq.newBuilder();
        req.setIdStr("123");
        UpdateSaleNotifyDownStatusResp resp = deliverSdk.updateSaleNotifyDownStatus(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void saveSaleOutList() throws IOException {
        SaveSaleOutListReq.Builder req = SaveSaleOutListReq.newBuilder();
        SaveSaleOutListResp resp = deliverSdk.saveSaleOutList(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSaleOutList() throws IOException {
        GetSaleOutListReq.Builder req = GetSaleOutListReq.newBuilder();
        GetSaleOutListResp resp = deliverSdk.getSaleOutList(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateSaleOutStatus() throws IOException {
        UpdateSaleOutStatusReq.Builder req = UpdateSaleOutStatusReq.newBuilder();
        req.setIdStr("123");
        UpdateSaleOutStatusResp resp = deliverSdk.updateSaleOutStatus(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateSaleNotifyDownEnd() throws IOException {
        UpdateSaleNotifyDownEndReq.Builder req = UpdateSaleNotifyDownEndReq.newBuilder();
        UpdateSaleNotifyDownEndResp resp = deliverSdk.updateSaleNotifyDownEnd(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateSaleNotifyDownEndStatus() throws IOException {
        UpdateSaleNotifyDownEndStatusReq.Builder req = UpdateSaleNotifyDownEndStatusReq.newBuilder();
        req.setIdStr("123");
        UpdateSaleNotifyDownEndStatusResp resp = deliverSdk.updateSaleNotifyDownEndStatus(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
