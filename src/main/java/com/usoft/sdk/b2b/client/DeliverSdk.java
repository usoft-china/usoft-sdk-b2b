package com.usoft.sdk.b2b.client;

import com.alibaba.fastjson.JSONObject;
import com.usoft.b2b.external.erp.deliver.api.entity.*;
import com.usoft.b2b.external.erp.deliver.api.protobuf.*;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uas
 * @date 2019/12/16 15:46
 */
public class DeliverSdk extends BaseSdk{

    public DeliverSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public DeliverSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 将ERP的送货提醒写到平台
     *
     * @param req
     * @return
     */
    public SavePurchaseNotifyResp savePurchaseNotify(SavePurchaseNotifyReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));
        String respJson = HttpUtil.doPost(url, fromData, timeout);
        List<PurchaseNotify> list = ProtoBufUtil.toProtoBufList(PurchaseNotify.newBuilder().build(), respJson);
        SavePurchaseNotifyResp.Builder resp = SavePurchaseNotifyResp.newBuilder();
        resp.addAllPurchaseNotifyList(list);
        return resp.build();
    }

    /**
     * 从买家ERP获取平台的发货单
     * @param req
     * @return
     * @throws IOException
     */
    public GetAcceptNotifyListResp getAcceptNotifyList(GetAcceptNotifyListReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/accept";
        Map<String, String> params = generateSignature(url, null);
        String respJson = HttpUtil.doGet(url, params, timeout);
        List<AcceptNotify> list = ProtoBufUtil.toProtoBufList(AcceptNotify.newBuilder().build(), respJson);
        GetAcceptNotifyListResp.Builder resp = GetAcceptNotifyListResp.newBuilder();
        resp.addAllAcceptNotifyList(list);
        return resp.build();
    }

    /**
     * 从买家ERP获取平台的发货单
     *
     * @param req
     * @return
     */
    public UpdateAcceptNotifyStatusResp updateAcceptNotifyStatus(UpdateAcceptNotifyStatusReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/accept/back";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", req.getIdstr());
        HttpUtil.doPost(url, fromData, timeout);
        return UpdateAcceptNotifyStatusResp.newBuilder().build();
    }

    /**
     * 买家ERP主动收料的记录上传到平台
     *
     * @param req
     * @return
     */
    public SaveAcceptNotifyListResp saveAcceptNotify(SaveAcceptNotifyListReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/accept";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getAcceptNotifyListList()));

        String respJson = HttpUtil.doPost(url, fromData, timeout);
        List<AcceptNotify> list = ProtoBufUtil.toProtoBufList(AcceptNotify.newBuilder().build(), respJson);
        SaveAcceptNotifyListResp.Builder resp = SaveAcceptNotifyListResp.newBuilder();
        resp.addAllAcceptNotifyList(list);
        return resp.build();
    }

    /**
     * 买家结案送货提醒后，传到平台
     *
     * @param req
     * @return
     */
    public UpdatePurchaseNotifyEndResp updatePurchaseNotifyEnd(UpdatePurchaseNotifyEndReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/end";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));

        String respJson = HttpUtil.doPost(url, fromData, timeout);
        List<String> list = JSONObject.parseArray(respJson, String.class);
        UpdatePurchaseNotifyEndResp.Builder resp = UpdatePurchaseNotifyEndResp.newBuilder();
        resp.setIdStr(list.get(0));
        return resp.build();
    }

    /**
     * 每天定时观察校验送货提醒
     *
     * @param req
     * @return
     */
    public CheckPurchaseNotifyResp checkPurchaseNotify(CheckPurchaseNotifyReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/endCheck";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));
        HttpUtil.doPost(url, fromData, timeout);
        return CheckPurchaseNotifyResp.newBuilder().build();
    }

    /**
     * 买家修改收料通知的数量后，写回到平台（UAS点全部拒收）
     *
     * @param req
     * @return
     */
    public SaveAcceptNotifyConfirmListResp saveAcceptNotifyConfirm(SaveAcceptNotifyConfirmListReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/accept/confirm";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getAcceptNotifyConfirmListList()));
        HttpUtil.doPost(url, fromData, timeout);
        return SaveAcceptNotifyConfirmListResp.newBuilder().build();
    }

    /**
     * 买家收料通知转收料单的数量，写回到平台
     *
     * @param req
     * @return
     */
    public SaveAcceptNotifyVerifyListResp saveAcceptNotifyVerify(SaveAcceptNotifyVerifyListReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/accept/verify";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getVerifyListList()));
        HttpUtil.doPost(url, fromData, timeout);
        return SaveAcceptNotifyVerifyListResp.newBuilder().build();
    }

    /**
     * 买家反审核收料单的数量，写回到平台
     *
     * @param req
     * @return
     */
    public SaveUnAcceptNotifyVerifyListResp saveUnAcceptNotifyVerify(SaveUnAcceptNotifyVerifyListReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/accept/unverify";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getVerifyListList()));
        HttpUtil.doPost(url, fromData, timeout);
        return SaveUnAcceptNotifyVerifyListResp.newBuilder().build();
    }


    /**
     * 将ERP的采购验收单写到平台
     *
     * @param req
     * @return
     */
    public SavePurchaseProdInOutResp savePurchaseProdInOut(SavePurchaseProdInOutReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/prodInOut";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));

        String respJson = HttpUtil.doPost(url, fromData, timeout);
        List<PurchaseProdInOut> list = ProtoBufUtil.toProtoBufList(PurchaseProdInOut.newBuilder().build(), respJson);
        SavePurchaseProdInOutResp.Builder resp = SavePurchaseProdInOutResp.newBuilder();
        resp.addAllData(list);
        return resp.build();
    }

    /**
     * 将ERP的反过账的采购验收单写到平台
     *
     * @param req
     * @return
     */
    public NonPostingProdInOutResp nonPostingProdInOut(NonPostingProdInOutReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/prodInOut/nonPosting";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
        HttpUtil.doPost(url, fromData, timeout);
        return NonPostingProdInOutResp.newBuilder().build();
    }

    /**
     * 将ERP的采购验退单写到平台
     *
     * @param req
     * @return
     */
    public SavePurchaseProdReturnResp savePurchaseProdReturn(SavePurchaseProdReturnReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/prodReturn";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));

        String respJson = HttpUtil.doPost(url, fromData, timeout);
        List<PurchaseProdInOut> list = ProtoBufUtil.toProtoBufList(PurchaseProdInOut.newBuilder().build(), respJson);
        SavePurchaseProdReturnResp.Builder resp = SavePurchaseProdReturnResp.newBuilder();
        resp.addAllData(list);
        return resp.build();
    }

    /**
     * 将ERP的反过账的采购验退单写到平台
     *
     * @param req
     * @return
     */
    public NonPostingProdReturnResp nonPostingProdReturn(NonPostingProdReturnReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/prodReturn/nonPosting";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
        HttpUtil.doPost(url, fromData, timeout);
        return NonPostingProdReturnResp.newBuilder().build();
    }


    /**
     * 卖家ERP从平台获取客户送货提醒
     * @param req
     * @return
     * @throws IOException
     */
    public GetSaleNotifyDownListResp getSaleNotifyDownList(GetSaleNotifyDownListReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice";
        Map<String, String> params = generateSignature(url, null);
        String respJson = HttpUtil.doGet(url, params, timeout);
        List<SaleNotifyDown> list = ProtoBufUtil.toProtoBufList(SaleNotifyDown.newBuilder().build(), respJson);
        GetSaleNotifyDownListResp.Builder resp = GetSaleNotifyDownListResp.newBuilder();
        resp.addAllSaleNotifyDownList(list);
        return resp.build();
    }

    /**
     * 卖家ERP从平台获取客户送货提醒
     *
     * @param req
     * @return
     */
    public UpdateSaleNotifyDownStatusResp updateSaleNotifyDownStatus(UpdateSaleNotifyDownStatusReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", req.getIdStr());
        HttpUtil.doPost(url, fromData, timeout);
        return UpdateSaleNotifyDownStatusResp.newBuilder().build();
    }

    /**
     * 卖家ERP从平台获取客户送货提醒
     *
     * @param req
     * @return
     */
    public SaveSaleOutListResp saveSaleOutList(SaveSaleOutListReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice/send";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getSaleOutListList()));
        HttpUtil.doPost(url, fromData, timeout);
        return SaveSaleOutListResp.newBuilder().build();
    }

    /**
     * 卖家ERP从平台获取在平台维护的发货单
     * @param req
     * @return
     * @throws IOException
     */
    public GetSaleOutListResp getSaleOutList(GetSaleOutListReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice/send";
        Map<String, String> params = generateSignature(url, null);
        String respJson = HttpUtil.doGet(url, params, timeout);
        List<SaleOut> list = ProtoBufUtil.toProtoBufList(SaleOut.newBuilder().build(), respJson);
        GetSaleOutListResp.Builder resp = GetSaleOutListResp.newBuilder();
        resp.addAllSaleOutList(list);
        return resp.build();
    }

    /**
     * 平台的发货单传到供应商ERP之后，修改平台里面的发货单的上传状态
     *
     * @param req
     * @return
     */
    public UpdateSaleOutStatusResp updateSaleOutStatus(UpdateSaleOutStatusReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice/send/back";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", req.getIdStr());
        HttpUtil.doPost(url, fromData, timeout);
        return UpdateSaleOutStatusResp.newBuilder().build();
    }

    /**
     * 卖家ERP从平台获取在平台维护的发货单
     * @param req
     * @return
     * @throws IOException
     */
    public UpdateSaleNotifyDownEndResp updateSaleNotifyDownEnd(UpdateSaleNotifyDownEndReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice/end";
        Map<String, String> params = generateSignature(url, null);
        String respJson = HttpUtil.doGet(url, params, timeout);
        List<SaleNotifyDownEnd> list = ProtoBufUtil.toProtoBufList(SaleNotifyDownEnd.newBuilder().build(), respJson);
        UpdateSaleNotifyDownEndResp.Builder resp = UpdateSaleNotifyDownEndResp.newBuilder();
        resp.addAllEndList(list);
        return resp.build();
    }

    /**
     * 平台的结案、反结案客户送货提醒单传到供应商ERP之后，修改平台里面的上传状态
     *
     * @param req
     * @return
     */
    public UpdateSaleNotifyDownEndStatusResp updateSaleNotifyDownEndStatus(UpdateSaleNotifyDownEndStatusReq req) throws IOException {
        String url = baseUrl + "/erp/sale/notice/send/back";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", req.getIdStr());
        HttpUtil.doPost(url, fromData, timeout);
        return UpdateSaleNotifyDownEndStatusResp.newBuilder().build();
    }
}
