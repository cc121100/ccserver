package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;

import org.ccserver.http.HttpRequest;

public class StaticHttpResponseHandler implements HttpResponseHandler {

	private SocketChannel sc;
	

	public StaticHttpResponseHandler() {
	}

	public StaticHttpResponseHandler(SocketChannel sc) {
		this.sc = sc;
	}

	@Override
	public boolean checkPathExsited(HttpRequest httpRequest) {
		return false;
	}

	@Override
	public Byte[] loadResource() {
		return null;
	}

	@Override
	public void write() {
		
	}
	
	
}
