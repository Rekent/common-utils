package com.rekent.tools.utils.lang;

import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * Utils to operate io stream
 * 
 * @author richard.zhang
 *
 */
public class IOUtils {
	private static final int BUFFER_SIZE = 1024;

	/**
	 * invoke {@link Closeable#close()}
	 * do not throw Exception
	 * 
	 * @param closeable
	 */
	public static void safetyClose(Closeable closeable) {
		try {
			closeable.close();
		} catch (Exception e) {
		}
	}

	/**
	 * read IO Stream to byte array
	 * 
	 * @param stream
	 * @param output
	 * @return
	 * @throws IOException
	 */
	public static byte[] readStreamAsBytes(InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
			byte[] buffer = new byte[BUFFER_SIZE];
			int len = -1;
			while ((len = stream.read(buffer)) != -1) {
				output.write(buffer, 0, len);
			}
			output.flush();
			return output.toByteArray();
		} catch (Exception e) {
			throw e;
		}

	}

	/**
	 * read IO stream to String
	 * 
	 * @param stream
	 * @param charset
	 * @return
	 * @throws IOException
	 */
	public static String readStreamAsString(InputStream stream, String charset) throws IOException {
		if (stream == null) {
			return null;
		}
		String response = "";
		byte[] bytes = new byte[stream.available()];
		if (bytes.length > 0) {
			stream.read(bytes);
			response = new String(bytes, charset);
		}
		return response;
	}

	/**
	 * Read byte array to hex string
	 * 
	 * @param byteArray
	 * @param limit
	 * @return
	 */
	public static String readByteArrayAsHex(byte[] byteArray, int limit) {
		StringBuilder builder = new StringBuilder();
		if (limit > byteArray.length) {
			throw new ArrayIndexOutOfBoundsException(limit);
		}
		for (int i = 0; i < byteArray.length; i++) {
			byte element = byteArray[i];
			int hex = element & 0xFF;
			String hv = Integer.toHexString(hex);
			if (hv.length() < 2) {
				builder.append(0);
			}
			builder.append(hv);
			if (i < limit) {
				break;
			}
		}
		return builder.toString();
	}
}
