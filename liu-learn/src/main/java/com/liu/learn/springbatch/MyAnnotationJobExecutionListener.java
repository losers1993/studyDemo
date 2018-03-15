/**
 * 
 */
package com.liu.learn.springbatch;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

/**
 * 定义Annotation的拦截器,无需继承JobExecutionListener接口
 * @author liuyq
 * @version 1.0,2018年1月19日
 */
public class MyAnnotationJobExecutionListener {
	@BeforeJob
	public void beforeJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getId() + "Annotation任务执行之前");
	}
	
	@AfterJob
	public void afterJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getId() + "Annotation任务执行之后");
	}
}
