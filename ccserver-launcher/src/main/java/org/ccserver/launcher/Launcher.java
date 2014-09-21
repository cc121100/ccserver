package org.ccserver.launcher;

public class Launcher {
	
	/**
	 * 
	 */
	
	public static void main(String[] args) {
		
		new CCServerStartUp().startup();
		
		// 1. register server socket channel
		
		// 2. monitor server socket channel, 
		//	  if new socket channel, threadpool get thread, process
		
		// 3. parse http request header
		
		// 4. load resource by the header info
		
		// 5. socket write, socket.close, thread put back into threadpool
	}

}
