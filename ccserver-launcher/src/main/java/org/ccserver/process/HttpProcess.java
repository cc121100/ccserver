package org.ccserver.process;

import java.nio.channels.SocketChannel;

import org.ccserver.resource.CCServer;

public class HttpProcess implements Runnable {
	
	private CCServer ccs;
	private SocketChannel sc;
	
	public HttpProcess(){
		
	}
	
	public HttpProcess(CCServer ccs, SocketChannel sc) {
		this.ccs = ccs;
		this.sc = sc;
	}


	@Override
	public void run() {
		
	}

}
