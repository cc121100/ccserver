package org.ccserver.http.handler;

import java.io.File;
import java.io.IOException;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;

import org.ccserver.http.HttpConstants;
import org.ccserver.http.HttpRequest;
import org.ccserver.http.HttpRequestHeader;
import org.ccserver.http.HttpResponse;
import org.ccserver.http.HttpResponseBody;
import org.ccserver.http.HttpResponseHeader;
import org.ccserver.http.util.FileUtil;

public class StaticHttpResponseHandler implements HttpResponseHandler {

	private SocketChannel sc;
	
	private Map<String, String> serviceMapForResponse;
	
	private String responseFilePath = null;
	private int contentLength = 0;

	public StaticHttpResponseHandler() {
	}

	public StaticHttpResponseHandler(SocketChannel sc) {
		this.sc = sc;
	}

	@Override
	public boolean checkPathExsited(HttpRequest httpRequest,Map<String, Map<String, String>> servicesMap) {
		//boolean flag = false;
		String tempRequestPath = null;
		String requestPath = httpRequest.getHeader().getPath(); // /aaa/bbb/ccc.html
		if(requestPath == null || "".equals(requestPath)){
			return false;
		}
		if(!requestPath.startsWith(HttpConstants._SLASH)){
			requestPath  = requestPath + requestPath;
		}
		
		String referer = httpRequest.getHeader().getReferer();
		
		if(referer == null || "".equals(referer)){
			tempRequestPath = requestPath;
			//TODO as a resource,need a default
			
		}else{
			// page's other resource ,eg. css/jpg/js... , path from referer
			String requestPathPrefix = referer.substring("http://".length(), referer.length());
			String[] strs = requestPathPrefix.split(HttpConstants._SLASH);
			if(strs == null || strs.length < 2){
				return false;
			}
			tempRequestPath = HttpConstants._SLASH + strs[1] + requestPath;
			//return checkPathExsited(HttpConstants._SLASH + strs[1] + requestPath, servicesMap);
		}
		return checkPathExsited(tempRequestPath, servicesMap);
		
	}

	@Override
	public Byte[] loadResource() {
		return null;
	}

	@Override
	public void write(HttpResponse httpResponse) {
		StringBuffer sb = new StringBuffer();
	}
	
	private boolean checkPathExsited(String requestPath, Map<String, Map<String, String>> servicesMap){
		String servicePath = getServicePath(requestPath);// /aaa
		String resourcePath = requestPath.substring(servicePath.length(), requestPath.length());
		if(servicePath == null){
			return false;
		}
		
		// check servicePath exsited, both as a resurce or a service floder
		
		//as service floder
		if(!checkServicePath(servicePath, servicesMap)){
			return false;
		}
		if(!checkResource(serviceMapForResponse.get("location"), resourcePath)){
			return false;
		}
		return true;
	}
	
	
	private boolean checkServicePath(String path, Map<String, Map<String, String>> servicesMap){
		for(Entry<String, Map<String, String>> entry : servicesMap.entrySet()){
			if(path.equals(entry.getValue().get("path"))){
				serviceMapForResponse = entry.getValue();
				return true;
			}
		}
		return false;
	}
	
	private boolean checkResource(String serviceFileLocation, String requestFilePath){
		responseFilePath = "";
		responseFilePath = generateFullResourcePath(serviceFileLocation, requestFilePath);
		return new File(responseFilePath).exists();
	}
	
	private String getServicePath(String path){
		String[] strs = path.split(HttpConstants._SLASH);
		if(strs == null || strs.length < 2){
			return null;
		}
		return HttpConstants._SLASH + strs[1];
	}
	
	private String generateFullResourcePath(String prefixPath, String suffixPath){
		String str = null;
		if(!prefixPath.endsWith(HttpConstants._SLASH) 
				&& !suffixPath.startsWith(HttpConstants._SLASH)){
				
			str = prefixPath + HttpConstants._SLASH + suffixPath;
		}else{
			str = prefixPath + suffixPath;
		}
		return str;
	}
	
	public static void main(String[] args) {
		String str = "/aaa/bbb/ccc.html";
		String[] strs = str.split("/");
		for(String s : strs){
			System.out.println(s);
		}
		
		String a = str.substring("/aaa".length(), str.length());
		System.out.println(a);
		
		File f = new File("D:/development/maintain/201410/New.ext.Document.txt");
		String fileName = f.getName();
		String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
		System.err.println(suffix);
	}

	@Override
	public HttpResponseHeader generateHttpResponseHeader(HttpRequestHeader httpRequestHeader) {
		
		HttpResponseHeader httpResponseHeader = new HttpResponseHeader();
		
		//only think about 200/404
		httpResponseHeader.setConnection(httpResponseHeader.getConnection());
		httpResponseHeader.setServer("CCServer");
		httpResponseHeader.setDate(new Date().toGMTString());
		httpResponseHeader.setAccessControlAllowOrigin("*");
		
		File file = new File(responseFilePath);
		
		httpResponseHeader.setContentLength(file.length() + "");
		httpResponseHeader.setContentEncoding("gzip");
		
		String accept = httpRequestHeader.getAccept();
		if(accept.contains("text/html")){
			httpResponseHeader.setContentType("text/html;charset=UTF-8");
		}else if(accept.contains("text/css")){
			httpResponseHeader.setContentType("text/css;charset=UTF-8");
		}else if(accept.contains("image/webp")){
			String fileName = file.getName();
			String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);
			httpResponseHeader.setContentType("image/" + suffix + ";charset=UTF-8");
		}else {
			httpResponseHeader.setContentType("application/x-javascript;charset=UTF-8");
		}
		
		// HTTP/1.1 200 Not Found
		httpResponseHeader.setHttpVersion("HTTP/1.1");
		httpResponseHeader.setStatusCode("200");
		httpResponseHeader.setStatusDescription("OK");
		
		return httpResponseHeader;
	}

	@Override
	public HttpResponseBody generateHttpResponseBody(HttpRequestHeader httpRequestHeader) throws IOException {
		HttpResponseBody httpResponseBody = new HttpResponseBody();
		byte[] bytes = FileUtil.load(responseFilePath);
		httpResponseBody.setResponseContent(bytes);
		return httpResponseBody;
	}
	
}
