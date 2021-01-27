package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.ent.api.protobuf.SaveVPAsReq;
import com.usoft.b2b.external.erp.ent.api.protobuf.SaveVPAsResp;
import com.usoft.b2b.external.erp.order.api.protobuf.SaleReplyResp;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: wangcanyi
 * @date: 2019-12-12 17:41
 * @deprecated 废弃，请使用V2版
 **/
@Deprecated
public class EntSdk extends BaseSdk {
	
    public EntSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public EntSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 定时任务更新物料信息
     *
     * @param req
     * @return
     */
    public SaveVPAsResp saveVPAs(SaveVPAsReq req) throws IOException {
        String url = baseUrl + "/erp/vendorPerformanceAssess";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>(1);
        fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
        HttpUtil.doPost(url, fromData, timeout);
        return SaveVPAsResp.newBuilder().build();
    }
}
