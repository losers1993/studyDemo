/**
 * 
 */
package com.liu.learn.thread.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 搭档重入锁 类似于Object.wait, Object.notify
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class ReenterLockCondition implements Runnable{
	public static ReentrantLock lock = new ReentrantLock();
	public static Condition condition = lock.newCondition();

	@Override
	public void run() {
		try {
			lock.lock();
			condition.await();
			System.out.println("Thread is going on");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ReenterLockCondition l = new ReenterLockCondition();
		Thread t1 = new Thread(l);
		t1.start();
		Thread.sleep(2000);
		lock.lock();
		//通知线程继续执行
		condition.signal();
		//通知等待线程继续执行,但不释放当前线程锁,也无法继续执行
		lock.unlock();
	}
}
