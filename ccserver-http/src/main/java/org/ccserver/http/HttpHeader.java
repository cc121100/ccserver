package org.ccserver.http;

public abstract class HttpHeader {

	//basic header
	private String connection;
	private String cacheControl;
	private String date;
	private String transferEncoding;
	private String pragma;
	
	//domain header
	private String contentLength;
	private String contentType;
	private String contentEncoding;
	private String contentLanguage;
	private String contentRange;
	private String contentLocation;
	private String expires;
	private String lastModified;
	
	
	
	
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getCacheControl() {
		return cacheControl;
	}
	public void setCacheControl(String cacheControl) {
		this.cacheControl = cacheControl;
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getTransferEncoding() {
		return transferEncoding;
	}
	public void setTransferEncoding(String transferEncoding) {
		this.transferEncoding = transferEncoding;
	}
	public String getContentEncoding() {
		return contentEncoding;
	}
	public void setContentEncoding(String contentEncoding) {
		this.contentEncoding = contentEncoding;
	}
	public String getContentLanguage() {
		return contentLanguage;
	}
	public void setContentLanguage(String contentLanguage) {
		this.contentLanguage = contentLanguage;
	}
	public String getContentRange() {
		return contentRange;
	}
	public void setContentRange(String contentRange) {
		this.contentRange = contentRange;
	}
	public String getContentLocation() {
		return contentLocation;
	}
	public void setContentLocation(String contentLocation) {
		this.contentLocation = contentLocation;
	}
	public String getExpires() {
		return expires;
	}
	public void setExpires(String expires) {
		this.expires = expires;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
	public String getPragma() {
		return pragma;
	}
	public void setPragma(String pragma) {
		this.pragma = pragma;
	}
	
	
}
