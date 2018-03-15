package com.liu.learn.mq;

import java.util.concurrent.CountDownLatch;
/**
 * 
 * 
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
public class Receiver {
	private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }
}
