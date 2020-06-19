package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.order.api.entity.*;
import com.usoft.b2b.external.erp.order.api.protobuf.*;
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
public class OrderSdkTest {
	/**
	 * 测试地址
	 */
//	private OrderSdk orderSdk = new OrderSdk("http://b2brest.uuzcc.cn:27120", "10050904", "c97d043cb9894c1e8c4dac330cf3cde9");
	private OrderSdk orderSdk = new OrderSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

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
		req.setIdStr("200611184550540200");
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
		SaleReply.Builder sr = SaleReply.newBuilder();
		int random = new Random().nextInt(100000000);
		sr.setSrId(random); //erpid
		sr.setSrQty(1); //数量
		sr.setSrDelivery(new Date().getTime());//交货日期(时间戳)
		sr.setSrRemark("SrRemark");//备注
		sr.setSrSacode("PuCode93468538");//采购单单号
		sr.setSrSddetno(1); //采购明细序号
		sr.setSrDate(new Date().getTime());//回复日期(时间戳)
//		string sr_recorder = 8; //回复人
		sr.setCuUu(10050624);
//		int64 b2b_pd_id = 10; //明细id
//		int64 b2b_pr_id = 11; //回复id
//		string sr_type = 12; //类型{供应商ERP回复、供应商平台回复、采购主动回复}
		req.addData(sr);
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
		req.setIdStr("200611184550541001");
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
		req.setIdStr("200612193205966100");
		UpdateSaleDownChangeStatusResp resp = orderSdk.updateSaleDownChangeStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveSaleDownChangeReply() throws IOException {
		SaveSaleDownChangeReplyReq.Builder req = SaveSaleDownChangeReplyReq.newBuilder();
		SaleDownChangeReply.Builder builder = SaleDownChangeReply.newBuilder();
		builder.setB2BPcId(200612193205966100L);//平台采购订单变更单id
		builder.setScCode("PcCode36454303"); //采购变更单号
		builder.setScAgreed(1);//供应商是否同意了我的变更请求(1,0)
		builder.setScReplyremark("Replyremark");//供应商的回复备注
		req.addChangeReplyList(builder);
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
		detail.setPdProdcode("PdProdcodeERP"); //物料编号   PdProdcode
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
		detail.setPdTaxcode("PdTaxcode"); //税收分类编码
		detail.setPdBillname("PdBillname"); //开票名称
		detail.setPdOrispeccode("PdOrispeccode");//开票型号
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
		req.setIdStr("200611185881734500,200611184674226800");
		UpdatePurchaseReplyStatusResp resp = orderSdk.updatePurchaseReplyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updatePurchaseDetailEnd() throws IOException {
		UpdatePurchaseDetailEndReq.Builder req = UpdatePurchaseDetailEndReq.newBuilder();
		PurchaseDetailEnd.Builder end = PurchaseDetailEnd.newBuilder();
		end.setPdCode("PuCode93468538");
		end.setPdDetno(1);
		end.setPdEnded(1);
		req.addData(end);
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
	public void getPurchaseB2bId() throws IOException {
		GetPurchaseB2bIdReq.Builder req = GetPurchaseB2bIdReq.newBuilder();
		Purchase.Builder builder = Purchase.newBuilder();
		builder.setPuId(93468538);
		req.addData(builder);
		GetPurchaseB2bIdResp resp = orderSdk.getPurchaseB2bId(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void savePurchaseChangeList() throws IOException {
		SavePurchaseChangeListReq.Builder req = SavePurchaseChangeListReq.newBuilder();
		PurchaseChange.Builder builder = PurchaseChange.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setPcId(random);
		builder.setPcCode("PcCode" + random); //采购变更单号
		builder.setPcPurccode("PuCode86280899");//采购单单号
		builder.setPcIndate(new Date().getTime());//单据录入日期(时间戳)
//		string pc_recorder = 5; //录单人
		builder.setPcNewpayments("月结30天");//新付款方式
		builder.setPcNewcurrency("RMB"); //新付款币种
		builder.setPcNewrate(2);//新汇率
//		string pc_apvendname = 9; //采购变更单原应付供应商
//		string pc_newapvendname = 10; //采购变更单新应付供应商
//		string pc_apvendcode = 11; //原应付供应商编号
//		string pc_newapvendcode = 12; //新应付供应商编号
//		string pc_description = 13; //变更内容描述
//		string pc_remark = 14; //备注
//		int32 pc_agreed = 15; //卖家是否同意了买家的变更请求(1,0)
//		int32 pc_needvendcheck = 16; //不需要供应商确认(1表示不需要确认,0表示需要确认)
		PurchaseChange.PurchaseChangeDetail.Builder detail = PurchaseChange.PurchaseChangeDetail.newBuilder();
		detail.setPcdDetno(1);//序号(变更单)
		detail.setPcdPddetno(1); //采购订单明细序号
//		string pcd_prodcode = 3; //
//		string pcd_newprodcode = 4; //新物料编号
		detail.setPcdNewqty(30);//新数量
		detail.setPcdNewprice(20);//新含税单价
//		int64 pcd_newdelivery = 7; //新交货日期(时间戳)
//		float pcd_newtaxrate = 8; //新税率
//		string pcd_remark = 9; //备注
		builder.addChangeDetails(detail);
		req.addPurchaseChangeList(builder);
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
		req.setIdStr("200612193205966100");
		UpdatePurchaseChangeReplyStatusResp resp = orderSdk.updatePurchaseChangeReplyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
