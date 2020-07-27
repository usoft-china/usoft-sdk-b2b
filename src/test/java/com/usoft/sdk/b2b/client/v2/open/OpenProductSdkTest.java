package com.usoft.sdk.b2b.client.v2.open;

import com.usoft.b2b.trade.external.open.api.entity.CreateOrUpdateProduct;
import com.usoft.b2b.trade.external.open.api.protobuf.*;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class OpenProductSdkTest {
    /**
     * 测试地址
     */
    private OpenProductSdk productSdk = new OpenProductSdk("http://127.0.0.1:27320", "10050624", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//    private OpenProductSdk productSdk = new OpenProductSdk("https://b2btraderest.usoftchina.com", "20002873", "1067591a3adb44a8ab9605790969b30a");
    @Test
    public void createOrUpdateProduct() throws Exception {
        CreateOrUpdateProductReq.Builder req = CreateOrUpdateProductReq.newBuilder();
        CreateOrUpdateProduct.Builder product = CreateOrUpdateProduct.newBuilder();
        product.setCode("PD200721532754541201");
        product.setMaterialCode("Material Code");
        product.setModel("Model2");
        product.setBrand("Brand3");
        product.setName("Name2");
        product.setSpec("Spec2");
        req.setProduct(product.build());
        req.setUu(1000027480);
        CreateOrUpdateProductResp resp = productSdk.createOrUpdateProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void batchCreateOrUpdateProduct() throws Exception {
        BatchCreateOrUpdateProductReq.Builder req = BatchCreateOrUpdateProductReq.newBuilder();
        CreateOrUpdateProduct.Builder builder = CreateOrUpdateProduct.newBuilder();
        builder.setCode("PD200616229890022300");
        builder.setMaterialCode("MaterialCode001");
        builder.setModel("Model1");
        builder.setBrand("Brand1");
        builder.setName("Name1");
        builder.setSpec("Spec1");
        builder.setUnit("");
        builder.setMpq(1);
        builder.setMoq(1);
        builder.setDeliveryTime(5);
        req.addProduct(builder);
        req.setUu(200040196);
        BatchCreateOrUpdateProductResp resp = productSdk.batchCreateOrUpdateProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }

    @Test
    public void getProduct() throws Exception{
        GetProductReq.Builder req = GetProductReq.newBuilder();
//        req.setCode("PD200616229890022300");
        req.setMaterialCode("Material Code");
        GetProductResp resp = productSdk.getProduct(req);
        System.out.println(ProtoBufUtil.toJSON(resp));
    }
}
