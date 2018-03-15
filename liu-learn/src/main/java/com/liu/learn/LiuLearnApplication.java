package com.liu.learn;

import java.io.File;
import java.util.Set;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobException;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.liu.learn.springboot.springaware.AwareService;
/**
 * 创建项目启动入口
 * 
 * @author liuyq
 * @version 1.0,2017年9月7日
 */
@SpringBootApplication //设置为项目启动入口
public class LiuLearnApplication {
	
	@Autowired
	static
    JobLauncher getJobLauncher;

    @Autowired
	static
    Job getJob;
    
    @Autowired
	static
	JobOperator jobOperator;
	
	public static void main(String[] args) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
		ConfigurableApplicationContext context = SpringApplication.run(LiuLearnApplication.class, args);
		
		//AwareService awareService = (AwareService) context.getBean("awareService");
		
		//System.out.println("bean name : " + awareService.getBeanName());
		
		getJobLauncher.run(getJob, null);
		
		
		try {
			Set<Long> jobList = jobOperator.getRunningExecutions(getJob.getName());
			
			while(jobList.iterator().hasNext()) {
				System.out.println(jobList.iterator().next() + "," + jobOperator.stop(jobList.iterator().next()));
			}
		} catch (NoSuchJobExecutionException | JobExecutionNotRunningException | NoSuchJobException e) {
			e.printStackTrace();
		}
	}
}
