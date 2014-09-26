package org.ccserver.http.handler;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

import org.ccserver.http.HttpHeader;
import org.ccserver.http.HttpRequest;
import org.ccserver.http.HttpRequestBody;
import org.ccserver.http.HttpRequestHeader;

public class StaticHttpRequestHandler implements HttpRequestHandler{
	
	private static String _RN = "\r\n";
	private static String _BLANK = " ";
	private static String _RNRN = "\r\n\r\n";
	private static String _COLON = ":";
	private static String _DASH = "-";
	
	
	private SocketChannel sc;
	
	public StaticHttpRequestHandler() {
	}

	public StaticHttpRequestHandler(SocketChannel sc) {
		this.sc = sc;
	}


	@Override
	public HttpRequest handlerSocket(SocketChannel sc) {
		
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
        			
        			sc.close();
        			return null;
        		}
        		
        		bb.flip();
                byte[] data = new byte[count];
                bb.get(data, 0, count);
                requestSB.append(new String(data));
        	}
        	
        	System.out.println(Thread.currentThread().getPriority() + " - parse httprequest");
        	HttpRequest httpRequest = new HttpRequest();
        	HttpRequestHeader httpHeader = httpRequest.getHeader();
        	Map<String, String> headerMap = httpHeader.getHeaderMap();
        	
        	//parse the http header request string
        	StringTokenizer st = new StringTokenizer(requestSB.toString(), _RNRN);
        	String headLine = st.nextToken();
        	System.out.println("http header line: " + headLine);
        	
        	StringTokenizer headerLineST = new StringTokenizer(headLine, _RN);
        	String firstLine = headerLineST.nextToken();
        	String[] strs = firstLine.split(_BLANK);
        	if(strs == null || strs.length != 3){
        		throw new Exception("http request first line is not correct.");
        	}
        	
        	headerMap.put("method", strs[0]);
        	headerMap.put("path", strs[1]);
        	headerMap.put("httpVersion", strs[2]);
        	
        	String str = null;
        	String[] temp = null;
        	String key = null;
        	String[] keys = null;
        	
        	while(headerLineST.hasMoreTokens()){
        		str = headerLineST.nextToken();
        		temp = str.split(_COLON);
        		if(temp == null || temp.length != 2){
            		continue;
            	}
        		key = temp[0];
        		keys = key.split(_DASH);
        		if(keys != null && keys.length == 2){
        			key = keys[0] + keys[1];
        		}
        		headerMap.put(key, temp[1]);
        	}
        	
        	httpHeader = setValue(headerMap, HttpRequestHeader.class);
        	
        	System.out.println(httpRequest.toString());
        	
        	
        	//TODO get the path of resource, check if the resource exsits, if not ,return 404
        	
        	// if exsits, parse all the http headers
        	
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e2){
			e2.printStackTrace();
		}
        
		//sc.read();
		return null;
	}
	
	private HttpRequestHeader parseHeader(String requestStr){
		return null;
	}
	
	private HttpRequestBody parseBody(String requestStr){
		return null;
	}
	
	private HttpRequestHeader setValue(Map<String, String> map, Class clazz){
		try {
			HttpRequestHeader httpRequestHeader = (HttpRequestHeader) clazz.newInstance();
			for(Entry<String, String> entry : map.entrySet()){
				Method method = clazz.getDeclaredMethod("set"+entry.getKey(), String.class);
				method.invoke(httpRequestHeader, entry.getValue());
			}
			return httpRequestHeader;
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public SocketChannel getSc() {
		return sc;
	}

	public void setSc(SocketChannel sc) {
		this.sc = sc;
	}
	
	

}
