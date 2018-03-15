/**
 * 
 */
package com.liu.learn.springbatch;

import java.util.Collection;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 定义自己的任务拦截器
 * @author liuyq
 * @version 1.0,2018年1月19日
 */
public class MyJobExecutionListener implements JobExecutionListener,StepExecutionListener{
	@Override
	public void beforeJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getId() + "任务执行之前");
	}

	@Override
	public void afterJob(JobExecution jobExecution) {
		System.out.println(jobExecution.getId() + "任务执行之后");
	}

	@Override
	public void beforeStep(StepExecution stepExecution) {
		stepExecution.setTerminateOnly();
		System.out.println(stepExecution.getStepName() + "任务步执行之前" + stepExecution.getFilterCount());
	}

	@Override
	public ExitStatus afterStep(StepExecution stepExecution) {
		System.out.println(stepExecution.getStepName() + "任务步执行之后" + stepExecution.getFilterCount());
		return ExitStatus.STOPPED;
	}

}
