package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.ent.external.open.api.protobuf.SaveUserRoleReq;
import com.usoft.b2b.ent.external.open.api.protobuf.SaveUserRoleResp;
import com.usoft.b2b.trade.external.open.api.entity.CreateOrUpdateProduct;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class OpenSecuritySdkTest {
    /**
     * 测试地址
     */
    private OpenSecuritySdk openSecuritySdk = new OpenSecuritySdk("https://b2bentrest.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//    private OpenProductSdk productSdk = new OpenProductSdk("https://b2bentrest.usoftchina.com", "20002873", "1067591a3adb44a8ab9605790969b30a");
    @Test
    public void saveUserRole() throws Exception {
        SaveUserRoleReq.Builder req = SaveUserRoleReq.newBuilder();
        req.setUu(200040196);
        req.setRoleAdmin(true);
        req.setRoleNormal(true);
        req.setRolePurchase(true);
        req.setRoleSale(true);
        SaveUserRoleResp resp = openSecuritySdk.saveUserRole(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
