package com.usoft.sdk.b2b;

import com.usoft.b2b.external.erp.product.api.entity.Product;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.client.ProductSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 **/
public class ProductSdkTest {
	/**
	 * 测试地址
	 */
	private ProductSdk productSdk = new ProductSdk("https://test-product.uuzcc.cn");

	/**
	 * 正式地址
	 */
//	private ProductSdk productSdk = new ProductSdk("https://api-product.usoftchina.com");
	@Test
	public void updateProducts() throws IOException {
		UpdateProductsReq.Builder req = UpdateProductsReq.newBuilder();
		req.setEnUU(100);
		Product.Builder builder = Product.newBuilder();
		builder.setPrId(1234);
		builder.setB2BId(234);
		req.addData(builder);
		UpdateProductsResp resp = productSdk.updateProducts(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
