package com.liu.learn.spring.quartz;

import org.springframework.stereotype.Service;

import com.liu.learn.utils.DateUtil;

@Service
public class QuartzExecuteService {
	public void execute() {
		System.out.println("任务执行类: " + this.getClass().getSimpleName() + "-执行时间: " + DateUtil.nowTimestamp() + "-当前线程: " + Thread.currentThread().getName());
	}
}
