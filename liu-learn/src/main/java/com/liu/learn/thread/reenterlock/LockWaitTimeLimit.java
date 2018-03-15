/**
 * 
 */
package com.liu.learn.thread.reenterlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁 锁申请等待限时 tryLock
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class LockWaitTimeLimit implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();
	
	@Override
	public void run() {
		try {
			if(lock.tryLock(5, TimeUnit.SECONDS)) {
				System.out.println(Thread.currentThread().getName() + "获得锁资源");
				Thread.sleep(6000);
			} else {
				System.out.println(Thread.currentThread().getName() + "get lock failed");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			if(lock.isHeldByCurrentThread()) {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		LockWaitTimeLimit lt = new LockWaitTimeLimit();
		Thread t1 = new Thread(lt);
		Thread t2 = new Thread(lt);
		t1.start();
		t2.start();
	}
}
