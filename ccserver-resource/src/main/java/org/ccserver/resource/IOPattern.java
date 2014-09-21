package org.ccserver.resource;

public enum IOPattern {
	
	BIO(0,"bio"),NIO(1,"nio"),AIO(1,"aio");

	
	private IOPattern(int code, String value){
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
