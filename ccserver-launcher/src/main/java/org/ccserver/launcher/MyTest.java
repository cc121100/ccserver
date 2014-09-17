package org.ccserver.launcher;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyTest {

	public static void main(String[] args){
		ServerSocket ss;
		Socket s = null;
		try {
			ss = new ServerSocket(9999);
			System.err.println("server is up...");
			byte[] bytes = new byte[1024];
			List<Byte> tmp = new ArrayList<>();
			int i = 0;
			
			while(true){
				s = ss.accept();
				InputStream in = s.getInputStream();
				in.read(bytes);
				System.out.print(new String(bytes).trim());
				File f = new File("d:\\2.htm");
				if(f.exists()){
					bytes = new byte[1024];
					BufferedInputStream bs = new BufferedInputStream(new FileInputStream(f));
					while((i = bs.read(bytes)) != -1){
						s.getOutputStream().write(bytes);
						bytes = new byte[1024];
					}
					
				}else{
					s.getOutputStream().write(new String("404").getBytes());
				}
				s.getOutputStream().flush();
				
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			if(s != null){
				try {
					s.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static byte[] loadHtml(){
		byte[] result = new byte[1024];
		File f = new File("d:\\2.htm");
		if(f.exists()){
			try {
				byte[] bytes = new byte[1024];
				int i = 0;
				BufferedInputStream bs = new BufferedInputStream(new FileInputStream(f));
				while((i = bs.read(bytes)) != -1){
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
