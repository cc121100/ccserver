package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;

import org.ccserver.http.HttpRequest;

public interface HttpRequestHandler {

	public HttpRequest handlerSocket(SocketChannel sc) throws Exception;
	
	
}
