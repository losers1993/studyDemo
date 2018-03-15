/**
 * 
 */
package com.liu.learn.thread.writereadlock;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.ReadLock;
import java.util.concurrent.locks.ReentrantReadWriteLock.WriteLock;

/**
 * 读写锁
 * <font color='red'>
 	读读:非阻塞,读写:阻塞,写写:阻塞,写读:阻塞, ReentrantLock(均阻塞)
 * </font>
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class ReadWriteLockDemo {
	private static ReentrantLock lock = new ReentrantLock();
	private static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private static Lock readLock = readWriteLock.readLock();
	private static Lock writeLock = readWriteLock.writeLock();
	private int value;
	
	public Object handleRead(Lock lock) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(10000);
			System.out.println("read value = " + value);
			return value;
		} finally {
			lock.unlock();
		}
	}
	
	public void handeWrite(Lock lock, int i) throws InterruptedException {
		try {
			lock.lock();
			Thread.sleep(10000);
			value = i;
			System.out.println("write value = " + value);
		} finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		final ReadWriteLockDemo lockDemo = new ReadWriteLockDemo();
		Runnable read = new Runnable() {
			@Override
			public void run() {
				try {
					//lockDemo.handleRead(readLock);
					lockDemo.handleRead(lock);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		Runnable write = new Runnable() {
			@Override
			public void run() {
				try {
					//lockDemo.handeWrite(writeLock, new Random().nextInt());
					lockDemo.handeWrite(lock, new Random().nextInt());
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		
		for(int i = 0; i < 18; i++) {
			new Thread(read).start();
		}
		
		for(int i = 18; i < 20; i++) {
			new Thread(write).start();
		}
	}
}
