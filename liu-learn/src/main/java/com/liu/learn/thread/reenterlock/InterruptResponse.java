/**
 * 
 */
package com.liu.learn.thread.reenterlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁 中断响应机制
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class InterruptResponse implements Runnable{
	public static ReentrantLock lock1 = new ReentrantLock();
	public static ReentrantLock lock2 = new ReentrantLock();
	int lock;
	
	/**
	 * 控制加锁顺序,方便造成死锁
	 * @param lock
	 */
	public InterruptResponse(int lock) {
		this.lock = lock;
	}
	
	@Override
	public void run() {
		try {
			if(lock == 1) {
				//请求锁1
				System.out.println(Thread.currentThread().getName() + "请求锁1 start");
				lock1.lockInterruptibly();
				System.out.println(Thread.currentThread().getName() + "请求锁1 end");
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + "请求锁2 start");
				lock2.lockInterruptibly();
				System.out.println(Thread.currentThread().getName() + "请求锁2 end");
			} else {
				System.out.println(Thread.currentThread().getName() + "请求锁2 start");
				lock2.lockInterruptibly();
				System.out.println(Thread.currentThread().getName() + "请求锁2 end");
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName() + "请求锁1 start");
				lock1.lockInterruptibly();
				System.out.println(Thread.currentThread().getName() + "请求锁1 end");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			//isHeldByCurrentThread查询当前线程是否保持此锁定 
			if(lock1.isHeldByCurrentThread()) {
				lock1.unlock();
			}
			if(lock2.isHeldByCurrentThread()) {
				lock2.unlock();
			}
			System.out.println(Thread.currentThread().getName() + "退出线程");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		InterruptResponse r1 = new InterruptResponse(1);
		InterruptResponse r2 = new InterruptResponse(2);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
		Thread.sleep(1000);
		//中断t2
		t2.interrupt();
	}
}
