package org.ccserver.launcher;

import org.ccserver.resource.CCServer;
import org.ccserver.serversocket.CCServerSocket;
import org.ccserver.serversocket.NIOCCServerSocket;

public class CCServerStartUp implements Runnable {
	
	private CCServer ccServer = null;

	private CCServerSocket ccss = null;
	
	public void startup(){
		ccServer = CCServer.newInstance();
		
		CCServerFactory ccsFactory = new CCServerFactory();
		
		ccss = ccsFactory.generate(ccServer);
		
		run();
	}
	

	@Override
	public void run() {
		
		ccss.open();
		
		ccss.monitor();
		
	}

}
