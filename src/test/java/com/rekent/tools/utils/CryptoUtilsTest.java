package com.rekent.tools.utils;

import java.security.GeneralSecurityException;

import org.junit.Test;

import com.rekent.tools.utils.crypto.AESUtils;

import junit.framework.TestCase;

public class CryptoUtilsTest extends TestCase {
	private static final String mode = "ECB";
	private static final String padding = "PKCS5Padding";

	@Test
	public void testAES() throws GeneralSecurityException {
		String plainText = "richard.zhang";
		String secert = AESUtils.encrypt(plainText, mode, padding, "moh1lqCEh6I2MIPy");
		String decode = AESUtils.decrypt(secert, mode, padding, "moh1lqCEh6I2MIPy");
		System.out.println(secert + "," + decode);
	}
}
