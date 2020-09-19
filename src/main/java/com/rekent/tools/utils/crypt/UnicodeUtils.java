package com.rekent.tools.utils.crypt;

import java.util.Arrays;

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
	public static String toUnicode(String arg0) {
		StringBuilder unicode = new StringBuilder();
		for (char element : arg0.toCharArray()) {
			String hex = Integer.toHexString(element);
			while (hex.length()<4) {
				hex = "0" + hex;
			}
			unicode.append("\\u").append(hex);
		}
		return unicode.toString();
	}

	/**
	 * decode unicode string 2 normal string
	 * 
	 * @param arg0
	 * @return
	 */
	public static String toPlainText(String arg0) {
		StringBuilder normalBuilder = new StringBuilder();
		String[] pureHexs = arg0.split("\\\\u");
		pureHexs = Arrays.copyOfRange(pureHexs, 1, pureHexs.length);
		for (String element : pureHexs) {
			int charInteger = Integer.parseUnsignedInt(element, 16);
			normalBuilder.append((char) charInteger);
		}
		return normalBuilder.toString();
	}
}
