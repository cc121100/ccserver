package org.ccserver.launcher.factory;

import org.ccserver.resource.CCServer;
import org.ccserver.resource.IOPattern;
import org.ccserver.serversocket.CCServerSocket;
import org.ccserver.serversocket.NIOCCServerSocket;

public class CCServerFactory {

	public CCServerSocket generate(CCServer ccs){
		CCServerSocket ccss = null;
		
		IOPattern ioPattern = ccs.getCcsConstants().getIoPattern();
		
		switch (ioPattern) {
		case BIO:
			break;
		case NIO:
			ccss =  new NIOCCServerSocket(ccs);
			break;
		case AIO:
			break;

		default:
			break;
		}
		return ccss;
	}
}
