package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;

public interface HttpRequestHandler {

	public byte[] handlerSocket(SocketChannel sc);
	
	
}
