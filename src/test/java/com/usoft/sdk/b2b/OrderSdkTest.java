package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.order.api.protobuf.GetSaleDownListReq;
import com.usoft.b2b.external.erp.order.api.protobuf.GetSaleDownListResp;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusReq;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusResp;
import com.usoft.sdk.b2b.client.OrderSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 **/
public class OrderSdkTest {
	/**
	 * 测试地址
	 */
	private OrderSdk orderSdk = new OrderSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");

	/**
	 * 正式地址
	 */
//	private OrderSdk orderSdk = new OrderSdk("http://b2b-api.usoftchina.com/","10041559","2c1ea089876b796fe050007f01002ea6");
	@Test
	public void getSaleDownList() throws IOException {
		GetSaleDownListReq.Builder req = GetSaleDownListReq.newBuilder();
		GetSaleDownListResp resp = orderSdk.getSaleDownList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleDownStatus() throws IOException {
		UpdateSaleDownStatusReq.Builder req = UpdateSaleDownStatusReq.newBuilder();
		req.setIdStr("123");
		UpdateSaleDownStatusResp resp = orderSdk.updateSaleDownStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
