package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.ent.api.entity.VendorPerformanceAssessErp;
import com.usoft.b2b.external.erp.ent.api.protobuf.SaveVPAsReq;
import com.usoft.b2b.external.erp.ent.api.protobuf.SaveVPAsResp;
import com.usoft.b2b.external.erp.product.api.entity.Product;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 * @deprecated 废弃，请使用V2版
 **/
@Deprecated
public class EntSdkTest {
	/**
	 * 开发地址
	 */
	private EntSdk entSdk = new EntSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

	@Test
	public void saveVPAs() throws IOException {
		SaveVPAsReq.Builder req = SaveVPAsReq.newBuilder();
		VendorPerformanceAssessErp.Builder builder = VendorPerformanceAssessErp.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setVpaCode("VpaCode"+random);
		builder.setVeUu(10050624);
		builder.setVpaVendorname("WCY");
		builder.setVpaVendorcode("300186");
		builder.setVpa8Dhfjsl(3);
		builder.setVpaApplydate(new Date().getTime());
		builder.setVpaApplydep("采购部");
		builder.setVpaApplyman("戴维");
		builder.setVpaAssessdate("201611");
		builder.setVpaAuditdate(new Date().getTime());
		builder.setVpaAuditor("");
		builder.setVpaBrkyy("");
		builder.setVpaCbjj(25);
		builder.setVpaCgjcgkfqzdf(32.2);
		builder.setVpaCgkfzhdf(73);
		builder.setVpaCgpffj("");
		builder.setVpaCgzhdf(88);
		builder.setVpaCxzdyc(5);
		builder.setVpaDjhcs(30);
		builder.setVpaDyzc(15);
		builder.setVpaFwxl(10);
		builder.setVpaFwzc(15);
		builder.setVpaGcsl(9);
		builder.setVpaGfphd(20);
		builder.setVpaGysqrdf("");
		builder.setVpaJbxxfj("");
		builder.setVpaJsbz(8);
		builder.setVpaJsfx(9);
		builder.setVpaJspffj("");
		builder.setVpaJsqzdf(25.2);
		builder.setVpaJszc(9);
		builder.setVpaJszhdf(84);
		builder.setVpaJszlwzqk(8);
		builder.setVpaKhsxcs(8);
		builder.setVpaKkxyq(18);
		builder.setVpaLlpbhgl(10);
		builder.setVpaNgpcl(0);
		builder.setVpaOrdername("郑奋冰");
		builder.setVpaOrderteam("SY1451");
		builder.setVpaProdkind("液晶屏");
		builder.setVpaPurchasecode("SY1174");
		builder.setVpaPurchasename("彭文");
//		builder.setVpaRecorddate(new Date().getTime());
		builder.setVpaRecordman("");
		builder.setVpaSqe("SY2230");
		builder.setVpaSqename("刘求贵");
		builder.setVpaStatus("已审核");
		builder.setVpaStatuscode("AUDITED");
		builder.setVpaSxbll(15);
		builder.setVpaWljf(48);
		builder.setVpaWlsffsjszlwt(18);
		builder.setVpaYcffl(6);
		builder.setVpaYphgl(5);
		builder.setVpaZftj(18);
		builder.setVpaZjdf(77.5);
		builder.setVpaZlpffj("");
		builder.setVpaZlzhdf(20.1);
		builder.setVpaZlqzdf(67);
		builder.setVpaGrade("");
		builder.setVpaId(random);
		req.addData(builder);
		SaveVPAsResp resp = entSdk.saveVPAs(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
