/**
 * 
 */
package com.liu.learn.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.TimeUnit;

import org.apache.tomcat.util.threads.ThreadPoolExecutor;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年3月14日
 */
public class RejectThreadPool implements Runnable{
	private String name;
	
	public RejectThreadPool(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		System.out.println(System.currentTimeMillis()/1000 + Thread.currentThread().getName());
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("CPU : " + Runtime.getRuntime().availableProcessors());;
		RejectThreadPool task = new RejectThreadPool("my thread");
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5,
				5,
				0,
				TimeUnit.MILLISECONDS,
				new LinkedBlockingQueue<Runnable>(10),
				Executors.defaultThreadFactory(),
				new RejectedExecutionHandler() {
					@Override
					public void rejectedExecution(Runnable arg0, java.util.concurrent.ThreadPoolExecutor arg1) {
						System.out.println(arg0.toString() + "is failed");
					}
				}) {

					@Override
					protected void afterExecute(Runnable r, Throwable t) {
						System.out.println(Thread.currentThread().getName() + "执行完毕!");
					}

					@Override
					protected void beforeExecute(Thread t, Runnable r) {
						System.out.println(Thread.currentThread().getName() + "准备执行!");
					}

					@Override
					protected void terminated() {
						System.out.println("线程池退出!");
					}
			
		};
		
		for(int i=0; i<10; i++) {
			executor.execute(task);;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		executor.shutdown();
	}

}
