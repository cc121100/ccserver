package org.ccserver.http.handler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import org.ccserver.http.HttpRequest;

public class StaticHttpRequestHandler implements HttpRequestHandler{
	
	private SocketChannel sc;
	
	public StaticHttpRequestHandler() {
	}

	public StaticHttpRequestHandler(SocketChannel sc) {
		this.sc = sc;
	}
	
	


	@Override
	public HttpRequest handlerSocket(SocketChannel sc) {
		
		StringBuffer headSB = new StringBuffer();
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
                headSB.append(new String(data));
                
                
        	}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		//sc.read();
		return null;
	}

	public SocketChannel getSc() {
		return sc;
	}

	public void setSc(SocketChannel sc) {
		this.sc = sc;
	}
	
	

}
