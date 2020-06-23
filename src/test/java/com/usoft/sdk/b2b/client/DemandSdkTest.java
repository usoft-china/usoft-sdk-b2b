package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.demand.api.entity.*;
import com.usoft.b2b.external.erp.demand.api.protobuf.*;
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
public class DemandSdkTest {
	/**
	 * 测试地址
	 */
//	private DemandSdk demandSdk = new DemandSdk("http://b2brest.uuzcc.cn:27120", "10050904", "c97d043cb9894c1e8c4dac330cf3cde9");
	private DemandSdk demandSdk = new DemandSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

	/**
	 * 正式地址
	 */
//	private DemandSdk demandSdk = new DemandSdk("http://b2b-api.usoftchina.com/","10041559","2c1ea089876b796fe050007f01002ea6");
	@Test
	public void saveInquiries() throws IOException {
		SaveInquiriesReq.Builder req = SaveInquiriesReq.newBuilder();
		Inquiry.Builder inquiry = Inquiry.newBuilder();
		int random = new Random().nextInt(100000000);
		inquiry.setInId(random); //erpid
		inquiry.setInCode("IN"+random); //流水号
		inquiry.setInDate(new Date().getTime()); //单据归属日期(时间戳)
//		string in_recorder = 4; //录入人
//		inquiry.setInRecorderuu(); //询价单所属用户UU
//		string in_auditor = 6;
		inquiry.setInRecorddate(new Date().getTime()); //(时间戳)
//		string in_environment = 8; //环保要求
		inquiry.setInEnddate(new Date().getTime()); //报价截止日期(时间戳)
//		string in_remark = 10; //备注
//		string in_pricetype = 11; //价格类型
//		string in_kind = 13; //询价类型
//		int64 in_b2bid = 14; //b2b存储的id信息
//		int64 b2b_qu_id = 15; //主动报价时，平台的主动报价单SaleQuotation的ID
//		int64 in_buyeruu = 16;
		//附件
		Attach.Builder attach = Attach.newBuilder();
		attach.setFpName("2.png");
		attach.setFpUrl("https://static.uuzcc.cn/appb2b/11200526047835036816.png");
		inquiry.addAttaches(attach);
//		repeated InquiryDetail details = 12;
		InquiryDetail.Builder detail = InquiryDetail.newBuilder();
//		int64 b2b_id_id = 1;
		detail.setIdDetno(1); //序号
		detail.setIdProdcode("PdProdcodeERP"); //物料编号
		detail.setIdCurrency("RMB"); //币种
		detail.setIdRate(1); //税率
		detail.setVeUu(10050624); //供应商UU
//		string ve_contact = 7; //供应商联系人
//		int64 ve_contactuu = 8; //供应商联系人UU
//		string id_remark = 9; //备注
		detail.setIdId(random); //erpid
//		int64 id_myfromdate = 11; //买家预先提供的）有效期始(时间戳)
		detail.setIdMytodate(new Date().getTime()); //买家预先提供的）有效期止(时间戳)
//		int64 id_fromdate = 13; //(时间戳)
//		int64 id_todate = 14; //(时间戳)
//		double id_minbuyqty = 15; //（卖家报的）最小订购量
//		double id_minqty = 16; //卖家报的）最小包装量
//		string id_brand = 17; //供应商物料品牌
//		string id_vendorprodcode = 18; //供应商物料编号
//		int64 id_leadtime = 19; //供应商交互周期
//		repeated InquiryDetailDet dets = 20;
//		repeated RemoteFile files = 21;
//		string id_attach = 22;
//		int64 ve_buyeruu = 23; //买家采购员UU
//		string sourceApp = 24; //应用来源ERP、B2B
//		string id_vendname = 25; // 供应商名称
//		string id_vendyyzzh = 26; // 供应商营业执照号
//		string in_code = 27; // 公共询价时epr没有表不同，这时，需要新建数据
//		string in_inquirytype = 28; // 询价类型，公共询价传回到ERP时进行特殊处理
//		int32 id_quto = 29; //给是否自动询价赋值
		inquiry.addDetails(detail);
		req.addData(inquiry);
		SaveInquiriesResp resp = demandSdk.saveInquiries(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void checkInquiry() throws IOException {
		CheckInquiryReq.Builder req = CheckInquiryReq.newBuilder();
		CheckInquiryResp resp = demandSdk.checkInquiry(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onReplyInvalid() throws IOException {
		OnReplyInvalidReq.Builder req = OnReplyInvalidReq.newBuilder();
		Inquiry.Builder inquiry = Inquiry.newBuilder();
		inquiry.setInId(64235889);
		req.addData(inquiry);
		OnReplyInvalidResp resp = demandSdk.onReplyInvalid(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void reCheckInquiry() throws IOException {
		ReCheckInquiryReq.Builder req = ReCheckInquiryReq.newBuilder();
		ReCheckInquiryResp resp = demandSdk.reCheckInquiry(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getReply() throws IOException {
		GetReplyReq.Builder req = GetReplyReq.newBuilder();
		GetReplyResp resp = demandSdk.getReply(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onReplySuccess() throws IOException {
		OnReplySuccessReq.Builder req = OnReplySuccessReq.newBuilder();
		req.setIdStr("200623289400091302");
		OnReplySuccessResp resp = demandSdk.onReplySuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onReplyDecide() throws IOException {
		OnReplyDecideReq.Builder req = OnReplyDecideReq.newBuilder();
		InquiryDecide.Builder builder = InquiryDecide.newBuilder();
		builder.setInCode("IN96091928"); //询价编号
		builder.setIdDetno(1); //明细序号
		builder.setIdAgreed(1); //采纳状态
//		int64 b2b_qu_id = 4; //针对主动报价，主动报价id
//		int64 b2b_id = 5; //平台明细id
		req.addData(builder);
		OnReplyDecideResp resp = demandSdk.onReplyDecide(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getQuotations() throws IOException {
		GetQuotationsReq.Builder req = GetQuotationsReq.newBuilder();
		GetQuotationsResp resp = demandSdk.getQuotations(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onQuotationDownSuccess() throws IOException {
		OnQuotationDownSuccessReq.Builder req = OnQuotationDownSuccessReq.newBuilder();
		req.setIdStr("200623289400091302");
		OnQuotationDownSuccessResp resp = demandSdk.onQuotationDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveQuotationReplies() throws IOException {
		SaveQuotationRepliesReq.Builder req = SaveQuotationRepliesReq.newBuilder();
		QuotationDown.Builder builder = QuotationDown.newBuilder();
		builder.setB2BIdId(200623289400091302L);
//		int64 qu_custuu = 2; //询价单所属企业UU
//		int64 qu_selleruu = 3; //供应商联系人UU
//		string qu_code = 4; //询价单流水号
//		int32 qu_detno = 5; //序号
//		int64 qu_date = 6; //单据归属日期(时间戳)
//		int64 qu_recorddate = 7; //单据归属日期(时间戳)
//		int64 qu_enddate = 8; //报价截止日期(时间戳)
//		string qu_remark = 9; //备注
//		string qu_custprodcode = 10; //产品物料编号
//		string qu_custproddetail = 11; //产品标题
//		string qu_custprodspec = 12; //产品规格
//		string qu_currency = 13; //币种
		builder.setQuTaxrate(1); //税率
//		int64 qu_custfromdate = 15; //（买家预先提供的）有效期始(时间戳)
//		int64 qu_custtodate = 16; //（买家预先提供的）有效期止(时间戳)
//		int64 qu_fromdate = 17; //（卖家报的）有效期始(时间戳)
//		int64 qu_todate = 18; //（卖家报的）有效期止(时间戳)
		builder.setQuMinbuyqty(10); //（卖家报的）最小订购量
		builder.setQuMinqty(20); //（卖家报的）最小包装量
//		int32 qu_custlap = 21; //是否买家已设置分段数
//		string qu_environment = 22; //环保要求
		builder.setQuBrand("QuBrand"); //（卖家报的）物料品牌
		builder.setQuProdcode("QuProdcode"); //（卖家报的）供应商物料编号
		builder.setQuLeadtime(5); //（卖家报的）交货周期（天数)
//		string qu_pricetype = 26; //价格类型
//		repeated RemoteFile files = 27;
//		repeated QuotationDownDetail details = 28;
		QuotationDownDetail.Builder detail = QuotationDownDetail.newBuilder();
		detail.setQdLapqty(1);
		detail.setQdPrice(15);
		builder.addDetails(detail);
		req.addData(builder);
		SaveQuotationRepliesResp resp = demandSdk.saveQuotationReplies(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getQuotationDown() throws IOException {
		GetQuotationDownReq.Builder req = GetQuotationDownReq.newBuilder();
		GetQuotationDownResp resp = demandSdk.getQuotationDown(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onReplyDownSuccess() throws IOException {
		OnReplyDownSuccessReq.Builder req = OnReplyDownSuccessReq.newBuilder();
		OnReplyDownSuccessResp resp = demandSdk.onReplyDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getReplyDecide() throws IOException {
		GetReplyDecideReq.Builder req = GetReplyDecideReq.newBuilder();
		GetReplyDecideResp resp = demandSdk.getReplyDecide(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onReplyDecideDownSuccess() throws IOException {
		OnReplyDecideDownSuccessReq.Builder req = OnReplyDecideDownSuccessReq.newBuilder();
		req.setIdStr("200623289400091302");
		OnReplyDecideDownSuccessResp resp = demandSdk.onReplyDecideDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getReplyInvalid() throws IOException {
		GetReplyInvalidReq.Builder req = GetReplyInvalidReq.newBuilder();
		GetReplyInvalidResp resp = demandSdk.getReplyInvalid(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onReplyInvalidDownSuccess() throws IOException {
		OnReplyInvalidDownSuccessReq.Builder req = OnReplyInvalidDownSuccessReq.newBuilder();
		req.setIdStr("200623289664788702");
		OnReplyInvalidDownSuccessResp resp = demandSdk.onReplyInvalidDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getInquiryB2bId() throws IOException {
		GetInquiryB2bIdReq.Builder req = GetInquiryB2bIdReq.newBuilder();
		Inquiry.Builder inquiry = Inquiry.newBuilder();
		inquiry.setInId(96091928);
		req.addData(inquiry);
		GetInquiryB2bIdResp resp = demandSdk.getInquiryB2bId(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
