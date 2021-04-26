package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.ent.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class OpenPartnersSdkTest {
    /**
     * 测试地址
     */
    private OpenPartnersSdk openPartnersSdk = new OpenPartnersSdk("https://b2bentrest.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//    private OpenProductSdk productSdk = new OpenProductSdk("https://b2bentrest.usoftchina.com", "20002873", "1067591a3adb44a8ab9605790969b30a");

    @Test
    public void pagingPartners() throws Exception{
        PagingPartnersReq.Builder req = PagingPartnersReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingPartnersResp resp = openPartnersSdk.pagingPartners(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getPartners() throws Exception{
        GetPartnersReq.Builder req = GetPartnersReq.newBuilder();
        req.setPartnersEnuu(10050912);
        GetPartnersResp resp = openPartnersSdk.getPartners(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingPartnersApply() throws Exception{
        PagingPartnersApplyReq.Builder req = PagingPartnersApplyReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingPartnersApplyResp resp = openPartnersSdk.pagingPartnersApply(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateIdentity() throws Exception {
        UpdateIdentityReq.Builder req = UpdateIdentityReq.newBuilder();
        req.setCode("PS200515952388341614");
        req.setIdentity(4);
        UpdateIdentityResp resp = openPartnersSdk.updateIdentity(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void addPartnersApply() throws Exception {
        AddPartnersApplyReq.Builder req = AddPartnersApplyReq.newBuilder();
        req.setPartnersEnuu(10050912);
        req.setIdentity(1);
        AddPartnersApplyResp resp = openPartnersSdk.addPartnersApply(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void auditPartnersApply() throws Exception {
        AuditPartnersApplyReq.Builder req = AuditPartnersApplyReq.newBuilder();
        req.setCode("PA210425934266800607");
        req.setStatus(20);
        AuditPartnersApplyResp resp = openPartnersSdk.auditPartnersApply(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
