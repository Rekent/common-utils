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
public class QuickFileUtils {

	/**
	 * convert local file to byte array
	 * base on {@link Files}
	 * 
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFileAsByteArray(String path) throws IOException {
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
	public static void writeBytesIntoFile(byte[] fileBytes, String path, OpenOption option) throws IOException {
		Path filePath = Paths.get(path);
		Files.write(filePath, fileBytes, option);
	}
}
