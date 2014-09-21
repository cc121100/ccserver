package org.ccserver.launcher;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioNonBlockingSelectorTest {

	static Selector selector;
    private static ByteBuffer receivebuffer = ByteBuffer.allocate(32);
    
    public static void main(String args[])
        
    {
        try {
			selector = Selector.open();
			SocketAddress address = new InetSocketAddress(10002);
			ServerSocketChannel channel = ServerSocketChannel.open();
			channel.socket().bind(address);
			channel.configureBlocking(false);
			channel.register(selector, SelectionKey.OP_ACCEPT);
			
			while(true)
			{
				selector.select();
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {          
					SelectionKey selectionKey = iterator.next();  
					iterator.remove();  
					handleKey(selectionKey);  
				}  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    private static void handleKey(SelectionKey selectionKey) throws IOException
    {
        ServerSocketChannel server = null;
        SocketChannel client = null;
        if(selectionKey.isAcceptable())
        {
            server = (ServerSocketChannel)selectionKey.channel();
            client = server.accept();
            System.out.println("客户端： " + client.socket().getRemoteSocketAddress().toString());
            client.configureBlocking(false);
            client.register(selector, SelectionKey.OP_READ);
        }
        if(selectionKey.isReadable())
        {
            client = (SocketChannel)selectionKey.channel();
            receivebuffer.clear();  
            int count = client.read(receivebuffer);   
            //System.out.println("服务器端接受客户端数据--:");  
            if (count > 0) {  
                String receiveText = new String( receivebuffer.array(),0,count);  
                System.out.print(receiveText);  
                client.register(selector, SelectionKey.OP_READ);  
            }
        }
    }
}
