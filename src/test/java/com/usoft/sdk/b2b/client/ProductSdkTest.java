package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.product.api.entity.Product;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @date: 2019-12-13 14:20
 * @deprecated 废弃，请使用V2版
 **/
@Deprecated
public class ProductSdkTest {
	/**
	 * 开发地址
	 */
	private ProductSdk productSdk = new ProductSdk("http://127.0.0.1:27120", "10050624", "c49f7be6a861461ab951e55030055a5c");

//	/**
//	 * 测试地址
//	 */
//	private ProductSdk productSdk = new ProductSdk("http://test-product.uuzcc.cn","10050624","c49f7be6a861461ab951e55030055a5c");

	/**
	 * 正式地址
	 */
//	private ProductSdk productSdk = new ProductSdk("http://api-product.usoftchina.com");
	@Test
	public void updateProducts() throws IOException {
		UpdateProductsReq.Builder req = UpdateProductsReq.newBuilder();
		req.setEnUU(10050624);
		Product.Builder builder = Product.newBuilder();
		builder.setPrId(1234);
		builder.setPrCode("PdProdcodeERP");
		builder.setPrDetail("PrDetailERP");
		builder.setPrSpec("PrSpec");
		builder.setPrBrand("PrBrand");
		builder.setPrOrispeccode("PrOrispeccode");
		builder.setPrEnuu(10050624);
		req.addData(builder);
		UpdateProductsResp resp = productSdk.updateProducts(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
