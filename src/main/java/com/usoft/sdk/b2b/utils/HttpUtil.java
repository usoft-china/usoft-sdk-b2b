package com.usoft.sdk.b2b.utils;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Http调用请求
 *
 * @author wangcanyi
 */
public class HttpUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtil.class);
	protected static CloseableHttpClient httpClient = HttpClients.createDefault();

	/**
	 * 发起GET请求
	 *
	 * @param url
	 * @param params
	 * @param timeout 超时时间，单位毫秒
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url, Map<String, String> params, int timeout) throws IOException {
		String path = url;
		if (StringUtils.isNotBlank(url) && MapUtils.isNotEmpty(params)) {
			StringBuilder sb = new StringBuilder(url);
			sb.append("?");
			for (Map.Entry<String, String> kv : params.entrySet()) {
				sb.append(kv.getKey()).append("=").append(kv.getValue()).append("&");
			}
			path = sb.toString().substring(0, sb.toString().length() - 1);
		}
		return doGet(path, timeout);
	}

	/***
	 * 发起GET请求
	 * @param url
	 * @param timeout 超时时间，单位毫秒
	 * @return
	 * @throws IOException
	 */
	public static String doGet(String url, int timeout) throws IOException {
		if (StringUtils.isBlank(url)) {
			throw new RuntimeException("url不能为空");
		}
		String result = "";
		HttpGet httpGet = new HttpGet(url);
		//setConnectTimeout ：设置连接超时时间，单位毫秒。
		// setConnectionRequestTimeout ：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		// setSocketTimeout ：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).build();
		httpGet.setConfig(requestConfig);
		CloseableHttpResponse response = httpClient.execute(httpGet);
		if (response.getStatusLine().getStatusCode() != 200) {
			response.close();
			throw new RuntimeException("HTTP ERROR " + response.getStatusLine().getStatusCode());
		} else {
			result = EntityUtils.toString(response.getEntity(), "UTF-8");
			response.close();
			LOGGER.info("发起GET请求[HttpUtil.doGet]正常，参数：{}", url);
		}
		return result;
	}

	/**
	 * 发起POST请求
	 *
	 * @param url
	 * @param map
	 * @param timeout
	 * @return
	 * @throws IOException
	 */
	public static String doPost(String url, Map<String, String> map, int timeout) throws IOException {
		if (StringUtils.isBlank(url)) {
			throw new RuntimeException("url不能为空");
		}
		HttpPost httpPost = new HttpPost(url);
		if (MapUtils.isNotEmpty(map)) {
			List<NameValuePair> nvList = new ArrayList<NameValuePair>(map.size());
			for (Map.Entry<String, String> kv : map.entrySet()) {
				BasicNameValuePair basicNameValuePair = new BasicNameValuePair(kv.getKey(), kv.getValue());
				nvList.add(basicNameValuePair);
			}
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(nvList);
			entity.setContentEncoding("UTF-8");
			httpPost.setEntity(entity);
		}
		String result = doPost(url, httpPost, timeout);
		LOGGER.info("发起POST请求[HttpUtil.doPost]正常，参数：{}", url + JSON.toJSONString(map));
		return result;
	}

	/**
	 * 发起POST请求
	 *
	 * @param url
	 * @param json
	 * @param timeout 超时时间，单位毫秒
	 * @return
	 */
	public static String doPost(String url, String json, int timeout) throws IOException {
		if (StringUtils.isBlank(url)) {
			throw new RuntimeException("url不能为空");
		}
		HttpPost httpPost = new HttpPost(url);
		StringEntity stringEntity = new StringEntity(json, ContentType.APPLICATION_JSON);
		stringEntity.setContentEncoding("UTF-8");
		httpPost.setEntity(stringEntity);
		String result = doPost(url, httpPost, timeout);
		LOGGER.info("发起POST请求[HttpUtil.doPost]正常，参数：{}", url + json);
		return result;
	}

	/**
	 * 发起POST请求
	 *
	 * @param url
	 * @param httpPost
	 * @param timeout
	 * @return
	 * @throws IOException
	 */
	private static String doPost(String url, HttpPost httpPost, int timeout) throws IOException {
		String result = "";
		//setConnectTimeout ：设置连接超时时间，单位毫秒。
		// setConnectionRequestTimeout ：设置从connect Manager获取Connection 超时时间，单位毫秒。这个属性是新加的属性，因为目前版本是可以共享连接池的。
		// setSocketTimeout ：请求获取数据的超时时间，单位毫秒。 如果访问一个接口，多少时间内无法返回数据，就直接放弃此次调用
		RequestConfig requestConfig = RequestConfig.custom()
				.setConnectTimeout(timeout)
				.setConnectionRequestTimeout(timeout)
				.setSocketTimeout(timeout).build();
		httpPost.setConfig(requestConfig);
		CloseableHttpResponse response = httpClient.execute(httpPost);
		if (response.getStatusLine().getStatusCode() != 200) {
			response.close();
			throw new RuntimeException("HTTP ERROR " + response.getStatusLine().getStatusCode());
		} else {
			result = EntityUtils.toString(response.getEntity(), "UTF-8");
			response.close();
		}
		return result;
	}
}
