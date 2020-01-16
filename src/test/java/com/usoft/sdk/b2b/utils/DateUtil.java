package com.usoft.sdk.b2b.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 日期工具类
 *
 * @author: wangcanyi
 */
public class DateUtil {

	public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
	public static final String PATTERN_DATE = "yyyy-MM-dd";
	public static final String PATTERN_SIMPLE_DATE = "yyyyMMdd";
	public static final String PATTERN_SIMPLE_DATE_TIME = "yyyyMMdd HHmmss";

	private DateUtil() {
	}

	/***
	 * 获取当前日期
	 * @param pattern 格式：yyyyMMdd etc.
	 * @return
	 */
	public static String getCurrentDate(String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		return df.format(new Date());
	}
}
