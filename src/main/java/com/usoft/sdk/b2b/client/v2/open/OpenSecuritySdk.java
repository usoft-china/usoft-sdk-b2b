package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.ent.external.open.api.protobuf.SaveUserRoleReq;
import com.usoft.b2b.ent.external.open.api.protobuf.SaveUserRoleResp;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

/**
 * @author uas
 * @date 2021/1/7 15:22
 */
public class OpenSecuritySdk extends BaseSdk {
    public OpenSecuritySdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenSecuritySdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 保存用户角色
     *
     * @param req
     * @return
     */
    public SaveUserRoleResp saveUserRole(SaveUserRoleReq.Builder req) throws Exception {
        String url = baseUrl + "/open/security/userrole/save";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        SaveUserRoleResp.Builder resp = ProtoBufUtil.toProtoBuf(SaveUserRoleResp.newBuilder(), respJson);
        return resp.build();
    }
}
