package org.ccserver.resource;

import java.util.List;

public class Server {

	private int port;
	
	private List<Service> services;
	

	public Server() {
	}
	

	public Server(int port, List<Service> services) {
		this.port = port;
		this.services = services;
	}


	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}


	public int getPort() {
		return port;
	}


	public void setPort(int port) {
		this.port = port;
	}
	
	
}
