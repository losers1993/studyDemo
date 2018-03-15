package com.liu.learn.spring.quartz;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

/**
 * 轮循任务配置类
 * 
 * @author liuyq
 * @version 1.0,2017年11月21日
 */
@Configuration
@ConfigurationProperties
@PropertySource("classpath:scheduler-task.properties")
public class QuartzFactory {
	/**
	 * 轮循任务cron表达式
	 */
	@Value("${scheduler.task.cron}")
	private String cronExpression;
	
	/**
	 * 1.配置JobDeatilFactory
	 */
	@Bean
	public MethodInvokingJobDetailFactoryBean getJobDetailFactory() {
		System.out.println("cronExpression = " + cronExpression);
		MethodInvokingJobDetailFactoryBean factoryBean = new MethodInvokingJobDetailFactoryBean();
		factoryBean.setTargetBeanName("quartzExecuteService"); //任务执行类
		factoryBean.setTargetMethod("execute"); //任务执行方法
		factoryBean.setConcurrent(false); //设置任务为串行 
		return factoryBean;
	}
	
	/**
	 * 2.配置CronTriggerFactory
	 */
	@Bean
	public CronTriggerFactoryBean getCronTriggerFactory() {
		CronTriggerFactoryBean factoryBean = new CronTriggerFactoryBean();
		factoryBean.setStartDelay(2000);
		factoryBean.setJobDetail(getJobDetailFactory().getObject());
		factoryBean.setCronExpression(cronExpression);
		return factoryBean;
	}
	
	/**
	 * 3.配置SchedulerFactory
	 */
	@Bean
	public SchedulerFactoryBean getSchedulerFactory() {
		SchedulerFactoryBean factoryBean = new SchedulerFactoryBean();
		factoryBean.setTriggers(getCronTriggerFactory().getObject());
		return factoryBean;
	}
}
