package com.rekent.tools.utils.lang;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 
 * Utils to generate random object
 * 
 * @author richard.zhang
 *
 */
public class RandomUtils {
	private static String RANDOM_STRINGS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

	/**
	 * generate random string contain a-z|a-Z|0-9
	 * 
	 * @param length random string length
	 * @return
	 */
	public static String randomString(int length) {
		if (length < 0) {
			return null;
		}
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int index = new Random().nextInt() % RANDOM_STRINGS.length();
			builder.append(RANDOM_STRINGS.indexOf(index));
		}
		return builder.toString();
	}

	/**
	 * generate random number
	 * 
	 * @param min random min value
	 * @param max random max value
	 * @return
	 */
	public static int randomNum(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}
}
