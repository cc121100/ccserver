package org.ccserver.resource.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileUtil {

	public static byte[] load(String filePath) throws IOException{
		return load(filePath, "UTF-8");
	}
	
	public static byte[] load(String filePath, String charset) throws IOException{
		File f = new File(filePath);
		if(!f.exists()){
			return null;
		}
		
		byte[] bytes = new byte[1024];
		int c = 0;
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(f));
		while((c = bis.read(bytes)) != -1){
			
			//System.arraycopy(bytes, 0, dest, destPos, length)
		}
		
		return null;
	}
}
