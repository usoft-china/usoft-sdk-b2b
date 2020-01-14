package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.order.api.protobuf.*;
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

	@Test
	public void getSaleReplyList() throws IOException {
		GetSaleReplyListReq.Builder req = GetSaleReplyListReq.newBuilder();
		GetSaleReplyListResp resp = orderSdk.getSaleReplyList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saleReply() throws IOException {
		SaleReplyReq.Builder req = SaleReplyReq.newBuilder();
		SaleReplyResp resp = orderSdk.saleReply(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleReplyStatus() throws IOException {
		UpdateSaleReplyStatusReq.Builder req = UpdateSaleReplyStatusReq.newBuilder();
		req.setIdStr("123");
		UpdateSaleReplyStatusResp resp = orderSdk.updateSaleReplyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleDownDetailEnd() throws IOException {
		GetSaleDownDetailEndReq.Builder req = GetSaleDownDetailEndReq.newBuilder();
		GetSaleDownDetailEndResp resp = orderSdk.getSaleDownDetailEnd(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleDownDetailEnd() throws IOException {
		UpdateSaleDownDetailEndReq.Builder req = UpdateSaleDownDetailEndReq.newBuilder();
		req.setIdStr("123");
		UpdateSaleDownDetailEndResp resp = orderSdk.updateSaleDownDetailEnd(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleDownChangeList() throws IOException {
		GetSaleDownChangeListReq.Builder req = GetSaleDownChangeListReq.newBuilder();
		GetSaleDownChangeListResp resp = orderSdk.getSaleDownChangeList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleDownChangeStatus() throws IOException {
		UpdateSaleDownChangeStatusReq.Builder req = UpdateSaleDownChangeStatusReq.newBuilder();
		req.setIdStr("123");
		UpdateSaleDownChangeStatusResp resp = orderSdk.updateSaleDownChangeStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveSaleDownChangeReply() throws IOException {
		SaveSaleDownChangeReplyReq.Builder req = SaveSaleDownChangeReplyReq.newBuilder();
		SaveSaleDownChangeReplyResp resp = orderSdk.saveSaleDownChangeReply(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleDownChangeReplyList() throws IOException {
		GetSaleDownChangeReplyListReq.Builder req = GetSaleDownChangeReplyListReq.newBuilder();
		GetSaleDownChangeReplyListResp resp = orderSdk.getSaleDownChangeReplyList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleDownChangeReplyStatus() throws IOException {
		UpdateSaleDownChangeReplyStatusReq.Builder req = UpdateSaleDownChangeReplyStatusReq.newBuilder();
		req.setIdStr("123");
		UpdateSaleDownChangeReplyStatusResp resp = orderSdk.updateSaleDownChangeReplyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void savePurchaseList() throws IOException {
		SavePurchaseListReq.Builder req = SavePurchaseListReq.newBuilder();
		SavePurchaseListResp resp = orderSdk.savePurchaseList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getPurchaseReplyList() throws IOException {
		GetPurchaseReplyListReq.Builder req = GetPurchaseReplyListReq.newBuilder();
		GetPurchaseReplyListResp resp = orderSdk.getPurchaseReplyList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void savePurchaseReplyList() throws IOException {
		SavePurchaseReplyListReq.Builder req = SavePurchaseReplyListReq.newBuilder();
		SavePurchaseReplyListResp resp = orderSdk.savePurchaseReplyList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updatePurchaseReplyStatus() throws IOException {
		UpdatePurchaseReplyStatusReq.Builder req = UpdatePurchaseReplyStatusReq.newBuilder();
		req.setIdStr("123");
		UpdatePurchaseReplyStatusResp resp = orderSdk.updatePurchaseReplyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updatePurchaseDetailEnd() throws IOException {
		UpdatePurchaseDetailEndReq.Builder req = UpdatePurchaseDetailEndReq.newBuilder();
		UpdatePurchaseDetailEndResp resp = orderSdk.updatePurchaseDetailEnd(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getMessageLogList() throws IOException {
		GetMessageLogListReq.Builder req = GetMessageLogListReq.newBuilder();
		GetMessageLogListResp resp = orderSdk.getMessageLogList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateMessageLogStatus() throws IOException {
		UpdateMessageLogStatusReq.Builder req = UpdateMessageLogStatusReq.newBuilder();
		req.setIdStr("123");
		UpdateMessageLogStatusResp resp = orderSdk.updateMessageLogStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void savePurchaseDetailList() throws IOException {
		SavePurchaseDetailListReq.Builder req = SavePurchaseDetailListReq.newBuilder();
		SavePurchaseDetailListResp resp = orderSdk.savePurchaseDetailList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void savePurchaseChangeList() throws IOException {
		SavePurchaseChangeListReq.Builder req = SavePurchaseChangeListReq.newBuilder();
		SavePurchaseChangeListResp resp = orderSdk.savePurchaseChangeList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getPurchaseChangeReplyList() throws IOException {
		GetPurchaseChangeReplyListReq.Builder req = GetPurchaseChangeReplyListReq.newBuilder();
		GetPurchaseChangeReplyListResp resp = orderSdk.getPurchaseChangeReplyList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updatePurchaseChangeReplyStatus() throws IOException {
		UpdatePurchaseChangeReplyStatusReq.Builder req = UpdatePurchaseChangeReplyStatusReq.newBuilder();
		req.setIdStr("123");
		UpdatePurchaseChangeReplyStatusResp resp = orderSdk.updatePurchaseChangeReplyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
