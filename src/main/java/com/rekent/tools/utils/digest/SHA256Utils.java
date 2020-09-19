package com.rekent.tools.utils.digest;

import java.security.MessageDigest;

import com.rekent.tools.utils.crypt.HexUtils;

public class SHA256Utils {
	private static final String ALGORITHM = "SHA-256";
	private static MessageDigest sha256;

	static {
		try {
			sha256 = MessageDigest.getInstance(ALGORITHM);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static String toSHA256(String arg0) {
		return HexUtils.toHexString(sha256.digest(arg0.getBytes()));
	}

	public static String toSHA256(byte[] arg0) {
		return HexUtils.toHexString(sha256.digest(arg0));

	}
}
