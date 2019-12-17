package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.invoice.api.entity.APBill;
import com.usoft.b2b.external.erp.invoice.api.protobuf.GetSaleAPBillsReq;
import com.usoft.b2b.external.erp.invoice.api.protobuf.GetSaleAPBillsResp;
import com.usoft.b2b.external.erp.invoice.api.protobuf.SaveApBillsReq;
import com.usoft.b2b.external.erp.invoice.api.protobuf.SaveApBillsResp;
import com.usoft.b2b.external.erp.order.api.protobuf.UpdateSaleDownStatusResp;
import com.usoft.sdk.b2b.utils.HttpUtil;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import io.grpc.protobuf.ProtoUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author uas
 * @date 2019/12/16 10:57
 */
public class InvoiceSdk extends BaseSdk {


    public InvoiceSdk(String baseUrl, String secretId, String secretKey) {
        super(baseUrl, secretId, secretKey);
    }

    public InvoiceSdk(String baseUrl, String secretId, String secretKey, int timeout) {
        super(baseUrl, secretId, secretKey, timeout);
    }

    /**
     * 买家ERP-将ERP的应付发票写到平台
     *
     * @param req
     * @return
     */
    public SaveApBillsResp saveApBills(SaveApBillsReq req) throws IOException {
        String url = baseUrl + "/erp/purchase/APBill";
        Map<String, String> params = generateSignature(url, null);
        url = HttpUtil.getPath(url, params);
        Map<String, String> fromData = new HashMap<>();
        fromData.put("data", ProtoBufUtil.toJSON(req.getDataList()));
        HttpUtil.doPost(url, fromData, timeout);
        return SaveApBillsResp.newBuilder().build();
    }

    /**
     * 卖家ERP-从平台获取未下载的客户应付票据
     * @param req
     * @return
     * @throws IOException
     */
    public GetSaleAPBillsResp getSaleAPBills(GetSaleAPBillsReq req) throws IOException {
        String url = baseUrl + "/erp/sale/APBill";
        Map<String, String> params = generateSignature(url, null);
        String respJson = HttpUtil.doGet(url, params, timeout);
        List<APBill> list = ProtoBufUtil.toProtoBufList(APBill.newBuilder().build(), respJson);
        GetSaleAPBillsResp.Builder resp = GetSaleAPBillsResp.newBuilder();
        resp.addAllData(list);
        return resp.build();
    }
}
