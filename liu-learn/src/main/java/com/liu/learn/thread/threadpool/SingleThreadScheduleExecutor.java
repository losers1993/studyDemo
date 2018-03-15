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
public class SingleThreadScheduleExecutor{
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
		
		executorService.schedule(new Runnable() {
			@Override
			public void run() {
				System.out.println("线程池一次性调度任务");
			}
		}, 3, TimeUnit.SECONDS);
	}
}
