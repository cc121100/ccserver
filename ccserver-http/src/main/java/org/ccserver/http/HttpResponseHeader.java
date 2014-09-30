package org.ccserver.http;

public class HttpResponseHeader extends HttpHeader {
	
	private String httpVersion;
	private String statusCode;
	private String statusDescription;

	private String acceptRange;
	private String age;
	private String eTag;
	private String location;
	private String proxyAuthenticate;
	private String retryAfter;
	private String server;
	private String vary;
	
	
	
	public String getAcceptRange() {
		return acceptRange;
	}
	public void setAcceptRange(String acceptRange) {
		this.acceptRange = acceptRange;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String geteTag() {
		return eTag;
	}
	public void seteTag(String eTag) {
		this.eTag = eTag;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProxyAuthenticate() {
		return proxyAuthenticate;
	}
	public void setProxyAuthenticate(String proxyAuthenticate) {
		this.proxyAuthenticate = proxyAuthenticate;
	}
	public String getRetryAfter() {
		return retryAfter;
	}
	public void setRetryAfter(String retryAfter) {
		this.retryAfter = retryAfter;
	}
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}
	public String getVary() {
		return vary;
	}
	public void setVary(String vary) {
		this.vary = vary;
	}
	public String getHttpVersion() {
		return httpVersion;
	}
	public void setHttpVersion(String httpVersion) {
		this.httpVersion = httpVersion;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	
}
