package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.ent.external.uas.api.protobuf.CreatePerfAssessReq;
import com.usoft.b2b.ent.external.uas.api.protobuf.CreatePerfAssessResp;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2021/1/27 10:28
 */
public class UasCustomerSdkTest {
    /**
     * 测试地址
     */
    private UasCustomerSdk uasCustomerSdk = new UasCustomerSdk("https://b2bentrest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");
    @Test
    public void createPerfAssess() throws Exception {
        CreatePerfAssessReq.Builder req = CreatePerfAssessReq.newBuilder();
        req.setBizCode("2016110001");
        req.setSellerEnuu(10041191);
        req.setSellerName("华商龙科技有限公司123");
        req.setVendorcode("300186");
        req.setEdhfjsl(3);
        req.setApplydate("2016-12-06 00:00:00");
        req.setApplydep("采购部");
        req.setApplyman("戴维");
        req.setAssessdate("201611");
        req.setAuditdate("");
        req.setAuditor("");
        req.setBrkyy("");
        req.setCbjj(25);
        req.setCgjcgkfqzdf(32.2);
        req.setCgkfzhdf(73);
        req.setCgpffj("");
        req.setCgzhdf(88);
        req.setCxzdyc(5);
        req.setDjhcs(30);
        req.setDyzc(15);
        req.setFwxl(10);
        req.setFwzc(15);
        req.setGcsl(9);
        req.setGfphd(20);
        req.setGysqrdf("");
        req.setJbxxfj("");
        req.setJsbz(8);
        req.setJsfx(9);
        req.setJspffj("");
        req.setJsqzdf(25.2);
        req.setJszc(9);
        req.setJszhdf(84);
        req.setJszlwzqk(8);
        req.setKhsxcs(8);
        req.setKkxyq(18);
        req.setLlpbhgl(10);
        req.setNgpcl(0);
        req.setOrdername("郑奋冰");
        req.setOrderteam("SY1451");
        req.setProdkind("液晶屏");
        req.setPurchasecode("SY1174");
        req.setPurchasename("彭文");
        req.setRecorddate("");
        req.setRecordman("");
        req.setSqe("SY2230");
        req.setSqename("刘求贵");
        req.setStatus("已审核");
        req.setStatuscode("AUDITED");
        req.setSxbll(15);
        req.setWljf(48);
        req.setWlsffsjszlwt(18);
        req.setYcffl(6);
        req.setYphgl(5);
        req.setZftj(18);
        req.setZjdf(77.5);
        req.setZlpffj("");
        req.setZlzhdf(20.1);
        req.setZlqzdf(67);
        req.setGrade("");
        req.setSourceId("3000");
        CreatePerfAssessResp resp = uasCustomerSdk.createPerfAssess(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
