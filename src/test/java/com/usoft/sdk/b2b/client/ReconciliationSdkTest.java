package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.reconciliation.api.entity.PurchaseApCheck;
import com.usoft.b2b.external.erp.reconciliation.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 * @deprecated 废弃，请使用V2版
 **/
@Deprecated
public class ReconciliationSdkTest {
	/**
	 * 测试地址
	 */
//	private ReconciliationSdk reconciliationSdk = new ReconciliationSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");
	private ReconciliationSdk reconciliationSdk = new ReconciliationSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

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
		req.setIdStr("200615220196781700");
		OnApChcekSuccessResp resp = reconciliationSdk.onApCheckSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void replyApCheck() throws IOException {
		ReplyApCheckReq.Builder req = ReplyApCheckReq.newBuilder();
		PurchaseApCheck.Builder builder =PurchaseApCheck.newBuilder();
		builder.setAcB2Bid(200615220196781700L);
		builder.setAcConfirmstatus("已确认");
		builder.setAcReason("同意");
		req.addApCheckList(builder);
		ReplyApCheckResp resp = reconciliationSdk.replyApCheck(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
