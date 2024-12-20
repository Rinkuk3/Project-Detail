package com.td.mbna.msec.midtier.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * This class contains helper methods to manipulate files.
 *
 */
public class IoUtil {

	private static MbnaLogger logger = new MbnaLogger(IoUtil.class);
	
	/**
	 * Close ignore exception
	 * @param is
	 */
	public static void closeIgnoreException(InputStream is) {
		try {
			if (is != null) {
				is.close();
			}
		}
		catch (Throwable ignore) {
			logger.error("closeIgnoreException failed: " + ignore);
		}
	}
	
	/**
	 * Close ignore exception
	 * @param os
	 */
	public static void closeQuietly(OutputStream os) {
		try {
			if (os != null) {
				os.close();
			}
		}
		catch (Throwable ignore) {
			logger.error("closeQuietly failed: " + ignore);
		}
	}
	
	/**
	 * read full input stream
	 * @param is
	 * @return
	 * @throws IOException
	 */
	public static byte[] readFully(InputStream is) throws IOException {
		byte[] buf = new byte[4096];
		ByteArrayOutputStream os = new ByteArrayOutputStream(4096);
		int numBytesRead;
		while ((numBytesRead = is.read(buf)) != -1) {
			os.write(buf, 0, numBytesRead);
		}
  		return os.toByteArray();
	}
}
