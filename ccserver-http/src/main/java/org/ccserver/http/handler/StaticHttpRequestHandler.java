package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;

public class StaticHttpRequestHandler implements HttpRequestHandler{
	
	private SocketChannel sc;
	
	public StaticHttpRequestHandler() {
	}

	public StaticHttpRequestHandler(SocketChannel sc) {
		this.sc = sc;
	}
	
	


	@Override
	public byte[] handlerSocket(SocketChannel sc) {
		return null;
	}

	public SocketChannel getSc() {
		return sc;
	}

	public void setSc(SocketChannel sc) {
		this.sc = sc;
	}
	
	

}
