package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.order.api.entity.Purchase;
import com.usoft.b2b.external.erp.order.api.protobuf.*;
import com.usoft.sdk.b2b.client.OrderSdk;
import com.usoft.sdk.b2b.utils.DateUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 **/
public class OrderSdkTest {
	/**
	 * 测试地址
	 */
	private OrderSdk orderSdk = new OrderSdk("http://test-b2b.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");
//	private OrderSdk orderSdk = new OrderSdk("http://local.uuzcc.cn:8090/platform-b2b", "10050624", "c49f7be6a861461ab951e55030055a5c");

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
		Purchase.Builder purchase = Purchase.newBuilder();
		//订单基本信息
		int random = new Random().nextInt(100000000);
		purchase.setPuCode("PuCode" + random);//采购单号
//		purchase.setPuDate(DateUtil.getCurrentDate("yyyy/MM/dd"));  //单据归属日期(yyyy-MM-dd HH:mm:ss)
		purchase.setPuDate(new Date().getTime());//+""  "2020/01/15"
		purchase.setEmUu(1000027480);  //ERP单据中采购员UU号
		purchase.setEmName("EmName");  //ERP单据中采购员姓名
		purchase.setEmSex("男");  //ERP单据中采购员性别
		purchase.setEmMobile("13611111111");  //ERP单据中采购员电话
		purchase.setEmEmail("ememail@email.com");  //ERP单据中采购员邮箱
		purchase.setVeUu(10050624);  //供应商uu
		purchase.setPuCop("PuCop");  //客户公司名称
		purchase.setVeContactuu(1000027480);  //ERP中单据供应商联系人UU
		purchase.setPuCurrency("RMB");//付款币种(RMB USD)
		purchase.setPuRate(1);  //汇率
		purchase.setPuKind("一般请购");  // 采购类型
		purchase.setPuPayments("月结30天");//付款方式
		purchase.setPuRemark("PuRemark");  //备注
		purchase.setPuRecordman("张三");  //录单人
		purchase.setPuAuditman("李四");  //审核人
		purchase.setPuShipaddresscode("福建省漳州市南靖县万利达工业园B栋 王五收 手机:13611111111");  //收货地址
		purchase.setPuReceivename("深圳市XXX电子有限公司");  //应付供应商名称
		purchase.setPuReceivecode("1017");  //应付供应商编号
		purchase.setPuId(random);  //在ERP中采购单的id

		//订单明细
		Purchase.PurchaseDetail.Builder detail = Purchase.PurchaseDetail.newBuilder();
		detail.setPdCode("PuCode" + random); //采购单号
		detail.setPdProdcode("PdProdcode"); //物料编号   PdProdcode
		detail.setPdQty(10); //采购数量
		detail.setPdPrice(10.0); //单价
//		detail.setPdDelivery(DateUtil.getCurrentDate("yyyy/MM/dd")); //交货日期DateUtil.getCurrentDate(DateUtil.PATTERN_DATE_TIME)
		detail.setPdDelivery(new Date().getTime()); //交货日期
		detail.setPdRemark("PdRemark"); //备注
		detail.setPdRate(0.01f); //税率
		detail.setPdDetno(1); //序号
//		string pd_factory = 9; //送货工厂
		detail.setPdVendspec("PdVendspec"); //供应商规格
//		int32 pd_beipin = 11; //备品数量
		detail.setPdPurcvendname("PdPurcvendname"); //终端供应商名称
//		int64 pd_purcvenduu = 13; //终端供应商uu
//		string pd_custpurchasecode = 14; //客户采购订单号
//		int32 pd_custpurchasedetno = 15; //客户采购订单序号
//		string pd_acceptcustname = 16; //收货客户
//		string pd_acceptcustaddress = 17; //收货地址
//		int64 pd_acceptcustuu = 18; //收货客户uu
//		string pd_hasissued = 19; //是否能发货
//		float pd_purcprice = 20; //终端价格
//		float pd_purctaxrate = 21; //终端税率
//		string pd_purccurrency = 22; //终端币别
//		string pd_taxcode = 23; //税收分类编码
//		string pd_billname = 24; //开票名称
//		string pd_orispeccode = 25;//开票型号
//		message Attach {
//			int64 fp_id = 1; //id
//			string fp_name = 2; //附件名称
//			string fp_url = 3; //附件Url
//			int64 fp_size = 4; //附件大小
//		}
//		repeated Attach attaches = 26; //附件
//		string pd_repprodcode = 27; //替代料号
//		string pd_repdetail = 28; //替代料名称
//		string pd_repspec = 29; //替代料规格
//		string pr_oldcode = 30; //旧料编号
//		string pr_oldname = 31; //旧料名称
//		string pr_oldspec = 32; //旧料规格
		purchase.addPurchaseDetails(detail);
		req.addData(purchase);
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
