package org.ccserver.http;

import java.lang.reflect.Field;

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

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		
		
		return "HttpResponse [httpResponseHeader=" + httpResponseHeader
				+ ", httpResponseBody=" + httpResponseBody + "]";
		
	}
	
	public static void main(String[] args) {
		Class clazz1 = HttpResponseHeader.class;
		System.out.println("-------field--------");
		for(Field field : clazz1.getDeclaredFields()){
			System.out.println(field.getName());
		}
		
		Class clazz2 = HttpResponseBody.class;
		System.out.println("-------field--------");
		for(Field field : clazz2.getDeclaredFields()){
			System.out.println(field.getName());
		}
		
	}
	
}
