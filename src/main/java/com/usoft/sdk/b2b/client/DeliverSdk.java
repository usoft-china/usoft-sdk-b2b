package com.usoft.sdk.b2b.client;

import com.alibaba.fastjson.JSONObject;
import com.usoft.b2b.external.erp.deliver.api.entity.AcceptNotify;
import com.usoft.b2b.external.erp.deliver.api.entity.PurchaseNotify;
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
    public SavePurchaseNotifyResp getSaleDownChangeList(SavePurchaseNotifyReq req) throws IOException {
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
    public UpdateAcceptNotifyEndResp updateAcceptNotifyEnd(UpdateAcceptNotifyEndReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/end";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getAcceptNotifyListList()));

        String respJson = HttpUtil.doPost(url, fromData, timeout);
        List<String> list = JSONObject.parseArray(respJson, String.class);
        UpdateAcceptNotifyEndResp.Builder resp = UpdateAcceptNotifyEndResp.newBuilder();
        resp.setIdStr(list.get(0));
        return resp.build();
    }

    /**
     * 每天定时观察校验送货提醒
     *
     * @param req
     * @return
     */
    public CheckAcceptNotifyResp checkAcceptNotify(CheckAcceptNotifyReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/notice/endCheck";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getPurchaseNotifyListList()));
        HttpUtil.doPost(url, fromData, timeout);
        return CheckAcceptNotifyResp.newBuilder().build();
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

}
