package org.ccserver.resource;

public class CCServerContextConstants {
	
	private IOPattern ioPattern;
	private HttpPattern httpPattern;
	
	public CCServerContextConstants() {
	}

	public CCServerContextConstants(IOPattern ioPattern, HttpPattern httpPattern) {
		this.ioPattern = ioPattern;
		this.httpPattern = httpPattern;
	}

	public IOPattern getIoPattern() {
		return ioPattern;
	}

	public void setIoPattern(IOPattern ioPattern) {
		this.ioPattern = ioPattern;
	}

	public HttpPattern getHttpPattern() {
		return httpPattern;
	}

	public void setHttpPattern(HttpPattern httpPattern) {
		this.httpPattern = httpPattern;
	}
	
	
	
	
}
