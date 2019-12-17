package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.reconciliation.api.protobuf.*;
import com.usoft.sdk.b2b.client.ReconciliationSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 **/
public class ReconciliationSdkTest {
	/**
	 * 测试地址
	 */
	private ReconciliationSdk reconciliationSdk = new ReconciliationSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");

	/**
	 * 正式地址
	 */
//	private ProductSdk productSdk = new ProductSdk("http://b2b-api.usoftchina.com/");
	@Test
	public void getApCheckList() throws IOException {
		GetApCheckListReq.Builder req = GetApCheckListReq.newBuilder();
		GetApCheckListResp resp = reconciliationSdk.getApCheckList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onApCheckSuccess() throws IOException {
		OnApChcekSuccessReq.Builder req = OnApChcekSuccessReq.newBuilder();
		req.setIdStr("123");
		OnApChcekSuccessResp resp = reconciliationSdk.onApCheckSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void replyApCheck() throws IOException {
		ReplyApCheckReq.Builder req = ReplyApCheckReq.newBuilder();
		ReplyApCheckResp resp = reconciliationSdk.replyApCheck(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
