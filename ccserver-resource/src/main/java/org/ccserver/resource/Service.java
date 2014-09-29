package org.ccserver.resource;

public class Service {

	private String name;
	
	private String path;
	
	private String location;

	public Service() {
	}

	public Service(String name, String path,String location) {
		this.name = name;
		this.path = path;
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
