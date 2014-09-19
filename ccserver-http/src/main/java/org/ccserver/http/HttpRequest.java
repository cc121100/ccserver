package org.ccserver.http;

import java.nio.channels.SocketChannel;
import java.util.Map;

public class HttpRequest {

	private HttpRequestHeader header;
	
	private HttpRequestBody body;

	public HttpRequest() {
		this.header = new HttpRequestHeader();
		this.body = new HttpRequestBody();
	}

	public HttpRequest(HttpRequestHeader header, HttpRequestBody body) {
		super();
		this.header = header;
		this.body = body;
	}

	public HttpRequestHeader getHeader() {
		return header;
	}

	public void setHeader(HttpRequestHeader header) {
		this.header = header;
	}

	public HttpRequestBody getBody() {
		return body;
	}

	public void setBody(HttpRequestBody body) {
		this.body = body;
	}
	
	public void generateHeader(SocketChannel sc){
		
	}
	
}
