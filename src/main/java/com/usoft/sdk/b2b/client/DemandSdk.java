package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.demand.api.entity.Inquiry;
import com.usoft.b2b.external.erp.demand.api.entity.InquiryDetail;
import com.usoft.b2b.external.erp.demand.api.entity.QuotationDown;
import com.usoft.b2b.external.erp.demand.api.entity.QuotationDownDecide;
import com.usoft.b2b.external.erp.demand.api.protobuf.*;
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
public class DemandSdk extends BaseSdk {

	public DemandSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public DemandSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

	/**
	 * 将买家ERP的采购询价写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveInquiriesResp saveInquiries(SaveInquiriesReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<Inquiry> resultList = ProtoBufUtil.toProtoBufList(Inquiry.newBuilder().build(), respJson);
		SaveInquiriesResp.Builder result = SaveInquiriesResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 买家在收到报价信息后，点击提交按钮后，状态传至平台，至此平台的供应商不能再对这张询价单进行报价
	 *
	 * @param req
	 * @return
	 */
	public CheckInquiryResp checkInquiry(CheckInquiryReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry/checking";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return CheckInquiryResp.newBuilder().build();
	}

	/**
	 * 买家ERP作废询价单后，修改平台里面的状态
	 *
	 * @param req
	 * @return
	 */
	public OnReplyInvalidResp onReplyInvalid(OnReplyInvalidReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry/invalid";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return OnReplyInvalidResp.newBuilder().build();
	}

	/**
	 * 买家反提交询价单后，状态传回平台，待报价单据重新回到待报价列表且可以进行报价，已报价单据可以修改报价
	 *
	 * @param req
	 * @return
	 */
	public ReCheckInquiryResp reCheckInquiry(ReCheckInquiryReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry/reCheck";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return ReCheckInquiryResp.newBuilder().build();
	}

	/**
	 * 买家ERP获取平台的报价信息
	 *
	 * @param req
	 * @return
	 */
	public GetReplyResp getReply(GetReplyReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry/reply";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<InquiryDetail> resultList = ProtoBufUtil.toProtoBufList(InquiryDetail.newBuilder().build(), respJson);
		GetReplyResp.Builder result = GetReplyResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的报价信息传到买家ERP之后，修改平台里面的询价单明细的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnReplySuccessResp onReplySuccess(OnReplySuccessReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry/reply/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnReplySuccessResp.newBuilder().build();
	}

	/**
	 * 买家ERP（不）采纳了价格之后，修改平台里面的报价信息的状态
	 *
	 * @param req
	 * @return
	 */
	public OnReplyDecideResp onReplyDecide(OnReplyDecideReq req) throws IOException {
		String url = baseUrl + "/erp/purchase/inquiry/reply/decide";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return OnReplyDecideResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取未报价的询价明细
	 *
	 * @param req
	 * @return
	 */
	public GetQuotationsResp getQuotations(GetQuotationsReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<QuotationDown> resultList = ProtoBufUtil.toProtoBufList(QuotationDown.newBuilder().build(), respJson);
		GetQuotationsResp.Builder result = GetQuotationsResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的客户询价单传到供应商ERP之后，修改平台里面的询价单的上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnQuotationDownSuccessResp onQuotationDownSuccess(OnQuotationDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnQuotationDownSuccessResp.newBuilder().build();
	}

	/**
	 * 将卖家ERP的报价信息写到平台
	 *
	 * @param req
	 * @return
	 */
	public SaveQuotationRepliesResp saveQuotationReplies(SaveQuotationRepliesReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		HttpUtil.doPost(url, fromData, timeout);
		return SaveQuotationRepliesResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取在平台报价的记录
	 *
	 * @param req
	 * @return
	 */
	public GetQuotationDownResp getQuotationDown(GetQuotationDownReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<QuotationDown> resultList = ProtoBufUtil.toProtoBufList(QuotationDown.newBuilder().build(), respJson);
		GetQuotationDownResp.Builder result = GetQuotationDownResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的报价记录传到供应商ERP之后，修改平台里面的询价明细的报价记录上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnReplyDownSuccessResp onReplyDownSuccess(OnReplyDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnReplyDownSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取报价信息的采纳结果
	 *
	 * @param req
	 * @return
	 */
	public GetReplyDecideResp getReplyDecide(GetReplyDecideReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply/decide";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<QuotationDownDecide> resultList = ProtoBufUtil.toProtoBufList(QuotationDownDecide.newBuilder().build(), respJson);
		GetReplyDecideResp.Builder result = GetReplyDecideResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的报价信息采纳结果传到供应商ERP之后，修改平台里面的采纳结果上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnReplyDecideDownSuccessResp onReplyDecideDownSuccess(OnReplyDecideDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply/decide/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnReplyDecideDownSuccessResp.newBuilder().build();
	}

	/**
	 * 卖家ERP从平台获取报价信息的作废
	 *
	 * @param req
	 * @return
	 */
	public GetReplyInvalidResp getReplyInvalid(GetReplyInvalidReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply/invalid";
		Map<String, String> params = generateSignature(url, null);
		String respJson = HttpUtil.doGet(url, params, timeout);
		List<QuotationDown> resultList = ProtoBufUtil.toProtoBufList(QuotationDown.newBuilder().build(), respJson);
		GetReplyInvalidResp.Builder result = GetReplyInvalidResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}

	/**
	 * 平台的报价信息作废信息传到供应商ERP之后，修改平台里面的作废信息上传状态
	 *
	 * @param req
	 * @return
	 */
	public OnReplyInvalidDownSuccessResp onReplyInvalidDownSuccess(OnReplyInvalidDownSuccessReq req) throws IOException {
		String url = baseUrl + "/erp/sale/inquiry/reply/invalid/back";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>();
		fromData.put("data", req.getIdStr());
		HttpUtil.doPost(url, fromData, timeout);
		return OnReplyInvalidDownSuccessResp.newBuilder().build();
	}

	/**
	 * 通过上传的数据查询询价单在平台是否存在
	 *
	 * @param req
	 * @return
	 */
	public GetInquiryB2bIdResp getInquiryB2bId(GetInquiryB2bIdReq req) throws IOException {
		String url = baseUrl + "/erp/buyer/inquiry";
		Map<String, String> params = generateSignature(url, null);
		url = HttpUtil.getPath(url, params);
		Map<String, String> fromData = new HashMap<>(1);
		fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
		String respJson = HttpUtil.doPost(url, fromData, timeout);
		List<Inquiry> resultList = ProtoBufUtil.toProtoBufList(Inquiry.newBuilder().build(), respJson);
		GetInquiryB2bIdResp.Builder result = GetInquiryB2bIdResp.newBuilder();
		result.addAllData(resultList);
		return result.build();
	}
}
