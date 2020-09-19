package com.rekent.tools.utils.crypto;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;

/**
 * Utils for RAS Decrypt/Encrypt
 * 
 * @author richard.zhang
 *
 */
public class RSAUtils {
	private static final String ALGORITHM = "RSA";
	private static Cipher cipher;

	static {
		try {
			cipher = Cipher.getInstance(ALGORITHM);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public static byte[] decryptByPrivateKey(byte[] arg0, byte[] privateKey)
			throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(privateKey);
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey key = factory.generatePrivate(x509KeySpec);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(arg0);
	}

	public static byte[] decryptByPublicKey(byte[] arg0, byte[] publicKey)
			throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PublicKey key = factory.generatePublic(x509KeySpec);
		cipher.init(Cipher.DECRYPT_MODE, key);
		return cipher.doFinal(arg0);
	}

	public static byte[] encryptByPrivateKey(byte[] arg0, byte[] privateKey)
			throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(privateKey);
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PrivateKey key = factory.generatePrivate(x509KeySpec);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(arg0);
	}

	public static byte[] encryptByPublicKey(byte[] arg0, byte[] publicKey)
			throws NoSuchAlgorithmException, InvalidKeyException, InvalidKeySpecException, IllegalBlockSizeException, BadPaddingException {
		X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKey);
		KeyFactory factory = KeyFactory.getInstance(ALGORITHM);
		PublicKey key = factory.generatePublic(x509KeySpec);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		return cipher.doFinal(arg0);
	}
}
