package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.ent.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * @author uas
 * @date 2021/1/7 15:22
 */
public class OpenPartnersSdk extends BaseSdk {
    public OpenPartnersSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenPartnersSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 分页查询合作伙伴列表
     *
     * @param req
     * @return
     */
    public PagingPartnersResp pagingPartners(PagingPartnersReq.Builder req) throws Exception {
        String url = baseUrl + "/open/partners/page";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingPartnersResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingPartnersResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 获取合作伙伴信息
     *
     * @param req
     * @return
     */
    public GetPartnersResp getPartners(GetPartnersReq.Builder req) throws Exception {
        String url = baseUrl + "/open/partners/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetPartnersResp.Builder resp = ProtoBufUtil.toProtoBuf(GetPartnersResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 修改伙伴身份
     *
     * @param req
     * @return
     */
    public UpdateIdentityResp updateIdentity(UpdateIdentityReq.Builder req) throws Exception {
        String url = baseUrl + "/open/partners/identity/update";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        UpdateIdentityResp.Builder resp = ProtoBufUtil.toProtoBuf(UpdateIdentityResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 修改伙伴身份
     *
     * @param req
     * @return
     */
    public AddPartnersApplyResp addPartnersApply(AddPartnersApplyReq.Builder req) throws Exception {
        String url = baseUrl + "/open/partners/apply/add";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        AddPartnersApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(AddPartnersApplyResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 审核合作伙伴申请
     *
     * @param req
     * @return
     */
    public AuditPartnersApplyResp auditPartnersApply(AuditPartnersApplyReq.Builder req) throws Exception {
        String url = baseUrl + "/open/partners/apply/audit";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        AuditPartnersApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(AuditPartnersApplyResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页合作伙伴申请列表
     *
     * @param req
     * @return
     */
    public PagingPartnersApplyResp pagingPartnersApply(PagingPartnersApplyReq.Builder req) throws Exception {
        String url = baseUrl + "/open/partners/apply/page";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingPartnersApplyResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingPartnersApplyResp.newBuilder(), respJson);
        return resp.build();
    }
}
