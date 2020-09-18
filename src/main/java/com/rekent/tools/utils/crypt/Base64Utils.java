package com.rekent.tools.utils.crypt;

import java.io.UnsupportedEncodingException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

/**
 * Utils to Base64 encode/decode
 * 
 * @author richard.zhang
 *
 */
public class Base64Utils {
	private static final String DEFAULT_CHARSET = "UTF-8";

	/**
	 * normal string base64 encode
	 * 
	 * @param arg0
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String encode(String arg0) {
		Encoder encoder = Base64.getEncoder();
		try {
			return encoder.encodeToString(arg0.getBytes(DEFAULT_CHARSET));
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * base64 string decode
	 * 
	 * @param arg0
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String decode(String arg0) {
		Decoder decoder = Base64.getDecoder();
		byte[] decode = decoder.decode(arg0);
		try {
			return new String(decode, DEFAULT_CHARSET);
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * normal string base64 url safety encode
	 * 
	 * @param arg0
	 * @return
	 */
	public static String urlEncode(String arg0) {
		Encoder encoder = Base64.getUrlEncoder();
		try {
			return encoder.encodeToString(arg0.getBytes(DEFAULT_CHARSET));
		} catch (Exception e) {
		}
		return "";
	}

	/**
	 * base64 string url safety decode
	 * 
	 * @param arg0
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	public static String urlDecode(String arg0) {
		Decoder decoder = Base64.getUrlDecoder();
		byte[] decode = decoder.decode(arg0);
		try {
			return new String(decode, DEFAULT_CHARSET);
		} catch (Exception e) {
		}
		return "";
	}
}
