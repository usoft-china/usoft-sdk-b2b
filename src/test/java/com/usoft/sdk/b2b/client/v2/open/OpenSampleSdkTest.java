package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class OpenSampleSdkTest {
    /**
     * 测试地址
     */
    private OpenSampleSdk openSampleSdk = new OpenSampleSdk("https://b2btraderest.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//    private OpenProductSdk productSdk = new OpenProductSdk("https://b2bentrest.usoftchina.com", "20002873", "1067591a3adb44a8ab9605790969b30a");

    @Test
    public void pagingSellerSampleApply() throws Exception{
        PagingSellerSampleApplyReq.Builder req = PagingSellerSampleApplyReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingSellerSampleApplyResp resp = openSampleSdk.pagingSellerSampleApply(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerSampleApply() throws Exception{
        GetSellerSampleApplyReq.Builder req = GetSellerSampleApplyReq.newBuilder();
        req.setCode("SA200812722817855003");
        GetSellerSampleApplyResp resp = openSampleSdk.getSellerSampleApply(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerSampleApproval() throws Exception{
        PagingSellerSampleApprovalReq.Builder req = PagingSellerSampleApprovalReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingSellerSampleApprovalResp resp = openSampleSdk.pagingSellerSampleApproval(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void sendSample() throws Exception {
        SendSampleReq.Builder req = SendSampleReq.newBuilder();
        req.setBizCode("aaa");
        req.setSampleApplyCode("ewfeferef");
        req.setQuantitySend(10);
        req.setUnitPrice(10);
        req.setDeliveryTime(7);
        req.setMoq(1);
        req.setMpq(1);
        req.setOriginMark("1");
        req.addAttachFC("12200509900545782593");
        req.addAttachFC("12200509900545782593");
        SendSampleResp resp = openSampleSdk.sendSample(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSampleSendHistory() throws Exception {
        GetSampleSendHistoryReq.Builder req = GetSampleSendHistoryReq.newBuilder();
        req.setCode("");
        GetSampleSendHistoryResp resp = openSampleSdk.getSampleSendHistory(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
