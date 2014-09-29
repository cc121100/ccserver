package org.ccserver.http;

public class HttpResponse {

	private HttpResponseHeader httpResponseHeader;
	private HttpResponseBody httpResponseBody;
	
	public HttpResponse() {
		httpResponseHeader = new HttpResponseHeader();
		httpResponseBody = new HttpResponseBody();
	}

	public HttpResponseHeader getHttpResponseHeader() {
		return httpResponseHeader;
	}

	public void setHttpResponseHeader(HttpResponseHeader httpResponseHeader) {
		this.httpResponseHeader = httpResponseHeader;
	}

	public HttpResponseBody getHttpResponseBody() {
		return httpResponseBody;
	}

	public void setHttpResponseBody(HttpResponseBody httpResponseBody) {
		this.httpResponseBody = httpResponseBody;
	}
	
}
