package com.usoft.sdk.b2b.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * ProtoBuf 工具类
 *
 * @author wangcanyi
 * @date 2018-07-31 17:57
 */
public class ProtoBufUtil {
	/**
	 * ProtoBuf to Json Format
	 */
	private static final MyJsonFormat.Printer JSON_FORMAT_PRINTER = MyJsonFormat.printer().preservingProtoFieldNames().includingDefaultValueFields().omittingInsignificantWhitespace();
	/**
	 * Parser Json To ProtoBuf
	 */
	private static final JsonFormat.Parser JSON_FORMAT_PARSER = JsonFormat.parser().ignoringUnknownFields();

	/**
	 * Json列表字符串 转 ProtoBuf实体列表
	 *
	 * @param message        目标ProtoBuf实体
	 * @param jsonSourceList Json字符串
	 * @param <T>
	 * @return
	 * @throws InvalidProtocolBufferException
	 */
	public static <T extends Message> List<T> toProtoBufList(T message, String jsonSourceList) throws InvalidProtocolBufferException {
		if (StringUtils.isBlank(jsonSourceList)) {
			return new ArrayList<>(0);
		}
		JSONArray jsonArray = JSON.parseArray(jsonSourceList);
		List<T> messageList = new ArrayList<>(jsonArray.size());
		for (int i = 0; i < jsonArray.size(); i++) {
			Object object = jsonArray.get(i);
			T.Builder builder = message.toBuilder();
			builder = toProtoBuf(builder, object.toString());
			messageList.add((T) builder.build());
		}
		return messageList;
	}

	/**
	 * Json字符串 转 ProtoBuf实体
	 *
	 * @param builder    目标ProtoBuf实体
	 * @param jsonSource Json字符串
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public static <T extends Message.Builder> T toProtoBuf(T builder, String jsonSource) throws InvalidProtocolBufferException {
		JSON_FORMAT_PARSER.merge(jsonSource, builder);
		return builder;
	}

	/**
	 * ProtoBuf列表 转 Json字符串
	 *
	 * @param messageList ProtoBuf实体列表
	 * @return
	 * @throws InvalidProtocolBufferException
	 */
	public static String toJSON(List<? extends MessageOrBuilder> messageList) throws InvalidProtocolBufferException {
		if (messageList == null) {
			return "";
		}
		if (messageList.size() == 0) {
			return JSON.toJSONString(new ArrayList<>(0));
		}
		List<JSONObject> jsonObjectList = new ArrayList<>(messageList.size());
		for (MessageOrBuilder message : messageList) {
			String msgJson = toJSON(message);
			JSONObject jsonObject = JSON.parseObject(msgJson);
			jsonObjectList.add(jsonObject);
		}
		return JSON.toJSONString(jsonObjectList);
	}

	/**
	 * ProtoBuf实体 转 Json字符串
	 *
	 * @param message ProtoBuf实体
	 * @return Json字符串
	 * @throws InvalidProtocolBufferException
	 */
	public static String toJSON(MessageOrBuilder message) throws InvalidProtocolBufferException {
		return JSON_FORMAT_PRINTER.print(message);
	}

	/**
	 * ProtoBuf实体 转 Map（只转第一层字段）
	 *
	 * @param message
	 * @return
	 */
	public static Map<String, String> toMap(MessageOrBuilder message) {
		Map<Descriptors.FieldDescriptor, Object> fieldMap = message.getAllFields();
		if (MapUtils.isEmpty(fieldMap)) {
			return new HashMap<>(0);
		}
		Map<String, String> result = new LinkedHashMap<>(fieldMap.size());
		for (Map.Entry<Descriptors.FieldDescriptor, Object> kv : fieldMap.entrySet()) {
			Descriptors.FieldDescriptor.JavaType javaType = kv.getKey().getJavaType();
			//如果为二进制数组，枚举，实体，则跳过
			if (javaType == Descriptors.FieldDescriptor.JavaType.BYTE_STRING ||
					javaType == Descriptors.FieldDescriptor.JavaType.ENUM ||
					javaType == Descriptors.FieldDescriptor.JavaType.MESSAGE) {
				continue;
			}
			result.put(kv.getKey().getName(), kv.getValue().toString());
		}
		return result;
	}
}
