/**
 * 
 */
package com.liu.learn.thread.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年3月14日
 */
public class ThreadScheduleExecutor {
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
		/*executorService.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println(System.currentTimeMillis()/1000 + "在任务开始之前执行");
			}
		}, 0, 8, TimeUnit.SECONDS);*/
		
		executorService.scheduleWithFixedDelay(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(System.currentTimeMillis()/1000 + "在任务完成之后执行");
			}
		}, 0, 8, TimeUnit.SECONDS);
		
	}
}
