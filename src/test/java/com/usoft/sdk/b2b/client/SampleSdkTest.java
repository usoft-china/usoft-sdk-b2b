package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.sample.api.entity.*;
import com.usoft.b2b.external.erp.sample.api.protobuf.*;
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
public class SampleSdkTest {
	/**
	 * 测试地址
	 */
//	private SampleSdk sampleSdk = new SampleSdk("http://b2brest.uuzcc.cn:27120", "10050904", "c97d043cb9894c1e8c4dac330cf3cde9");
	private SampleSdk sampleSdk = new SampleSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

	/**
	 * 正式地址
	 */
//	private SampleSdk sampleSdk = new SampleSdk("http://b2b-api.usoftchina.com/","10041559","2c1ea089876b796fe050007f01002ea6");
	@Test
	public void saveProductSamples() throws IOException {
		SaveProductSamplesReq.Builder req = SaveProductSamplesReq.newBuilder();
		ProductSample.Builder sample = ProductSample.newBuilder();
		int random = new Random().nextInt(100000000);
		//对应erpid
		sample.setPsId(random);
		//流水号
		sample.setPsCode("PsCode" + random);
		//录入人
		sample.setPsRecordor("WCY");
		//单据录入日期(时间戳)
		sample.setPsIndate(new Date().getTime());
		//买方申请人uu
		sample.setPsAppmanuu(1000027480);
		//物料编号
		sample.setPsProdcode("PdProdcodeERP");
		//是否收费
		sample.setPsIsfree("是");
		//需求交货日期(时间戳)
		sample.setPsDelivery(new Date().getTime());
		//环保要求
		sample.setPsEnvrequire("PsEnvrequire");
		//使用范围
		sample.setPsScope("PsScope");
		//备注
		sample.setPsRemark("PsRemark");
//		string ps_attach = 12; //附件
		//附件
		sample.addAttaches(getAttach());
		ProductSampleDetail.Builder detail = ProductSampleDetail.newBuilder();
		//明细的ID
		detail.setPdId(random);
		//供应商UU
		detail.setPdVendoruu(10050624);
		//供应商联系人UU
		detail.setPdContactuu(1000027480);
		//序号
		detail.setPdDetno(1);
		//单价
		detail.setPdPrice(1.1);
		//币种
		detail.setPdCurrency("RMB");
		//税率
		detail.setPdTax(10);
		//数量
		detail.setPdNum(10);
		//总价
		detail.setPdTotalmon(detail.getPdPrice() * detail.getPdNum());
		//备注
		detail.setPdRemark("PdRemark");
		sample.addDetails(detail);
		req.addData(sample);
		SaveProductSamplesResp resp = sampleSdk.saveProductSamples(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSampleSend() throws IOException {
		GetSampleSendReq.Builder req = GetSampleSendReq.newBuilder();
		GetSampleSendResp resp = sampleSdk.getSampleSend(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSampleSendDownSuccess() throws IOException {
		OnSampleSendDownSuccessReq.Builder req = OnSampleSendDownSuccessReq.newBuilder();
		req.setIdStr("200623289400091302");
		OnSampleSendDownSuccessResp resp = sampleSdk.onSampleSendDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveProductSampleApprovals() throws IOException {
		SaveProductSampleApprovalsReq.Builder req = SaveProductSampleApprovalsReq.newBuilder();
		ProductSampleApproval.Builder approval = ProductSampleApproval.newBuilder();
		int random = new Random().nextInt(100000000);
		//对应的erpId
		approval.setPaId(random);
		//认定单号编号
		approval.setPaCode("PaCode" + random);
		//打样申请单号
		approval.setPaPscode("PaPscode");
		//送样单号
		approval.setPaSscode("PaSscode");
		//供应商UU
		approval.setPaVenduu(10050624);
		//物料编号
		approval.setPaProdcode("PaProdcode");
		//物料名称
		approval.setPrDetail("PrDetail");
		//物料规格
		approval.setPrSpec("PrSpec");
		//物料单位
		approval.setPrUnit("PrUnit");
		//数量
		approval.setPaSampleqty(10);
		//单重(g)
		approval.setPaHeight(1);
		//材料
		approval.setPaMaterial("PaMaterial");
		//材质
		approval.setPaMaterialquality("PaMaterialquality");
		//产地
		approval.setPaAddress("PaAddress");
		//产地标示
		approval.setPaAddressmark("PaAddressmark");
		//录入人
		approval.setPaRecordor("WCY");
		//录入日期(时间戳)
		approval.setPaInDate(new Date().getTime());
		//备注
		approval.setPaRemark("PaRemark");
		//收到样品时间 - 研发认定(时间戳)
		approval.setPaPrdtime(new Date().getTime());
		//收到样品数量 - 研发认定
		approval.setPaPrdypsl(1);
		//综合判定 - 研发认定
		approval.setPaPrdresult("PaPrdresult");
		//建议 - 研发判定
		approval.setPaPrdadvice("PaPrdadvice");
		//描述 - 研发认定
		approval.setPaPrdremark("PaPrdremark");
		//收到样品时间 - IQC认定(时间戳)
		approval.setPaPadtime(new Date().getTime());
		double pa_padypsl = 29; //收到样品数量 - IQC认定
		approval.setPaPadypsl(2);
		//综合判定 - IQC认定
		approval.setPaPadresult("PaPadresult");
		//建议 - IQC认定
		approval.setPaPadadvice("PaPadadvice");
		//描述 - IQC认定
		approval.setPaPadremark("PaPadremark");
		//收到样品时间 - 工程认定(时间戳)
		approval.setPaPpdtime(new Date().getTime());
		//收到样品数量 - 工程认定
		approval.setPaPpdypsl(3);
		//综合判定 - 工程认定
		approval.setPaPpdresult("PaPpdresult");
		//建议 - 工程认定
		approval.setPaPpdadvice("PaPpdadvice");
		//描述 - 工程认定
		approval.setPaPpdremark("PaPpdremark");
		//认定结果
		approval.setPaFinalresult("合格");
		//原因
		approval.setPaFinalresultremark("PaFinalresultremark");
		//优选等级
		approval.setPaYxdj("PaYxdj");
//		string pa_attach = 19; //附件
		//附件
		approval.addAttaches(getAttach());
//		string pa_prdattach = 26; //附件
		//附件
		approval.addPrdAttaches(getAttach());
//		string pa_padattach = 33; //附件
		//附件
		approval.addPadAttaches(getAttach());
//		string pa_ppdattach = 40; //附件
		//附件
		approval.addPpdAttaches(getAttach());
		req.addData(approval);
		SaveProductSampleApprovalsResp resp = sampleSdk.saveProductSampleApprovals(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void invalidateProductSample() throws IOException {
		InvalidateProductSampleReq.Builder req = InvalidateProductSampleReq.newBuilder();
//	Inquiry.Builder inquiry = Inquiry.newBuilder();
//	inquiry.setInId(64235889);
//	req.addData(inquiry);
		InvalidateProductSampleResp resp = sampleSdk.invalidateProductSample(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSamples() throws IOException {
		GetSamplesReq.Builder req = GetSamplesReq.newBuilder();
		GetSamplesResp resp = sampleSdk.getSamples(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSampleDownSuccess() throws IOException {
		OnSampleDownSuccessReq.Builder req = OnSampleDownSuccessReq.newBuilder();
		req.setIdStr("200623289400091302");
		OnSampleDownSuccessResp resp = sampleSdk.onSampleDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void saveSampleSend() throws IOException {
		SaveSampleSendReq.Builder req = SaveSampleSendReq.newBuilder();
		SaleSampleSend.Builder send = SaleSampleSend.newBuilder();
		int random = new Random().nextInt(100000000);
		//客户送样申请b2b Id
		send.setB2BPsId(0);
		//送样单号
		send.setSsCode("SsCode" + random);
		//送样数量
		send.setSsSendnum(5);
		//口水料比例
		send.setSsRatio(15);
		//单重(g)
		send.setSsHeight(2);
		//材料
		send.setSsMaterial("SsMaterial");
		//材质
		send.setSsMaterialquality("SsMaterialquality");
		//主要产地
		send.setSsAddress("SsAddress");
		//产地标示
		send.setSsAddressmark("SsAddressmark");
		//送样日期(时间戳)
		send.setSsIndate(new Date().getTime());
		//采购单价
		send.setSsPuprice(1.0);
		//备品率(%)
		send.setSsSpare(10);
		//品牌
		send.setSsBrand("SsBrand");
		//最小包装量
		send.setSsMinqty(1);
		//最小订购量
		send.setSsMinbuyqty(1);
		//交货周期
		send.setSsDelivery(3);
//		string ss_attach = 18; //
		//录入人（送样人）
		send.setSsRecorder("WCY");
		//申请单号
		send.setSsPscode("");
		//申请单明细序号
		send.setSsPddetno(1);
		//买方申请人uu
		send.setSsUseruu(1000027480);
		//生产厂型号（供应商的物料规格）
		send.setSsVendspec("SsVendspec");
		req.addData(send);
		SaveSampleSendResp resp = sampleSdk.saveSampleSend(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void getSampleApproval() throws IOException {
		GetSampleApprovalReq.Builder req = GetSampleApprovalReq.newBuilder();
		GetSampleApprovalResp resp = sampleSdk.getSampleApproval(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	@Test
	public void onSampleApprovalDownSuccess() throws IOException {
		OnSampleApprovalDownSuccessReq.Builder req = OnSampleApprovalDownSuccessReq.newBuilder();
		req.setIdStr("200623289400091302");
		OnSampleApprovalDownSuccessResp resp = sampleSdk.onSampleApprovalDownSuccess(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}

	private Attach.Builder getAttach() {
		Attach.Builder attach = Attach.newBuilder();
		attach.setFpName("2.png");
		attach.setFpUrl("https://static.uuzcc.cn/appb2b/11200526047835036816.png");
		attach.setFpSize(1231231);
		return attach;
	}
}
