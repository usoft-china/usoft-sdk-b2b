package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.ent.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class OpenCustomerSdkTest {
    /**
     * 测试地址
     */
    private OpenCustomerSdk openCustomerSdk = new OpenCustomerSdk("https://b2bentrest.uuzcc.cn", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//    private OpenProductSdk productSdk = new OpenProductSdk("https://b2bentrest.usoftchina.com", "20002873", "1067591a3adb44a8ab9605790969b30a");

    @Test
    public void buyerPageSupplierList() throws Exception{
        BuyerPageSupplierListReq.Builder req = BuyerPageSupplierListReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        BuyerPageSupplierListResp resp = openCustomerSdk.buyerPageSupplierList(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void buyerPageAllSupplier() throws Exception{
        BuyerPageAllSupplierReq.Builder req = BuyerPageAllSupplierReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        BuyerPageAllSupplierResp resp = openCustomerSdk.buyerPageAllSupplier(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void addSupplier() throws Exception{
        AddSupplierReq.Builder req = AddSupplierReq.newBuilder();
        req.setEnuu(10);
        AddSupplierResp resp = openCustomerSdk.addSupplier(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getContactList() throws Exception {
        GetContactListReq.Builder req = GetContactListReq.newBuilder();
        req.setEnuu(50000089);
        GetContactListResp resp = openCustomerSdk.getContactList(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void sellerPageCustomerList() throws Exception {
        SellerPageCustomerListReq.Builder req = SellerPageCustomerListReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        SellerPageCustomerListResp resp = openCustomerSdk.sellerPageCustomerList(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerCustomer() throws Exception {
        GetSellerCustomerReq.Builder req = GetSellerCustomerReq.newBuilder();
        req.setEnuu(10050624);
        GetSellerCustomerResp resp = openCustomerSdk.getSellerCustomer(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void pagingSellerPerfAssess() throws Exception {
        PagingSellerPerfAssessReq.Builder req = PagingSellerPerfAssessReq.newBuilder();
        req.setPageSize(10);
        req.setPageNumber(1);
        PagingSellerPerfAssessResp resp = openCustomerSdk.pagingSellerPerfAssess(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getSellerPerfAssess() throws Exception {
        GetSellerPerfAssessReq.Builder req = GetSellerPerfAssessReq.newBuilder();
        req.setCode("PE20215889798");
        GetSellerPerfAssessResp resp = openCustomerSdk.getSellerPerfAssess(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
