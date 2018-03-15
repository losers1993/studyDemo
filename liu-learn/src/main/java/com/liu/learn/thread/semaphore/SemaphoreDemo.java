/**
 * 
 */
package com.liu.learn.thread.semaphore;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class SemaphoreDemo implements Runnable{
	public static Semaphore semaphore = new Semaphore(5);

	@Override
	public void run() {
		try {
			semaphore.acquire();
			Thread.sleep(2000);
			System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + " done!");
			//释放
			semaphore.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(20);
		SemaphoreDemo demo = new SemaphoreDemo();
		for(int i = 0; i < 20; i++) {
			executor.execute(demo);
		}
	}
}
