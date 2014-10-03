package org.ccserver.http.handler;

import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Map;

import org.ccserver.http.HttpRequest;
import org.ccserver.http.HttpRequestHeader;
import org.ccserver.http.HttpResponse;
import org.ccserver.http.HttpResponseBody;
import org.ccserver.http.HttpResponseHeader;

public interface HttpResponseHandler {

	public Byte[] loadResource();
	
	public void write(HttpResponse httpResponse);

	boolean checkPathExsited(HttpRequest httpRequest,
			Map<String, Map<String, String>> servicesMap);
	
	HttpResponseHeader generateHttpResponseHeader(HttpRequestHeader httpRequestHeader);
	
	HttpResponseBody generateHttpResponseBody(HttpRequestHeader httpRequestHeader) throws IOException;
	
}
