package org.ccserver.http.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {

	public static byte[] load(String filePath) throws IOException {
		return load(filePath, "UTF-8");
	}

	public static byte[] load(String filePath, String charset) throws IOException{
		File file = new File(filePath);
		if (file.exists()) {
			if (file.isDirectory()) {
				throw new IOException("File '" + file + "' exists but is a directory");
			}
			if (file.canRead() == false) {
				throw new IOException("File '" + file + "' cannot be read");
			}
		} else {
			throw new FileNotFoundException("File '" + file + "' does not exist");
		}
		
		if(file.length() > Integer.MAX_VALUE) {
	          throw new IllegalArgumentException("Size cannot be greater than Integer max value: " + file.length());
	      }
		
		int size = (int) file.length();

		if (size < 0) {
            throw new IllegalArgumentException("Size must be equal or greater than zero: " + size);
        }

        if (size == 0) {
            return new byte[0];
        }
        
        FileInputStream in = new FileInputStream(file);
        byte[] data = new byte[size];
        int offset = 0;
        int readed;

        try {
			while (offset < size && (readed = in.read(data, offset, size - offset)) != -1) {
			    offset += readed;
			}
		} catch (IOException e) {
			throw new IOException("Unexpected readed size. current: " + offset + ", excepted: " + size);
		}finally{
			if(in != null){
				in.close();
			}
		}

        if (offset != size) {
            throw new IOException("Unexpected readed size. current: " + offset + ", excepted: " + size);
        }

        return data;
	}
	
	
}
