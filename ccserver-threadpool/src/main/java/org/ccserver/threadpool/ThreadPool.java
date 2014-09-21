package org.ccserver.threadpool;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPool extends ThreadPoolExecutor{

	private static ThreadPool threadPool;
	
	private ThreadPool(){
		
		//TODO load thread pool init parameter from xml
		super(5,10, 5, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>());
	
	}
	
	public static ThreadPool newInstance(){
		if(threadPool == null){
			synchronized (threadPool) {
				if(threadPool == null){
					threadPool = new ThreadPool();
				}
			}
		}
		return threadPool;
	}
	
	
	
}
