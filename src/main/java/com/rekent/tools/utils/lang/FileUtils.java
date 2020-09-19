package com.rekent.tools.utils.lang;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Quick local file operate
 * based on NIO
 * 
 * @author richard.zhang
 *
 */
public class FileUtils {

	/**
	 * convert local file to byte array
	 * base on {@link Files}
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static byte[] readLocalFiles(String path) throws IOException {
		Path filePath = Paths.get(path);
		return Files.readAllBytes(filePath);
	}

	/**
	 * write byte array to local file system
	 * base on {@link Files}
	 * 
	 * @param fileBytes
	 * @param path
	 * @param option
	 * @throws IOException
	 */
	public static void writeLocalFiles(byte[] fileBytes, String path, OpenOption option) throws IOException {
		Path filePath = Paths.get(path);
		Files.write(filePath, fileBytes, option);
	}
	
	/**
	 * get file name , before the last '.'
	 * @param fileName
	 * @return
	 */
	public static String getFileName(String fileName) {
		if (StringUtils.isBlank(fileName)) {
			throw new IllegalArgumentException("illegal file name");
		}
		String[] names = fileName.split("\\.");
		if (names.length < 2) {
			return fileName;
		}
		return fileName.substring(0,fileName.lastIndexOf("."));
	}
}
