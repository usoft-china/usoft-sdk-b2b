package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.ent.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 样品sdk
 * @author open
 * @date 2020/5/27 16:32
 */
public class OpenCustomerSdk extends BaseSdk {
    public OpenCustomerSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public OpenCustomerSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

	/**
	 * 买家分页查询供应商列表
	 *
	 * @param req
	 * @return
	 */
	public BuyerPageSupplierListResp buyerPageSupplierList(BuyerPageSupplierListReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/buyer/page";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		BuyerPageSupplierListResp.Builder resp = ProtoBufUtil.toProtoBuf(BuyerPageSupplierListResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 买家分页查询所有供应商
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public BuyerPageAllSupplierResp buyerPageAllSupplier(BuyerPageAllSupplierReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/buyer/getAll";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		BuyerPageAllSupplierResp.Builder resp = ProtoBufUtil.toProtoBuf(BuyerPageAllSupplierResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 买家添加供应商
	 *
	 * @param req
	 * @return
	 */
	public AddSupplierResp addSupplier(AddSupplierReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/buyer/add";
		String paramJson = genSignToJson(req);
		String respJson = HttpUtil.doPost(url, paramJson, timeout);
		AddSupplierResp.Builder resp = ProtoBufUtil.toProtoBuf(AddSupplierResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 查询供应商下联系人
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetContactListResp getContactList(GetContactListReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/contact/list";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetContactListResp.Builder resp = ProtoBufUtil.toProtoBuf(GetContactListResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家分页查询客户列表
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public SellerPageCustomerListResp sellerPageCustomerList(SellerPageCustomerListReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/seller/page";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		SellerPageCustomerListResp.Builder resp = ProtoBufUtil.toProtoBuf(SellerPageCustomerListResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家查询客户详情
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetSellerCustomerResp getSellerCustomer(GetSellerCustomerReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/seller/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSellerCustomerResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerCustomerResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家分页查询绩效考核
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public PagingSellerPerfAssessResp pagingSellerPerfAssess(PagingSellerPerfAssessReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/seller/perfassess/paging";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		PagingSellerPerfAssessResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerPerfAssessResp.newBuilder(), respJson);
		return resp.build();
	}

	/**
	 * 卖家查询绩效考核详情
	 *
	 * @param req
	 * @return
	 * @throws Exception
	 */
	public GetSellerPerfAssessResp getSellerPerfAssess(GetSellerPerfAssessReq.Builder req) throws Exception {
		String url = baseUrl + "/open/customer/seller/perfassess/get";
		Map<String, String> params = genSignToMap(req);
		String respJson = HttpUtil.doGet(url, params, timeout);
		GetSellerPerfAssessResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerPerfAssessResp.newBuilder(), respJson);
		return resp.build();
	}
}
