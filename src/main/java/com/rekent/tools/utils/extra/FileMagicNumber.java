package com.rekent.tools.utils.extra;

import java.util.HashMap;

/**
 * 
 * file magic number
 * 
 * @author richard.zhang
 *
 */
public class FileMagicNumber extends HashMap<String, String> {
	private static final long serialVersionUID = 5627597852762209137L;
	public static HashMap<String, String> magicNumebrs = new HashMap<String, String>();

	static {
		magicNumebrs.put("FFD8FF", "jpg");
		magicNumebrs.put("89504E47", "png");
		magicNumebrs.put("47494638", "gif");
		magicNumebrs.put("49492A00", "tif");
		magicNumebrs.put("424D", "bmp");
		magicNumebrs.put("41433130", "dwg");
		magicNumebrs.put("38425053", "psd");
		magicNumebrs.put("7B5C727466", "rtf");
		magicNumebrs.put("3C3F786D6C", "xml");
		magicNumebrs.put("68746D6C3E", "html");
		magicNumebrs.put("2142444E", "pst");
		magicNumebrs.put("D0CF11E0", "doc");
		magicNumebrs.put("255044462D312E", "pdf");
		magicNumebrs.put("504B0304", "zip");
		magicNumebrs.put("52617221", "rar");
		magicNumebrs.put("57415645", "wav");
		magicNumebrs.put("41564920", "avi");
		magicNumebrs.put("2E7261FD", "ram");
		magicNumebrs.put("2E524D46", "rm");
		magicNumebrs.put("000001BA", "mpg");
		magicNumebrs.put("4D546864", "mid");
		magicNumebrs.put("504b0304", "docx");
	}
}
