package com.usoft.sdk.b2b.client;

/**
 * @author: wangcanyi
 * @date: 2019-12-12 18:06
 **/
public class ClientSdk extends BaseSdk {

	private ProductSdk productSdk;

	public ClientSdk(String baseUrl) {
		this(baseUrl, BaseSdk.DEFAULT_TIMEOUT);
	}

	public ClientSdk(String baseUrl, int timeout) {
		super(baseUrl, timeout);
		productSdk = new ProductSdk(baseUrl, timeout);
	}

	/**
	 * 产品 SDK
	 *
	 * @return
	 */
	public ProductSdk getProductSdk() {
		return productSdk;
	}
}
