package com.usoft.sdk.b2b.client.v2.uas;

import com.usoft.b2b.trade.external.uas.api.entity.CreateOrUpdateProduct;
import com.usoft.b2b.trade.external.uas.api.protobuf.BatchCreateOrUpdateProductReq;
import com.usoft.b2b.trade.external.uas.api.protobuf.BatchCreateOrUpdateProductResp;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

/**
 * @author uas
 * @date 2020/5/28 11:35
 */
public class UasProductSdkTest {
    /**
     * 测试地址
     */
    private UasProductSdk productSdk = new UasProductSdk("https://b2btraderest.uuzcc.cn", "10042875", "c49f7be6a861461ab951e55030055a5c");

    /**
     * 正式地址
     */
//	private RatingSdk ratingSdk = new RatingSdk("http://api-product.usoftchina.com");
	@Test
	public void batchCreateOrUpdateProduct() throws Exception {
        BatchCreateOrUpdateProductReq.Builder req = BatchCreateOrUpdateProductReq.newBuilder();
        CreateOrUpdateProduct.Builder builder = CreateOrUpdateProduct.newBuilder();
        builder.setBrand("22");
        req.addProduct(builder);
        BatchCreateOrUpdateProductResp resp = productSdk.batchCreateOrUpdateProduct(req);
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
