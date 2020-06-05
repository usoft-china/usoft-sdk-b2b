package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.protobuf.*;
import com.usoft.sdk.b2b.client.v2.BaseSdk;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.util.Map;

/**
 * 发票sdk
 * @author uas
 * @date 2020/6/5 9:27
 */
public class UasInvoiceSdk extends BaseSdk {
    public UasInvoiceSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public UasInvoiceSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 分页查询买家发票企业
     *
     * @param req
     * @return
     */
    public PagingBuyerInvoiceEntResp pagingBuyerInvoiceEnt(PagingBuyerInvoiceEntReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/invoice/ent/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerInvoiceEntResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerInvoiceEntResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家发票企业详情
     *
     * @param req
     * @return
     */
    public GetBuyerInvoiceEntDetailResp getBuyerInvoiceEntDetail(GetBuyerInvoiceEntDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/invoice/ent/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerInvoiceEntDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerInvoiceEntDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询买家发票单
     *
     * @param req
     * @return
     */
    public PagingBuyerInvoiceResp pagingBuyerInvoice(PagingBuyerInvoiceReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/invoice/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingBuyerInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingBuyerInvoiceResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询买家发票单详情
     *
     * @param req
     * @return
     */
    public GetBuyerInvoiceDetailResp getBuyerInvoiceDetail(GetBuyerInvoiceDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/buyer/invoice/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetBuyerInvoiceDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetBuyerInvoiceDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 开票
     *
     * @param req
     * @return
     */
    public OpenInvoiceResp openInvoice(OpenInvoiceReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/invoice/open";
        String paramJson = genSignToJson(req);
        String respJson = HttpUtil.doPost(url, paramJson, timeout);
        OpenInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(OpenInvoiceResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家发票企业
     *
     * @param req
     * @return
     */
    public PagingSellerInvoiceEntResp pagingSellerInvoiceEnt(PagingSellerInvoiceEntReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/invoice/ent/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerInvoiceEntResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerInvoiceEntResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家发票企业详情
     *
     * @param req
     * @return
     */
    public GetSellerInvoiceEntDetailResp getSellerInvoiceEntDetail(GetSellerInvoiceEntDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/invoice/ent/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerInvoiceEntDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerInvoiceEntDetailResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 分页查询卖家发票单
     *
     * @param req
     * @return
     */
    public PagingSellerInvoiceResp pagingSellerInvoice(PagingSellerInvoiceReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/invoice/paging";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        PagingSellerInvoiceResp.Builder resp = ProtoBufUtil.toProtoBuf(PagingSellerInvoiceResp.newBuilder(), respJson);
        return resp.build();
    }

    /**
     * 查询卖家发票单详情
     *
     * @param req
     * @return
     */
    public GetSellerInvoiceDetailResp getSellerInvoiceDetail(GetSellerInvoiceDetailReq.Builder req) throws Exception {
        String url = baseUrl + "/uas/seller/invoice/detail/get";
        Map<String, String> params = genSignToMap(req);
        String respJson = HttpUtil.doGet(url, params, timeout);
        GetSellerInvoiceDetailResp.Builder resp = ProtoBufUtil.toProtoBuf(GetSellerInvoiceDetailResp.newBuilder(), respJson);
        return resp.build();
    }
}
