package org.ccserver.serversocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

import org.ccserver.resource.CCServer;

public class NIOCCServerSocket implements CCServerSocket {
	
	private CCServer ccs;
	private Selector selector;

	public NIOCCServerSocket(CCServer ccs) {
		this.ccs = ccs;
	}

	@Override
	public void open() {
		try {
			selector = Selector.open();
			SocketAddress sa = new InetSocketAddress(ccs.getServer().getPort()); 
			ServerSocketChannel ssc = ServerSocketChannel.open();
			ssc.socket().bind(sa);
			ssc.configureBlocking(false);
			ssc.register(selector, SelectionKey.OP_ACCEPT);
		} catch (IOException e) {
			// TODO log exception when open selector
			e.printStackTrace();
		}
		
		
	}

	@Override
	public void monitor() {
		try {
			
			Iterator<SelectionKey> it = null;
            while(true){
 
                selector.select();
 
                it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
 
                    SelectionKey key = it.next();
                    it.remove();
 
                    ServerSocketChannel server = null;
                    SocketChannel client = null;
                    if(key.isAcceptable())
                    {
                        server = (ServerSocketChannel)key.channel();
                        client = server.accept();
                        //System.out.println("客户端： " + client.socket().getRemoteSocketAddress().toString());
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ);
                        key.selector().wakeup();
                    } else if (key.isReadable()) {
//                        key.interestOps(0);
//                        Session session = (Session) key.attachment();
//                        AnalyseHandle analyseHandle = new AnalyseHandle(session);
//                        ThreadPool.getInstance().execute(analyseHandle);
                    	
                    	
                    	/*
                    	 * client = (SocketChannel)selectionKey.channel();
                        receivebuffer.clear();  
                        int count = client.read(receivebuffer);   
                        //System.out.println("服务器端接受客户端数据--:");  
                        if (count > 0) {  
                            String receiveText = new String( receivebuffer.array(),0,count);  
                            System.out.print(receiveText);  
                            client.register(selector, SelectionKey.OP_READ);  
                        }*/
                    	
                    	
                    	
                    	
                    }
 
                }
 
            }
 
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
