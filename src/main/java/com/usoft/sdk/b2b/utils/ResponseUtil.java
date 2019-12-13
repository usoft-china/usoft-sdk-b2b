package com.usoft.sdk.b2b.utils;


/**
 * 响应工具类
 *
 * @author: wangcanyi
 * @date: 2018-07-31 17:57
 */
public class ResponseUtil {

	/**
	 * 验证响应体编码
	 *
	 * @param code
	 * @param msg
	 */
	public static void checkRespHeader(int code, String msg) {
		if (code != 0) {
			throw new RuntimeException(msg);
		}
	}
}
