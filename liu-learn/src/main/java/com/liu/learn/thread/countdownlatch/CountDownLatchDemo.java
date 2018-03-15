package com.liu.learn.thread.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时器(CountDownLatch)
 * @author liuyq
 * @version 1.0,2018年3月7日
 */
public class CountDownLatchDemo implements Runnable{
	public static CountDownLatch end = new CountDownLatch(10);
	public static CountDownLatchDemo demo = new CountDownLatchDemo();
	
	@Override
	public void run() {
		try {
			int i = new Random().nextInt(10) * 1000;
			Thread.sleep(i);
			System.out.println("game over");
			end.countDown(); //计时器减一
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		for(int i = 0; i < 10; i++) {
			executorService.submit(demo);
		}
		//等待
		end.await();
		System.out.println("Fire!");
		executorService.shutdown();
	}
}
