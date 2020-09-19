package com.rekent.tools.utils;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;

import com.rekent.tools.utils.digest.HmacMD5Utils;
import com.rekent.tools.utils.digest.HmacSHA256Utils;
import com.rekent.tools.utils.digest.MD5Utils;
import com.rekent.tools.utils.digest.SHA256Utils;

import junit.framework.TestCase;

public class DigestUtilsTest extends TestCase {

	@Test
	public void testMD5() {
		String plainText = "richard.zhang";
		String md5 = MD5Utils.toMD5(plainText);
		System.out.println(md5);
	}

	@Test
	public void testSHA256() {
		String plainText = "richard.zhang";
		String sha256 = SHA256Utils.toSHA256(plainText);
		System.out.println(sha256);
	}
	
	@Test
	public void testHmacMD5() throws InvalidKeyException, NoSuchAlgorithmException {
		String plainText = "richard.zhang";
		String key = "richard";
		String hmacMD5 = HmacMD5Utils.toHmcMD5(plainText, key.getBytes());
		System.out.println(hmacMD5);
	}
	
	@Test
	public void testHmacSHA256() throws InvalidKeyException {
		String plainText = "richard.zhang";
		String key = "richard";
		String hmacMD5 = HmacSHA256Utils.toHmacSHA256(plainText, key.getBytes());
		System.out.println(hmacMD5);
	}
}
