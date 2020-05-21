package com.usoft.sdk.b2b.client.v2;

/**
 * @author: wangcanyi
 * @date: 2019-12-19 14:28
 **/
public class DemoSdk extends BaseSdk {
	public DemoSdk(String baseUrl, String secretId, String secretKey) {
		super(baseUrl, secretId, secretKey);
	}

	public DemoSdk(String baseUrl, String secretId, String secretKey, int timeout) {
		super(baseUrl, secretId, secretKey, timeout);
	}

//	/**
//	 * KV Get 例子
//	 *
//	 * @param req
//	 * @return
//	 */
//	public GetRatingEntResp getRatingEnt(GetRatingEntReq.Builder req) throws Exception {
//		String url = baseUrl + "/api/open/erm/rating/ent/get";
//		Map<String, String> params = genSignToMap(req);
//		String respJson = HttpUtil.doGet(url, params, timeout);
//		GetRatingEntResp.Builder resp = ProtoBufUtil.toProtoBuf(GetRatingEntResp.newBuilder(), respJson);
//		return resp.build();
//	}

//	/**
//	 * Json Post 例子
//	 *
//	 * @param req
//	 * @return
//	 */
//	public BatchUpdateOrderResp batchUpdateOrder(BatchUpdateOrderReq.Builder req) throws Exception {
//		String url = baseUrl + "/openapi/trade/order/batch/update";
//		String paramJson = genSignToJson(req);
//		String respJson = HttpUtil.doPost(url, paramJson, timeout);
//		BatchUpdateOrderResp.Builder resp = ProtoBufUtil.toProtoBuf(BatchUpdateOrderResp.newBuilder(), respJson);
//		return resp.build();
//	}
}
