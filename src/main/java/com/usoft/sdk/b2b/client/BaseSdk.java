package com.usoft.sdk.b2b.client;

/**
 * 基础SDK
 *
 * @author: wangcanyi
 * @date: 2019-12-12 17:26
 **/
public class BaseSdk {
	/**
	 * 默认超时时间
	 */
	protected static int DEFAULT_TIMEOUT = 60000;

	/**
	 * 域名地址
	 */
	protected String baseUrl = "";
	/**
	 * 超时时间，单位毫秒
	 */
	protected int timeout = DEFAULT_TIMEOUT;

	public BaseSdk(String baseUrl) {
		this(baseUrl, DEFAULT_TIMEOUT);
	}

	public BaseSdk(String baseUrl, int timeout) {
		this.baseUrl = baseUrl;
		this.timeout = timeout;
	}
}
