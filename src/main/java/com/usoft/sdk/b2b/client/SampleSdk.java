package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.demand.api.entity.Inquiry;
import com.usoft.b2b.external.erp.demand.api.entity.InquiryDetail;
import com.usoft.b2b.external.erp.demand.api.entity.QuotationDown;
import com.usoft.b2b.external.erp.demand.api.entity.QuotationDownDecide;
import com.usoft.b2b.external.erp.demand.api.protobuf.*;
import com.usoft.b2b.external.erp.sample.api.entity.*;
import com.usoft.b2b.external.erp.sample.api.protobuf.*;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: wangcanyi
 * @date: 2019-12-12 17:41
 * @deprecated 废弃，请使用V2版
 **/
@Deprecated
public class SampleSdk extends BaseSdk {

	public SampleSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public SampleSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 将买家ERP的打样申请写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveProductSamplesResp saveProductSamples(SaveProductSamplesReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/sample";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<ProductSample> resultList = ProtoBufUtil.toProtoBufList(ProductSample.newBuilder().build(), respJson);
		SaveProductSamplesResp.Builder result = SaveProductSamplesResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 买家ERP从平台获取送样单
	 *
	 * @param req
	 * @return
	 */
	public GetSampleSendResp getSampleSend(GetSampleSendReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/sample/sampleSend";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleSampleSend> resultList = ProtoBufUtil.toProtoBufList(SaleSampleSend.newBuilder().build(), respJson);
		GetSampleSendResp.Builder result = GetSampleSendResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的送样单传到买家ERP之后，修改平台里面的送样单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSampleSendDownSuccessResp onSampleSendDownSuccess(OnSampleSendDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/sample/sampleSend/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSampleSendDownSuccessResp.newBuilder().build();
	}

	/**
	 * 将买家ERP的认定单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveProductSampleApprovalsResp saveProductSampleApprovals(SaveProductSampleApprovalsReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/sample/approval";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<ProductSampleApproval> resultList = ProtoBufUtil.toProtoBufList(ProductSampleApproval.newBuilder().build(), respJson);
		SaveProductSampleApprovalsResp.Builder result = SaveProductSampleApprovalsResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * erp作废打样申请单之后，平台修改对应状态
	 *
	 * @param req
	 * @return
	 */
	public InvalidateProductSampleResp invalidateProductSample(InvalidateProductSampleReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/sample/invalidate";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return InvalidateProductSampleResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取打样申请单
	 *
	 * @param req
	 * @return
	 */
	public GetSamplesResp getSamples(GetSamplesReq req) throws IOException {
		String url = baseUrl + "/erp/sale/sample";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleSampleDown> resultList = ProtoBufUtil.toProtoBufList(SaleSampleDown.newBuilder().build(), respJson);
		GetSamplesResp.Builder result = GetSamplesResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的客户打样申请传到供应商ERP之后，修改平台里面的客户打样申请的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSampleDownSuccessResp onSampleDownSuccess(OnSampleDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/sample";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSampleDownSuccessResp.newBuilder().build();
	}

	/**
	 * 将卖家ERP的送样单写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveSampleSendResp saveSampleSend(SaveSampleSendReq req) throws IOException {
		String url = baseUrl + "/erp/sale/sample/sampleSend";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveSampleSendResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取在平台的送样认定单
	 *
	 * @param req
	 * @return
	 */
	public GetSampleApprovalResp getSampleApproval(GetSampleApprovalReq req) throws IOException {
		String url = baseUrl + "/erp/sale/sample/sampleApproval";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<SaleSampleApproval> resultList = ProtoBufUtil.toProtoBufList(SaleSampleApproval.newBuilder().build(), respJson);
		GetSampleApprovalResp.Builder result = GetSampleApprovalResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的送样认定单传到供应商ERP之后，修改平台里面的送样认定单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnSampleApprovalDownSuccessResp onSampleApprovalDownSuccess(OnSampleApprovalDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/sample/sampleApproval";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnSampleApprovalDownSuccessResp.newBuilder().build();
	}
}
