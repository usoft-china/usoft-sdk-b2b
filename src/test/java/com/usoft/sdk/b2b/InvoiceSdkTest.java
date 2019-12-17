package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.invoice.api.entity.APBill;
import com.usoft.b2b.external.erp.invoice.api.protobuf.GetSaleAPBillsReq;
import com.usoft.b2b.external.erp.invoice.api.protobuf.GetSaleAPBillsResp;
import com.usoft.b2b.external.erp.invoice.api.protobuf.SaveApBillsReq;
import com.usoft.b2b.external.erp.invoice.api.protobuf.SaveApBillsResp;
import com.usoft.sdk.b2b.client.InvoiceSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author uas
 * @date 2019/12/16 11:43
 */
public class InvoiceSdkTest {

    /**
     * 测试地址
     */
    private InvoiceSdk invoiceSdk = new InvoiceSdk("http://test-b2b.uuzcc.cn", "10041559", "2c1ea089876b796fe050007f01002ea6");

    /**
     * 正式地址
     */
//	private ProductSdk productSdk = new ProductSdk("http://b2b-api.usoftchina.com", "10041559", "2c1ea089876b796fe050007f01002ea6");

    @Test
    public void updateSaleDownStatus() throws IOException {
        SaveApBillsReq.Builder req = SaveApBillsReq.newBuilder();
        APBill.Builder builder = APBill.newBuilder();
        builder.setAbId(123);
        req.addData(builder);
        SaveApBillsResp resp = invoiceSdk.saveApBills(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void updateProducts() throws IOException {
        GetSaleAPBillsReq.Builder req = GetSaleAPBillsReq.newBuilder();
        GetSaleAPBillsResp resp = invoiceSdk.getSaleAPBills(req.build());
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
