package org.ccserver.http.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.ccserver.http.HttpConstants;
import org.ccserver.http.HttpHeader;
import org.ccserver.http.HttpRequest;
import org.ccserver.http.HttpRequestBody;
import org.ccserver.http.HttpRequestHeader;

public class StaticHttpRequestHandler implements HttpRequestHandler{
	
	
	private SocketChannel sc;
	
	public StaticHttpRequestHandler() {
	}

	public StaticHttpRequestHandler(SocketChannel sc) {
		this.sc = sc;
	}


	@Override
	public HttpRequest handlerSocket(SocketChannel sc) throws Exception {
		System.out.println("-----------------------------------------------");
		StringBuffer requestSB = new StringBuffer();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        int count = 0;
        
        try {
        	while(true){
        		bb.clear();
        		count = sc.read(bb);
        		if(count == 0){
        			break;
        		}else if(count < 0 ){
        			
        			throw new Exception("Socket channel shutdown.");
        		}
        		
        		bb.flip();
                byte[] data = new byte[count];
                bb.get(data, 0, count);
                requestSB.append(new String(data));
        	}
        	
        	System.err.println(Thread.currentThread().getPriority() + " - parse httprequest");
        	System.out.println(requestSB.toString());
        	HttpRequest httpRequest = new HttpRequest();
        	HttpRequestHeader httpHeader = httpRequest.getHeader();
        	Map<String, String> headerMap = new LinkedHashMap<>();
        	
        	//parse the http header request string
        	StringTokenizer st = new StringTokenizer(requestSB.toString(), HttpConstants._RN, false);
        	String headLine = st.nextToken();
        	System.err.println("http header line: " + headLine);
        	
        	String[] strs = headLine.split(HttpConstants._BLANK);
        	if(strs == null || strs.length != 3){
        		throw new Exception("http request first line is not correct.");
        	}
        	headerMap.put("Method", strs[0]);
        	headerMap.put("Path", strs[1]);
        	headerMap.put("HttpVersion", strs[2]);
        	
        	
        	String str = null;
        	String[] temp = null;
        	String key = null;
        	String[] keys = null;
        	
        	while(st.hasMoreTokens()){
        		str = st.nextToken();
        		if(str == null || HttpConstants._RN.equals(str)){
        			break;
        		}
        		temp = str.split(HttpConstants._COLON_SPACE);
        		if(temp == null || temp.length != 2){
            		continue;
            	}
        		key = temp[0];
        		keys = key.split(HttpConstants._DASH);
        		if(keys != null && keys.length >= 2){
        			key = "";
        			for(String keyStr : keys){
        				key = key + keyStr;
        			}
        		}
        		headerMap.put(key, temp[1]);
        	}
        	
        	httpHeader = setValue(headerMap, HttpRequestHeader.class);
        	httpRequest.setHeader(httpHeader);
        	
        	//System.out.println(httpRequest.toString());
        	
			return httpRequest;
		} catch(Exception e2){
			throw new Exception(e2);
		}
        
	}
	
	private HttpRequestHeader parseHeader(String requestStr){
		return null;
	}
	
	private HttpRequestBody parseBody(String requestStr){
		return null;
	}
	
	private HttpRequestHeader setValue(Map<String, String> map, Class clazz) throws Exception{
		try {
			HttpRequestHeader httpRequestHeader = (HttpRequestHeader) clazz.newInstance();
			for(Entry<String, String> entry : map.entrySet()){
				Method method = clazz.getMethod("set"+entry.getKey(), String.class);
				method.invoke(httpRequestHeader, entry.getValue());
			}
			return httpRequestHeader;
		} catch (Exception e) {
			throw new Exception("Error occurs when setValue", e);
		} 
	}
	

	public SocketChannel getSc() {
		return sc;
	}

	public void setSc(SocketChannel sc) {
		this.sc = sc;
	}
	
	

}
