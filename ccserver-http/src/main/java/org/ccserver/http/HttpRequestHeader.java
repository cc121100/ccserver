package org.ccserver.http;

import java.util.Map;

public class HttpRequestHeader extends HttpHeader {
	
	
	private String method;
	
	private String path;
	
	private String httpVersion;

	/*************************************/
	
	/*Host: localhost:10002
	Connection: keep-alive
	Content-Length: 661
	Cache-Control: max-age=0
	Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*;q=0.8
	Origin: null
	User-Agent: Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/35.0.1916.114 Safari/537.36
	Content-Type: multipart/form-data; boundary=----WebKitFormBoundaryvjfTE5rpLXKtnD7e
	Accept-Encoding: gzip,deflate,sdch
	Accept-Language: zh-CN,zh;q=0.8
	Cookie: csrftoken=0QR3SlizfYmT9W5olDSFvKDctOp72NYY*/
	
	private String host;
	private String connection;
	private String contentLength;
	private String contentType;
	private String accept;
	private String origin;
	private String acceptEncoding;
	private String acceptLanguage;
	private String userAgent;
	private String cacheControl;
	private Map<String, String> cookie;
	
	private Map<String, String> headerMap;

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getHttpVersion() {
		return httpVersion;
	}

	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getConnection() {
		return connection;
	}

	public void setConnection(String connection) {
		this.connection = connection;
	}

	public String getContentLength() {
		return contentLength;
	}

	public void setContentLength(String contentLength) {
		this.contentLength = contentLength;
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

	public String getAcceptEncoding() {
		return acceptEncoding;
	}

	public void setAcceptEncoding(String acceptEncoding) {
		this.acceptEncoding = acceptEncoding;
	}

	public String getAcceptLanguage() {
		return acceptLanguage;
	}

	public void setAcceptLanguage(String acceptLanguage) {
		this.acceptLanguage = acceptLanguage;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	public String getCacheControl() {
		return cacheControl;
	}

	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
	}

	public Map<String, String> getCookie() {
		return cookie;
	}

	public void setCookie(Map<String, String> cookie) {
		this.cookie = cookie;
	}

	public Map<String, String> getHeaderMap() {
		return headerMap;
	}

	public void setHeaderMap(Map<String, String> headerMap) {
		this.headerMap = headerMap;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	
}
