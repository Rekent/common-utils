package com.rekent.tools.utils;

import org.junit.Test;

import com.rekent.tools.utils.crypt.Base64Utils;
import com.rekent.tools.utils.crypt.HexUtils;
import com.rekent.tools.utils.crypt.UnicodeUtils;

import junit.framework.TestCase;

public class CryptUtilsTest extends TestCase {

	@Test
	public void testBase64() {
		String plainText = "richard.zhang";
		String encode = Base64Utils.encode(plainText);
		String urlEncode = Base64Utils.urlEncode(plainText);
		String decode = Base64Utils.decode(encode);
		String urlDecode = Base64Utils.urlDecode(urlEncode);
		System.out.println("encode:" + encode + ",urlEncode:" + urlEncode);
		System.out.println("decode:" + decode + ",urldecode:" + urlDecode);
	}
	
	@Test
	public void testHex() {
		String plainText = "richard.zhang";
		String hex = HexUtils.toHexString(plainText.getBytes());
		String decode = new String(HexUtils.toPlainText(hex));
		System.out.println("hex:"+hex+",decode:"+decode);
	}
	
	@Test
	public void testUnicode() {
		String plainText = "richard.zhang";
		String unicode = UnicodeUtils.toUnicode(plainText);
		String decode = UnicodeUtils.toPlainText(unicode);
		System.out.println(unicode+","+decode);
	}
}
