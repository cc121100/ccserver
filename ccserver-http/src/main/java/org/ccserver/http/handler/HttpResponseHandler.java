package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;
import java.util.Map;

import org.ccserver.http.HttpRequest;

public interface HttpResponseHandler {

	public Byte[] loadResource();
	
	public void write();

	boolean checkPathExsited(HttpRequest httpRequest,
			Map<String, Map<String, String>> servicesMap);
	
}
