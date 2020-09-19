package com.rekent.tools.utils.digest;

import java.security.MessageDigest;

import com.rekent.tools.utils.crypt.HexUtils;

/**
 * MessageDigest Utils to MD5
 * 
 * @author richard.zhang
 *
 */
public class MD5Utils {
	private static final String ALGORITHM = "MD5";
	private static MessageDigest md5;

	static {
		try {
			md5 = MessageDigest.getInstance(ALGORITHM);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * MD5 digest,source is string
	 * 
	 * @param arg0
	 * @return
	 */
	public static String toMD5(String arg0) {
		return HexUtils.toHexString(md5.digest(arg0.getBytes()));
	}

	/**
	 * MD5 digest,source is byte array
	 * 
	 * @param arg0
	 * @return
	 */
	public static String toMD5(byte[] arg0) {
		return HexUtils.toHexString(md5.digest(arg0));
	}
}
