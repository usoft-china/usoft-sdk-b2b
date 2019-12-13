package com.usoft.sdk.b2b.utils;

import com.google.protobuf.Descriptors;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import org.apache.commons.collections4.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * ProtoBuf 工具类
 *
 * @author wangcanyi
 * @date 2018-07-31 17:57
 */
public class ProtoBufUtil {
	private static final Logger LOGGER = LoggerFactory.getLogger(ProtoBufUtil.class);
	/**
	 * ProtoBuf to Json Format
	 */
	private static final JsonFormat.Printer JSON_FORMAT_PRINTER = JsonFormat.printer().includingDefaultValueFields();
	/**
	 * Parser Json To ProtoBuf
	 */
	private static final JsonFormat.Parser JSON_FORMAT_PARSER = JsonFormat.parser().ignoringUnknownFields();

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
		Map<String, String> result = new HashMap<>(fieldMap.size());
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
