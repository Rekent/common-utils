package com.rekent.tools.utils.crypto;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;

import com.rekent.tools.utils.crypt.HexUtils;

/**
 * 
 * Utils to AES Encrypt/Decrypt
 * 
 * @author richard.zhang
 *
 */
public class AESUtils {
	private static final String ALGORITHM = "AES";
	private static Cipher cipher;

	/**
	 * aes encrypt
	 * return hex
	 * 
	 * @param arg0
	 * @param mode
	 * @param padding
	 * @param key
	 * @return
	 * @throws GeneralSecurityException
	 */
	public static String encrypt(String arg0, String mode, String padding, String key) throws GeneralSecurityException {
		byte[] encodeBytes = null;
		try {
			String algorithm = ALGORITHM.concat("/").concat(mode).concat("/").concat(padding);
			cipher = Cipher.getInstance(algorithm);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			cipher.init(Cipher.ENCRYPT_MODE, getSecretKey(key));
			encodeBytes = cipher.doFinal(arg0.getBytes());
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			throw e;
		}
		return HexUtils.toHexString(encodeBytes);
	}

	/**
	 * aes decrypt auto hex decode arg0
	 * 
	 * @param arg0
	 * @param mode
	 * @param padding
	 * @param key
	 * @return
	 * @throws GeneralSecurityException
	 */
	public static String decrypt(String arg0, String mode, String padding, String key) throws GeneralSecurityException {
		byte[] encodeBytes = null;
		try {
			String algorithm = ALGORITHM.concat("/").concat(mode).concat("/").concat(padding);
			cipher = Cipher.getInstance(algorithm);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		try {
			cipher.init(Cipher.DECRYPT_MODE, getSecretKey(key));
			encodeBytes = cipher.doFinal(HexUtils.toPlainText(arg0));
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
			throw e;
		}
		return new String(encodeBytes);
	}

	protected static SecretKeySpec getSecretKey(String key) {
		SecretKeySpec secretKeySpec = new SecretKeySpec(key.getBytes(), ALGORITHM);
		return secretKeySpec;
	}
}
