/**
 * 
 */
package com.liu.learn.thread.threadpool;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年3月15日
 */
public class ForkJoinTaskDemo extends RecursiveTask<Long>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3460793427180539985L;
	private static final int THRESHOLD = 10000;
	private long start;
	private long end;
	

	public ForkJoinTaskDemo(long start, long end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected Long compute() {
		long sum = 0;
		boolean canCompute = (end - start) < THRESHOLD;
		if(canCompute) {
			for(long i = start; i <= end; i++) {
				sum += i; 
			}
		} else {
			//分成100个小任务
			long step = (start + end) / 100;
			ArrayList<ForkJoinTaskDemo> subTasks = new ArrayList<>();
			long pos = start;
			for(int i = 0; i < 100; i++) {
				long lastOne = pos + step;
				if(lastOne > end) lastOne = end;
				ForkJoinTaskDemo task = new ForkJoinTaskDemo(pos, lastOne);
				pos = step + 1;
				subTasks.add(task);
				task.fork();
			}
			
			for(ForkJoinTaskDemo task : subTasks) {
				sum += task.join();
			}
		}
		
		return sum;
	}
	
	public static void main(String[] args) {
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTaskDemo task = new ForkJoinTaskDemo(0, 20000L);
		ForkJoinTask<Long> result = pool.submit(task);
		
		try {
			System.out.println(result.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
}
