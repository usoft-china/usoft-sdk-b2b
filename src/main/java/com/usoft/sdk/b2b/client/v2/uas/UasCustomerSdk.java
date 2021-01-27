package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.ent.external.uas.api.protobuf.CreatePerfAssessReq;
import com.usoft.b2b.ent.external.uas.api.protobuf.CreatePerfAssessResp;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

/**
 * 客户/供应商 sdk
 * @author uas
 * @date 2021/1/27 10:26
 */
public class UasCustomerSdk extends BaseSdk {
    public UasCustomerSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public UasCustomerSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 新增绩效考核
     *
     * @param req
     * @return
     */
    public CreatePerfAssessResp createPerfAssess(CreatePerfAssessReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/customer/perfassess/create";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        CreatePerfAssessResp.Builder resp = ProtoBufUtil.toProtoBuf(CreatePerfAssessResp.newBuilder(), respJson);
        return resp.build();
    }
}
