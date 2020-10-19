package com.rekent.tools.utils.json;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * 
 * Utils : serialize/deserialize object to json
 * 
 * based on {@link ObjectMapper}
 * 
 * @author richard.zhang
 *
 */
public class JsonUtils {

	private static ObjectMapper objectMapper;

	static {
		objectMapper = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker().withFieldVisibility(Visibility.ANY)
				.withGetterVisibility(Visibility.NONE));
		SimpleModule module = new SimpleModule();
		// json convert : long to string
		module.addSerializer(Long.class, new ToStringSerializer());
		// json convert : date -> yyyy-MM-dd HH:mm:ss
		module.addSerializer(Date.class, new DateSerializer(false, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")));
		module.addDeserializer(Date.class,
				new DateDeserializer(new DateDeserializer(), new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), "yyyy-MM-dd HH:mm:ss"));
		objectMapper.registerModule(module);
	}

	/**
	 * Convert object to json string
	 * 
	 * @param object
	 * @return
	 * @throws JsonProcessingException
	 */
	public static String serializeObject(Object object) throws IOException {
		return objectMapper.writeValueAsString(object);
	}

	/**
	 * Convert json string to object
	 * 
	 * @param <T>
	 * @param text
	 * @param clazz
	 * @return
	 * @throws IOException
	 */
	public static <T> T deserializeObject(String text, Class<? extends T> clazz) throws IOException {
		return objectMapper.readValue(text, clazz);
	}

	/**
	 * Convert json string to Collection
	 * 
	 * @param <T>
	 * @param text
	 * @param typeReference
	 * @return
	 * @throws IOException
	 */
	public static <T> T deserializeArray(String text, TypeReference<T> typeReference) throws IOException {
		return objectMapper.readValue(text, typeReference);
	}
}
