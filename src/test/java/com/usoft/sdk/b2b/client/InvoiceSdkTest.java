package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.invoice.api.entity.APBill;
import com.usoft.b2b.external.erp.invoice.api.entity.APBillDetail;
import com.usoft.b2b.external.erp.invoice.api.protobuf.*;
import com.usoft.sdk.b2b.client.InvoiceSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author uas
 * @deprecated 废弃，请使用V2版
 * @date 2019/12/16 11:43
 */
@Deprecated
public class InvoiceSdkTest {

	/**
	 * 测试地址
	 */
//	private InvoiceSdk invoiceSdk = new InvoiceSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");
	private InvoiceSdk invoiceSdk = new InvoiceSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

	/**
	 * 正式地址
	 */
//	private ProductSdk productSdk = new ProductSdk("http://b2b-api.usoftchina.com", "10041559", "2c1ea089876b796fe050007f01002ea6");
	@Test
	public void saveApBills() throws IOException {
		SaveApBillsReq.Builder req = SaveApBillsReq.newBuilder();
		APBill.Builder builder = APBill.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setAbId(random);//对应erpid
		builder.setAbCode("AbCode"+random);//单号
		builder.setAbDate(new Date().getTime());//日期 时间戳
//		int64 ab_yearmonth = 4;//账期
		builder.setAbCurrency("RMB");//币别
//		double ab_rate = 6;//汇率
//		string ab_buyer = 7;//
		builder.setAbVendoruu(10050624);//供应商所属企业UU
//		string ab_status = 9;//状态
		builder.setAbPayments("月结30天");//付款方式
//		int64 ab_paydate = 11;//付款日期 时间戳
		builder.setAbRefno("Refno"+random);//发票号
//		string ab_recorder = 13;//录入人
		builder.setAbIndate(new Date().getTime());//录入日期 时间戳
//		double ab_apamount = 15;//应付金额
//		double ab_payamount = 16;//付款金额
//		string ab_pricetermdes = 17;//价格条件
//		double ab_taxsum = 18;//税金合计
//		double ab_differ = 19;//税金差异
//		string ab_remark = 20;//备注
//		int64 ab_b2bi = 21;//
//		int64 ab_customeruu = 22;//采购单所属企业UU

		APBillDetail.Builder detail = APBillDetail.newBuilder();
		detail.setAbdDetno(1);//明细序号
		detail.setAbdOrdercode("PuCode93468538");//采购单号
		detail.setAbdOrderdetno(1);//采购单明细序号
		detail.setAbdPdinoutno("Inout"+random);//出入库单号
//		string abd_prodcode = 5;//产品编号
//		string abd_custprodcode = 6; //客户物料编号
//		string abd_custproddetail = 7; //客户物料名称
//		string abd_custprodspec = 8; //客户物料规格
		detail.setAbdThisvoqty(1);//数量
//		double abd_price = 10;//采购单价
//		double abd_taxrate = 11;//税率
//		double abd_amount = 12;//单据金额
//		double abd_totalbillprice = 13;//累计开票金额
		detail.setAbdQty(1);//本次开票数量
//		double abd_thisvoprice = 15;//本次开票单价
//		double abd_apamount = 16;//本次开票金额
//		double abd_noapamount = 17;//本次 开票不含税金额
//		double abd_taxamount = 18;//本次开票税额
//		string abd_remark = 19;//备注
//		double abd_invoqty = 20;//已开票数
//		double abd_yqty = 21;//已转开票记录数
		builder.addDetails(detail);
		req.addData(builder);
		SaveApBillsResp resp = invoiceSdk.saveApBills(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
	@Test
	public void saveNonPostingApBills() throws IOException {
		SaveNonPostingApBillsReq.Builder req = SaveNonPostingApBillsReq.newBuilder();
		APBill.Builder builder = APBill.newBuilder();
		builder.setAbCode("AbCode20531583");
		req.addData(builder);
		SaveNonPostingApBillsResp resp = invoiceSdk.saveNonPostingApBills(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleAPBills() throws IOException {
		GetSaleAPBillsReq.Builder req = GetSaleAPBillsReq.newBuilder();
		GetSaleAPBillsResp resp = invoiceSdk.getSaleAPBills(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSaleAPBillDownSuccess() throws IOException {
		OnSaleAPBillDownSuccessReq.Builder req = OnSaleAPBillDownSuccessReq.newBuilder();
		req.setIdStr("200615220482822202");
		OnSaleAPBillDownSuccessResp resp = invoiceSdk.onSaleAPBillDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
	@Test
	public void getSaleNonPostingAPBills() throws IOException {
		GetSaleNonPostingAPBillsReq.Builder req = GetSaleNonPostingAPBillsReq.newBuilder();
		GetSaleNonPostingAPBillsResp resp = invoiceSdk.getSaleNonPostingAPBills(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSaleNonPostingAPBillDownSuccess() throws IOException {
		OnSaleNonPostingAPBillDownSuccessReq.Builder req = OnSaleNonPostingAPBillDownSuccessReq.newBuilder();
		req.setIdStr("200615220482822202");
		OnSaleNonPostingAPBillDownSuccessResp resp = invoiceSdk.onSaleNonPostingAPBillDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
