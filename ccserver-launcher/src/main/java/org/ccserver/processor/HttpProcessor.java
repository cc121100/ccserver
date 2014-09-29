package org.ccserver.processor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.ccserver.http.HttpRequest;
import org.ccserver.http.handler.HttpRequestHandler;
import org.ccserver.http.handler.StaticHttpRequestHandler;
import org.ccserver.resource.CCServer;

public class HttpProcessor implements Runnable {
	
	private CCServer ccs;
	private SocketChannel sc;
	
	public HttpProcessor(){
		
	}
	
	public HttpProcessor(CCServer ccs, SocketChannel sc) {
		this.ccs = ccs;
		this.sc = sc;
	}


	@Override
	public void run() {
		HttpRequestHandler requestHandler = new StaticHttpRequestHandler(sc);
		
		HttpRequest httpRequest;
		try {
			httpRequest = requestHandler.handlerSocket(sc);
			
			String responseStr = httpRequest.getHeader().getPath() + " 404 ";
			
			StringBuffer sb = new StringBuffer();
	        sb.append("HTTP/1.1 200 Not Found").append("\r\n");
	        sb.append("Content-Type: ").append("text/html").append("\r\n");
	        sb.append("\r\n");
	        sb.append("<html>");
	        sb.append("<head><meta http-equiv='Content-Type' content='text/html; charset=utf-8' /><link type='text/css' rel='stylesheet' href='/css/a.css' charset='utf-8' /></head>");
	        sb.append("<body>");
	        sb.append(httpRequest.getHeader().getPath() + " 404");
	        sb.append("<img src='/a.jpg'/>");
	        sb.append("");
	        sb.append("");
	        sb.append("");
	        sb.append("");
	        sb.append("");
	        sb.append("");
	        sb.append("");
	        sb.append("");
	        sb.append("</body>");
	        sb.append("</html>");
			
			// 1 init HttpRequestHandler and analyze channel socket bytes into httprequest
			
			// 2 load resource accroding the request 
			
			// 3 init HttpResponseHandler and response the resource
			ByteBuffer bb = ByteBuffer.allocate(1024);
			bb.put(sb.toString().getBytes());
			bb.flip();
			sc.write(bb);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally{
			try {
				sc.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
