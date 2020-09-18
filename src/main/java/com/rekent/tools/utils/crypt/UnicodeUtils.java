package com.rekent.tools.utils.crypt;

/**
 * Utils to Unicode encode/decode
 * 
 * @author richard.zhang
 *
 */
public class UnicodeUtils {

	/**
	 * encode normal string 2 unicode string
	 * 
	 * @param arg0
	 * @return
	 */
	public static String encode(String arg0) {
		StringBuilder unicode = new StringBuilder();
		for (char element : arg0.toCharArray()) {
			unicode.append("\\u").append(Integer.toHexString(element));
		}
		return unicode.toString();
	}

	/**
	 * decode unicode string 2 normal string
	 * 
	 * @param arg0
	 * @return
	 */
	public static String decode(String arg0) {
		StringBuilder normalBuilder = new StringBuilder();
		String[] pureHexs = arg0.split("\\\\u");
		for (String element : pureHexs) {
			int charInteger = Integer.parseUnsignedInt(element, 16);
			normalBuilder.append((char) charInteger);
		}
		return normalBuilder.toString();
	}
}
