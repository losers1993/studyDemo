/**
 * 
 */
package com.liu.learn.thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 抛出线程池堆栈异常
 * @author liuyq
 * @version 1.0,2018年3月14日
 */
public class ExceptionThreadExecutor extends ThreadPoolExecutor {

	public ExceptionThreadExecutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit,
			BlockingQueue<Runnable> workQueue) {
		super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
	}

	@Override
	public void execute(Runnable task) {
		super.execute(wrap(task, cilentTrace(), Thread.currentThread().getName()));
	}

	@Override
	public Future<?> submit(Runnable task) {
		return super.submit(wrap(task, cilentTrace(), Thread.currentThread().getName()));
	}
	
	private Exception cilentTrace() {
		return new Exception("线程运行异常!");
	}
	
	private Runnable wrap(Runnable task, Exception cilentTrace, String name) {
		return new Runnable() {
			@Override
			public void run() {
				try {
					task.run();
				} catch (Exception e) {
					cilentTrace.printStackTrace();
					throw e;
				}
			}
		};
	}
	
	public class DivTask implements Runnable {
		private int a,b;

		public DivTask(int a, int b) {
			this.a = a;
			this.b = b;
		}


		@Override
		public void run() {
			double c = a/b;
			System.out.println(c);
		}
		
	} 
	
	public static void main(String[] args) {
		ExceptionThreadExecutor executor = new ExceptionThreadExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
		
		/**
		 * 查看错误堆栈
		 */
		for(int i=0; i<5; i++) {
			DivTask dt = executor.new DivTask(100, i);
			executor.execute(dt);
		} 
	}
}
