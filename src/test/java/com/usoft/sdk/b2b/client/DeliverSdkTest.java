package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.deliver.api.entity.*;
import com.usoft.b2b.external.erp.deliver.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Date;
import java.util.Random;

/**
 * @author uas
 * @date 2019/12/16 15:57
 * @deprecated 废弃，请使用V2版
 */
@Deprecated
public class DeliverSdkTest {
	/**
	 * 测试地址
	 */
//    private DeliverSdk deliverSdk = new DeliverSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");
	private DeliverSdk deliverSdk = new DeliverSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

	/**
	 * 正式地址
	 */
//	private DeliverSdk productSdk = new DeliverSdk("http://b2b-api.usoftchina.com", "10041559", "2c1ea089876b796fe050007f01002ea6");
	@Test
	public void savePurchaseNotify() throws IOException {
		SavePurchaseNotifyReq.Builder req = SavePurchaseNotifyReq.newBuilder();
		PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setPnId(random);//原id，erp id
//        int64 ve_uu = 2; //供应商UU号
		builder.setPnIndate(new Date().getTime());//录入日期(时间戳)
		builder.setPnQty(2);//需求数量
//        int64 pn_delivery = 5; //要求发货日期(时间戳)
		builder.setPnOrdercode("PuCode86280899");//订单编号
		builder.setPnOrderdetno(1);//订单明细序号
//        string pn_remark = 8; //备注
//        double pn_endqty = 9; //已发货数量
//        double pr_zxbzs = 10; //物料最小包装数
//        int64 pn_b2bid = 11; //b2bid
//        int64 pn_terminalvenduu = 12; //终端供应商，为0表示正常送货提醒
		req.addPurchaseNotifyList(builder);
		SavePurchaseNotifyResp resp = deliverSdk.savePurchaseNotify(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getAcceptNotifyList() throws IOException {
		GetAcceptNotifyListReq.Builder req = GetAcceptNotifyListReq.newBuilder();
		GetAcceptNotifyListResp resp = deliverSdk.getAcceptNotifyList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateAcceptNotifyStatus() throws IOException {
		UpdateAcceptNotifyStatusReq.Builder req = UpdateAcceptNotifyStatusReq.newBuilder();
		req.setIdstr("200612195196395700");
		UpdateAcceptNotifyStatusResp resp = deliverSdk.updateAcceptNotifyStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveAcceptNotify() throws IOException {
		SaveAcceptNotifyListReq.Builder req = SaveAcceptNotifyListReq.newBuilder();
		AcceptNotify.Builder builder = AcceptNotify.newBuilder();
		builder.setAnBuyeruu(123);
		builder.setAnRemark("frev");
		req.addAcceptNotifyList(builder);
		SaveAcceptNotifyListResp resp = deliverSdk.saveAcceptNotify(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updatePurchaseNotifyEnd() throws IOException {
		UpdatePurchaseNotifyEndReq.Builder req = UpdatePurchaseNotifyEndReq.newBuilder();
		PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
		builder.setPnB2Bid(200612194625887401L); //b2bid
		req.addPurchaseNotifyList(builder);
		UpdatePurchaseNotifyEndResp resp = deliverSdk.updatePurchaseNotifyEnd(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void checkPurchaseNotify() throws IOException {
		CheckPurchaseNotifyReq.Builder req = CheckPurchaseNotifyReq.newBuilder();
		CheckPurchaseNotifyResp resp = deliverSdk.checkPurchaseNotify(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveAcceptNotifyConfirm() throws IOException {
		SaveAcceptNotifyConfirmListReq.Builder req = SaveAcceptNotifyConfirmListReq.newBuilder();
		SaveAcceptNotifyConfirmListResp resp = deliverSdk.saveAcceptNotifyConfirm(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveAcceptNotifyVerify() throws IOException {
		SaveAcceptNotifyVerifyListReq.Builder req = SaveAcceptNotifyVerifyListReq.newBuilder();
		AcceptNotifyVerify.Builder builder = AcceptNotifyVerify.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setVadId(random);//来源ID（买方ERP）
		builder.setB2BSsId(200612195196395700L); //送货单主记录ID
		builder.setAndDetno(1); //送货单明细序号
		builder.setVadJyqty(2); //检验数量
		builder.setVeCode("VeCode" + random); //检验单号
//        double ve_okqty = 6; //检验合格数
//        double ve_notokqty = 7; //检验不合格数
//        string ve_testman = 8; //检验员
		builder.setVeDate(new Date().getTime());//检验日期(时间戳)
		req.addVerifyList(builder);
		SaveAcceptNotifyVerifyListResp resp = deliverSdk.saveAcceptNotifyVerify(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveUnAcceptNotifyVerify() throws IOException {
		SaveUnAcceptNotifyVerifyListReq.Builder req = SaveUnAcceptNotifyVerifyListReq.newBuilder();
		SaveUnAcceptNotifyVerifyListResp resp = deliverSdk.saveUnAcceptNotifyVerify(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getPurchaseNotifyB2bId() throws IOException {
		GetPurchaseNotifyB2bIdReq.Builder req = GetPurchaseNotifyB2bIdReq.newBuilder();
		PurchaseNotify.Builder builder = PurchaseNotify.newBuilder();
		builder.setPnId(5043764);
		req.addPurchaseNotifyList(builder);
		GetPurchaseNotifyB2bIdResp resp = deliverSdk.getPurchaseNotifyB2bId(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}


	@Test
	public void savePurchaseProdInOut() throws IOException {
		SavePurchaseProdInOutReq.Builder req = SavePurchaseProdInOutReq.newBuilder();
		PurchaseProdInOut.Builder builder = PurchaseProdInOut.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setPiId(random); //erp出入库单据的id
		builder.setPiInoutno("Inout" + random); //erp出入库单据单号
//        int64 pi_vendoruu = 3; //供应商UU
//        string pi_currency = 4; //币别
//        float pi_rate = 5; //汇率
//        string pi_payment = 6; //付款方式
//        string pi_transport = 7; //运输方式
//        string pi_remark = 8; //备注
//        string pi_inoutman = 9; //过账人
		builder.setPiDate(new Date().getTime()); //过账日期(时间戳)
//        string pi_sendcode = 11; //送货单号
//        string pi_receivename = 12; //应付供应商名
//        string pi_receivecode = 13; //应付供应商编号
//        int64 pi_b2b_id = 14; //b2bId
		PurchaseProdInOut.PurchaseProdInOutDetail.Builder detail = PurchaseProdInOut.PurchaseProdInOutDetail.newBuilder();
		detail.setPdDetno(1); // 明细行序号
//        string pd_ordercode = 2; // 采购单编号
//        int32 pd_orderdetno = 3; // 采购单明细行号
		detail.setPdInqty(2); // 入库数量
//        double pd_outqty = 5; // 出库数量
//        double pd_orderprice = 6; // 采购成本
//        double pd_taxrate = 7; // 税率
//        string pd_batchcode = 8; // 批号
//        string pd_remark = 9; // 备注
//        string pd_prodcode = 10; //物料编号
//        string pd_whname = 11; //仓库名称
		detail.setB2BSiId(200612195196455702L);//平台送货单明细id
		builder.addDetails(detail);
		req.addData(builder);
		SavePurchaseProdInOutResp resp = deliverSdk.savePurchaseProdInOut(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void nonPostingProdInOut() throws IOException {
		NonPostingProdInOutReq.Builder req = NonPostingProdInOutReq.newBuilder();
		PurchaseProdInOut.Builder builder = PurchaseProdInOut.newBuilder();
		builder.setPiInoutno("Inout74019992");
		req.addData(builder);
		NonPostingProdInOutResp resp = deliverSdk.nonPostingProdInOut(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void refreshPrice() throws IOException {
		RefreshPriceReq.Builder req = RefreshPriceReq.newBuilder();
		ProdInOutRefreshPrice.Builder builder = ProdInOutRefreshPrice.newBuilder();
		builder.setPbuPdno(1);
		; //明细行序号
		builder.setPbuInoutno("Inout74019992"); //单据编号
		builder.setPbuOrderprice(30); //采购成本
		builder.setPbuTaxrate(1); //税率
//		int64 pbu_id = 5; //erpid
//		string pd_prodcode = 6; //物料编号
//		int32 pd_orderdetno = 7; //订单编号
//		string pbu_piclass = 8; //单据类型
		req.addData(builder);
		RefreshPriceResp resp = deliverSdk.refreshPrice(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void savePurchaseProdReturn() throws IOException {
		SavePurchaseProdReturnReq.Builder req = SavePurchaseProdReturnReq.newBuilder();
		PurchaseProdInOut.Builder builder = PurchaseProdInOut.newBuilder();
		int random = new Random().nextInt(100000000);
		builder.setPiId(random); //erp出入库单据的id
		builder.setPiInoutno("Inout" + random); //erp出入库单据单号
//        int64 pi_vendoruu = 3; //供应商UU
//        string pi_currency = 4; //币别
//        float pi_rate = 5; //汇率
//        string pi_payment = 6; //付款方式
//        string pi_transport = 7; //运输方式
//        string pi_remark = 8; //备注
//        string pi_inoutman = 9; //过账人
		builder.setPiDate(new Date().getTime()); //过账日期(时间戳)
//        string pi_sendcode = 11; //送货单号
//        string pi_receivename = 12; //应付供应商名
//        string pi_receivecode = 13; //应付供应商编号
//        int64 pi_b2b_id = 14; //b2bId
		PurchaseProdInOut.PurchaseProdInOutDetail.Builder detail = PurchaseProdInOut.PurchaseProdInOutDetail.newBuilder();
		detail.setPdDetno(1); // 明细行序号
		detail.setPdOrdercode("PuCode93468538"); // 采购单编号
		detail.setPdOrderdetno(1); // 采购单明细行号
//		detail.setPdInqty(2); // 入库数量
		detail.setPdOutqty(2); // 出库数量
//        double pd_orderprice = 6; // 采购成本
//        double pd_taxrate = 7; // 税率
//        string pd_batchcode = 8; // 批号
//        string pd_remark = 9; // 备注
//        string pd_prodcode = 10; //物料编号
//        string pd_whname = 11; //仓库名称
		builder.addDetails(detail);
		req.addData(builder);
		SavePurchaseProdReturnResp resp = deliverSdk.savePurchaseProdReturn(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void nonPostingProdReturn() throws IOException {
		NonPostingProdReturnReq.Builder req = NonPostingProdReturnReq.newBuilder();
		PurchaseProdInOut.Builder builder = PurchaseProdInOut.newBuilder();
		builder.setPiInoutno("Inout44434645");
		req.addData(builder);
		NonPostingProdReturnResp resp = deliverSdk.nonPostingProdReturn(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void refreshPriceForPurcReturn() throws IOException {
		RefreshPriceForPurcReturnReq.Builder req = RefreshPriceForPurcReturnReq.newBuilder();
		ProdInOutRefreshPrice.Builder builder = ProdInOutRefreshPrice.newBuilder();
		builder.setPbuPdno(1); //明细行序号
		builder.setPbuInoutno("Inout44434645");//单据编号
		builder.setPbuOrderprice(20);//采购成本
		builder.setPbuTaxrate(1);//税率
//		int64 pbu_id = 5; //erpid
//		string pd_prodcode = 6; //物料编号
//		int32 pd_orderdetno = 7; //订单编号
//		string pbu_piclass = 8; //单据类型
		req.addData(builder);
		RefreshPriceForPurcReturnResp resp = deliverSdk.refreshPriceForPurcReturn(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleNotifyDownList() throws IOException {
		GetSaleNotifyDownListReq.Builder req = GetSaleNotifyDownListReq.newBuilder();
		GetSaleNotifyDownListResp resp = deliverSdk.getSaleNotifyDownList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleNotifyDownStatus() throws IOException {
		UpdateSaleNotifyDownStatusReq.Builder req = UpdateSaleNotifyDownStatusReq.newBuilder();
		req.setIdStr("200612194625887401,200612194376056801");
		UpdateSaleNotifyDownStatusResp resp = deliverSdk.updateSaleNotifyDownStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveSaleOutList() throws IOException {
		SaveSaleOutListReq.Builder req = SaveSaleOutListReq.newBuilder();
		SaleOut.Builder builder = SaleOut.newBuilder();
		int random = new Random().nextInt(100000000);
//        int64 b2b_ss_id = 1; //平台发货单id
		builder.setPiInoutno("PI" + random); //送货单号
//        string pi_currency = 3; //币别
//        float pi_rate = 4; //汇率
//        int64 cu_uu = 5; //客户企业UU
//        int64 cu_contactuu = 6; //客户联系人UU
//        string pi_payment = 7; //付款方式
//        string pi_remark = 8; //备注
//        string pi_recordman = 9; //录单人
//        string pi_auditman = 10;
		SaleOut.SaleOutDetail.Builder detail = SaleOut.SaleOutDetail.newBuilder();
		detail.setPdPdno(1); //序号
		detail.setPdOutqty(2); //数量
//        double pd_sendprice = 3; //单价
		detail.setPdOrderid(200529074717466004L); //关联的平台客户采购明细ID
		detail.setB2BPnId(200612194625887401L); //关联的平台送货提醒单ID
		builder.addDetails(detail);
		req.addSaleOutList(builder);
		SaveSaleOutListResp resp = deliverSdk.saveSaleOutList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleOutList() throws IOException {
		GetSaleOutListReq.Builder req = GetSaleOutListReq.newBuilder();
		GetSaleOutListResp resp = deliverSdk.getSaleOutList(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleOutStatus() throws IOException {
		UpdateSaleOutStatusReq.Builder req = UpdateSaleOutStatusReq.newBuilder();
		req.setIdStr("123");
		UpdateSaleOutStatusResp resp = deliverSdk.updateSaleOutStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleNotifyEnd() throws IOException {
		GetSaleNotifyEndReq.Builder req = GetSaleNotifyEndReq.newBuilder();
		GetSaleNotifyEndResp resp = deliverSdk.getSaleNotifyEnd(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void updateSaleNotifyDownEndStatus() throws IOException {
		UpdateSaleNotifyDownEndStatusReq.Builder req = UpdateSaleNotifyDownEndStatusReq.newBuilder();
		req.setIdStr("200612194625887401");
		UpdateSaleNotifyDownEndStatusResp resp = deliverSdk.updateSaleNotifyDownEndStatus(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleProdInOut() throws IOException {
		GetSaleProdInOutReq.Builder req = GetSaleProdInOutReq.newBuilder();
		GetSaleProdInOutResp resp = deliverSdk.getSaleProdInOut(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSaleProdInOutSuccess() throws IOException {
		OnSaleProdInOutSuccessReq.Builder req = OnSaleProdInOutSuccessReq.newBuilder();
		req.setIdStr("200612195540438805");
		OnSaleProdInOutSuccessResp resp = deliverSdk.onSaleProdInOutSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getNonPostingSaleProdInOut() throws IOException {
		GetNonPostingSaleProdInOutReq.Builder req = GetNonPostingSaleProdInOutReq.newBuilder();
		GetNonPostingSaleProdInOutResp resp = deliverSdk.getNonPostingSaleProdInOut(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onNonPostingSaleProdInOutSuccess() throws IOException {
		OnNonPostingSaleProdInOutSuccessReq.Builder req = OnNonPostingSaleProdInOutSuccessReq.newBuilder();
		req.setIdStr("200612195540438805");
		OnNonPostingSaleProdInOutSuccessResp resp = deliverSdk.onNonPostingSaleProdInOutSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSaleProdReturn() throws IOException {
		GetSaleProdReturnReq.Builder req = GetSaleProdReturnReq.newBuilder();
		GetSaleProdReturnResp resp = deliverSdk.getSaleProdReturn(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSaleProdReturnSuccess() throws IOException {
		OnSaleProdReturnSuccessReq.Builder req = OnSaleProdReturnSuccessReq.newBuilder();
		req.setIdStr("200615219116116800");
		OnSaleProdReturnSuccessResp resp = deliverSdk.onSaleProdReturnSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getNonPostingSaleProdReturn() throws IOException {
		GetNonPostingSaleProdReturnReq.Builder req = GetNonPostingSaleProdReturnReq.newBuilder();
		GetNonPostingSaleProdReturnResp resp = deliverSdk.getNonPostingSaleProdReturn(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onNonPostingSaleProdReturnSuccess() throws IOException {
		OnNonPostingSaleProdReturnSuccessReq.Builder req = OnNonPostingSaleProdReturnSuccessReq.newBuilder();
		req.setIdStr("200615219116116800");
		OnNonPostingSaleProdReturnSuccessResp resp = deliverSdk.onNonPostingSaleProdReturnSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
