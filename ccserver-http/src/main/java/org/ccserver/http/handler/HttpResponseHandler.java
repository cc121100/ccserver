package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;

import org.ccserver.http.HttpRequest;

public interface HttpResponseHandler {

	public boolean checkPathExsited(HttpRequest httpRequest);
	
	public Byte[] loadResource();
	
	public void write();
	
}
