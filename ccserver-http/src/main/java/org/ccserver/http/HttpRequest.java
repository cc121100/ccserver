package org.ccserver.http;

import java.util.Map;

public class HttpRequest {

	private String clientIpAddr;
	
	private String clientPort;
	
	private String method;
	
	private String path;
	
	private String httpVersion;
	
	private String host;
	
	private String ipAddr;
	
	private String conState;
	
	private String[] accept;
	
	private String userAgent;
	
	private String[] acceptEncoding;
	
	private String acceptLanguage;
	
	private Map<String, String> cookie;
}
