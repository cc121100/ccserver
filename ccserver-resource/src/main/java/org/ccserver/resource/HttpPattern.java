package org.ccserver.resource;

public enum HttpPattern {
	
	HTTP_STATIC(0,"static"),HTTP_SERVLRT(1,"servlet");

	
	private HttpPattern(int code, String value){
		this.code = code;
		this.value = value;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}



	private int code;
	private String value;
	
}
