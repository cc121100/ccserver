package org.ccserver.http.handler;

import java.nio.channels.SocketChannel;
import java.util.Map;

import org.ccserver.http.HttpRequest;
import org.ccserver.http.HttpResponse;
import org.ccserver.http.HttpResponseBody;
import org.ccserver.http.HttpResponseHeader;

public interface HttpResponseHandler {

	public Byte[] loadResource();
	
	public void write();

	boolean checkPathExsited(HttpRequest httpRequest,
			Map<String, Map<String, String>> servicesMap);
	
	HttpResponseHeader generateHttpResponseHeader();
	
	HttpResponseBody generateHttpResponseBody();
	
}
