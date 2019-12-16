package com.usoft.sdk.b2b;

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
 * @date: 2019-12-13 14:20
 **/
public class ProductSdkTest {
	/**
	 * 测试地址
	 */
	private ProductSdk productSdk = new ProductSdk("https://test-product.uuzcc.cn","10041559","2c1ea089876b796fe050007f01002ea6");

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
	@Test
	public void test(){
		System.out.println(HmacUtils.encode("http://local.uuzcc.cn:8090/platform-b2b/erp/sale?access_id=10041559","2c1ea089876b796fe050007f01002ea6" ));
	}
}
