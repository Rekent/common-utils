package com.rekent.tools.utils.crypt;

/**
 * Utils to hex encode/decode
 * 
 * @author richard.zhang
 *
 */
public class HexUtils {

	/**
	 * byte array to hex string
	 * 
	 * @param arg0
	 * @return
	 */
	public static String toHexString(byte[] arg0) {
		return toHexString(arg0, true);
	}

	/**
	 * byte array to hex string
	 * 
	 * @param arg0
	 * @param toLowerCase
	 * @return
	 */
	public static String toHexString(byte[] arg0, boolean toLowerCase) {
		StringBuilder hexBuilder = new StringBuilder();
		for (byte element : arg0) {
			String hexElement = Integer.toHexString(element & 0xFF);
			// 1 byte = 2 char , high zero
			hexBuilder.append(hexElement.length() == 1 ? "0" : "").append(hexElement);
		}
		if (toLowerCase) {
			return hexBuilder.toString().trim().toLowerCase();
		}
		return hexBuilder.toString().trim().toUpperCase();
	}

	/**
	 * hex string decode to byte[]
	 * 
	 * @param arg0
	 * @return
	 */
	public static byte[] decode(String arg0) {
		int m = 0, n = 0;
		int byteLen = arg0.length() / 2;
		byte[] ret = new byte[byteLen];
		for (int i = 0; i < byteLen; i++) {
			m = i * 2 + 1;
			n = m + 1;
			int intVal = Integer.decode("0x" + arg0.substring(i * 2, m) + arg0.substring(m, n));
			ret[i] = Byte.valueOf((byte) intVal);
		}
		return ret;
	}
}
