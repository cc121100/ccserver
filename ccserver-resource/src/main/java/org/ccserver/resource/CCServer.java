package org.ccserver.resource;

import java.util.ArrayList;
import java.util.List;

public class CCServer {
	
	private static CCServer ccServer = null;
	
	private Server server;
	
	private CCServerContextConstants ccsConstants;
	


	private CCServer() {
	}


	
	public synchronized static CCServer newInstance(){
		if(ccServer == null){
			ccServer = new CCServer();
			initCCserver();
		}
		return ccServer;
	}
	
	private static void initCCserver() {
		//TODO load ccserver configuration from xml
		
		System.err.println("Start init CCserver...");
		//services
		List<Service> services = new ArrayList<>();
		Service service = new Service("service1", "/service1", "D:\\cc\\study\\myserver-workspace\\ccserver\\ccserver-http");
		services.add(service);
		
		//server
		Server server = new Server(80, services);
		
		//ccsConstants
		CCServerContextConstants ccsConstants = new CCServerContextConstants(IOPattern.NIO, HttpPattern.HTTP_STATIC);
		
		ccServer.setServer(server);
		ccServer.setCcsConstants(ccsConstants);
		
		
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

	public static CCServer getCcServer() {
		return ccServer;
	}

	public static void setCcServer(CCServer ccServer) {
		CCServer.ccServer = ccServer;
	}
	
}


