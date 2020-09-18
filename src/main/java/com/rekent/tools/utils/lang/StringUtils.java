package com.rekent.tools.utils.lang;

/**
 * 
 * Utils to operate String
 * 
 * @author richard.zhang
 *
 */
public class StringUtils {

	/**
	 * Return charSequence is null or blank
	 * 
	 * @param charSequence
	 * @return
	 */
	public static boolean isBlank(CharSequence charSequence) {
		return charSequence == null || charSequence.length() == 0;
	}

	/**
	 * Return charSequence is not null and not blank
	 * 
	 * @param charSequence
	 * @return
	 */
	public static boolean isNotBlank(CharSequence charSequence) {
		return !isBlank(charSequence);
	}

	/**
	 * Return if any charSequence args is blank
	 * 
	 * @param charSequences
	 * @return
	 */
	public static boolean isAnyBank(CharSequence... charSequences) {
		if (charSequences == null || charSequences.length == 0) {
			return false;
		}
		for (CharSequence cs : charSequences) {
			if (isBlank(cs)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Return if all charSequence args is blank
	 * 
	 * @param charSequences
	 * @return
	 */
	public static boolean isAllBlank(CharSequence... charSequences) {
		if (charSequences == null || charSequences.length == 0) {
			return true;
		}
		for (CharSequence cs : charSequences) {
			if (isNotBlank(cs)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return if arg0 equals arg1
	 * if arg0 is null or arg1 is null, return false
	 * 
	 * @param arg0
	 * @param arg1
	 * @return
	 */
	public static boolean equals(CharSequence arg0, CharSequence arg1) {
		if (isAnyBank(arg0, arg1)) {
			return false;
		}
		return arg0.equals(arg1);
	}
}
