package org.ccserver.processor;

import java.nio.channels.SocketChannel;

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
		
		// 1 init HttpRequestHandler and analyze channel socket bytes into httprequest
		
		// 2 load resource accroding the request 
		
		// 3 init HttpResponseHandler and response the resource
		
	}

}
