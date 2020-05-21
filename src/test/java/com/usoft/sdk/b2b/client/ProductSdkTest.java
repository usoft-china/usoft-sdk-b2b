package com.usoft.sdk.b2b.client;

import com.usoft.b2b.external.erp.product.api.entity.Product;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsReq;
import com.usoft.b2b.external.erp.product.api.protobuf.UpdateProductsResp;
import com.usoft.sdk.b2b.client.ProductSdk;
import com.usoft.sdk.b2b.utils.ProtoBufUtil;
import com.usoft.sdk.b2b.utils.encry.HmacUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

/**
 * @author: wangcanyi
 * @deprecated 废弃，请使用V2版
 * @date: 2019-12-13 14:20
 **/
@Deprecated
public class ProductSdkTest {
	/**
	 * 测试地址
	 */
	private ProductSdk productSdk = new ProductSdk("http://test-product.uuzcc.cn","10050624","c49f7be6a861461ab951e55030055a5c");

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
		builder.setPrCode("PdProdcode");
		builder.setPrDetail("PrDetail");
		builder.setPrEnuu(10050624);
		req.addData(builder);
		UpdateProductsResp resp = productSdk.updateProducts(req.build());
		System.out.println(ProtoBufUtil.toJSON(resp));
	}
}
