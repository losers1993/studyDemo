/**
 * 
 */
package com.liu.learn.thread.reenterlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁(可完全替代synchronized同步块关键字)
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class ReenterLock implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();
	public static int i = 0;
	
	@Override
	public void run() {
		for(int j = 0; j < 10000; j++) {
			lock.lock();
			try {
				i++;
			} finally {
				//必须释放锁,否则会造成后面的线程等待
				lock.unlock();
			}
			
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ReenterLock t1 = new ReenterLock();
		Thread thread1 = new Thread(t1);
		Thread thread2 = new Thread(t1);
		thread1.start();
		thread2.start();
		thread1.join();
		thread1.join();
		System.out.println(i);
	}

}
