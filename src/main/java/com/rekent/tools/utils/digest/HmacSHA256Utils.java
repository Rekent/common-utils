package com.rekent.tools.utils.digest;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import com.rekent.tools.utils.crypt.HexUtils;

/**
 * MessageDigest Utils : HmacSHA256
 * 
 * @author richard.zhang
 */
public class HmacSHA256Utils {
	private static final String ALGORITHM = "HmacSHA256";
	private static Mac mac;

	static {
		try {
			mac = Mac.getInstance(ALGORITHM);
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * HmacSHA256 digest , source is string
	 * 
	 * @param arg0
	 * @param key
	 * @return
	 * @throws InvalidKeyException
	 */
	public static String toHmacSHA256(String arg0, byte[] key) throws InvalidKeyException {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		mac.init(secretKey);
		return HexUtils.toHexString(mac.doFinal(arg0.getBytes()));
	}

	/**
	 * HmacSHA256 digest , source is byte array
	 * 
	 * @param arg0
	 * @param key
	 * @return
	 * @throws InvalidKeyException
	 */
	public static String toHmacSHA256(byte[] arg0, byte[] key) throws InvalidKeyException {
		SecretKey secretKey = new SecretKeySpec(key, ALGORITHM);
		mac.init(secretKey);
		return HexUtils.toHexString(mac.doFinal(arg0));
	}
}
