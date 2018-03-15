/**
 * 
 */
package com.liu.learn.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年3月14日
 */
public class SingleThreadExecutor implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(5000);
			System.out.println(System.currentTimeMillis() + Thread.currentThread().getName());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newSingleThreadExecutor();
		
		for(int i=0; i<5; i++) {
			executorService.execute(new FixedThreadPool());
		}
	}

}
