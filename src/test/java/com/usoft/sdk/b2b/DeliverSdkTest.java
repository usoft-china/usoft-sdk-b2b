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
    public void getSaleDownChangeList() throws IOException {
        SavePurchaseNotifyReq.Builder req = SavePurchaseNotifyReq.newBuilder();
        PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
        builder.setPnB2Bid(123);
        req.addPurchaseNotifyList(builder);
        SavePurchaseNotifyResp resp = deliverSdk.getSaleDownChangeList(req.build());
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
        builder.setAnBuyeruu("123");
        builder.setAnRemark("frev");
        req.addAcceptNotifyList(builder);
        SaveAcceptNotifyListResp resp = deliverSdk.saveAcceptNotify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateAcceptNotifyEnd() throws IOException {
        UpdateAcceptNotifyEndReq.Builder req = UpdateAcceptNotifyEndReq.newBuilder();
        AcceptNotify.Builder builder = AcceptNotify.newBuilder();
        AcceptNotify.Builder builder2 = AcceptNotify.newBuilder();
        builder.setAnBuyeruu("123");
        builder.setAnRemark("frev");
        builder2.setAnRemark("frev");
        req.addAcceptNotifyList(builder);
        req.addAcceptNotifyList(builder2);
        UpdateAcceptNotifyEndResp resp = deliverSdk.updateAcceptNotifyEnd(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void checkAcceptNotify() throws IOException {
        CheckAcceptNotifyReq.Builder req = CheckAcceptNotifyReq.newBuilder();
        PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
        builder.setPnB2Bid(2);
        builder.setPnId(123);
        builder.setVeUu(321);
        req.addPurchaseNotifyList(builder);
        CheckAcceptNotifyResp resp = deliverSdk.checkAcceptNotify(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
