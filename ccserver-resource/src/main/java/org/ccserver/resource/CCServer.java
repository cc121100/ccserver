package org.ccserver.resource;

public class CCServer {
	
	private static CCServer ccServer = null;
	
	private Server server;
	
	private CCServerContextConstants ccsConstants;
	


	private CCServer() {
		initCCserver();
	}


	
	public static CCServer newInstance(){
		if(ccServer == null){
			synchronized (ccServer) {
				if(ccServer != null){
					ccServer = new CCServer();
				}
			}
		}
		
		return ccServer;
	}
	
	private void initCCserver() {
		//TODO load ccserver configuration from xml
		
		
	}
	
	public Server getServer() {
		return server;
	}
	
	public void setServer(Server server) {
		this.server = server;
	}

	public CCServerContextConstants getCcsConstants() {
		return ccsConstants;
	}

	public void setCcsConstants(CCServerContextConstants ccsConstants) {
		this.ccsConstants = ccsConstants;
	}
	
}


