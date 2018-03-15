/**
 * 
 */
package com.liu.learn.springbatch;


import javax.batch.operations.JobOperator;
import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobOperator;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.adapter.ItemReaderAdapter;
import org.springframework.batch.support.DatabaseType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * spring batch 配置类
 * @author liuyq
 * @version 1.0,2018年1月17日
 */
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
	
	/**
	 * 用来注册job的容器,支持事务管理等
	 * @param dataSource
	 * @param transactionManager
	 * @return
	 * @throws Exception
	 */
	@Bean
	public JobRepository getJobRepository(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
		JobRepositoryFactoryBean factoryBean = new JobRepositoryFactoryBean();
		factoryBean.setDataSource(dataSource);
		factoryBean.setTransactionManager(transactionManager);
		factoryBean.setDatabaseType(DatabaseType.MYSQL.name());
		return factoryBean.getObject();
	}
	
	/**
	 * 用来启动job的接口
	 * @return
	 * @throws Exception 
	 */
	@Bean
	public SimpleJobLauncher getJobLauncher(DataSource dataSource, PlatformTransactionManager transactionManager) throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();
		jobLauncher.setJobRepository(getJobRepository(dataSource, transactionManager));
		return jobLauncher;
	}
	
	@Bean
	public Job getJob(JobBuilderFactory jobBuilderFactory, Step step) {
		return jobBuilderFactory
					.get("getJob")
					.listener(new MyJobExecutionListener())
					.incrementer(new RunIdIncrementer())
					.flow(step)
					.end()
					.build();
	}
	
	@Bean
	public Step getStep1(StepBuilderFactory stepBuilderFactory,
			ItemReader<Integer> reader,
			ItemProcessor<Integer, String> processor,
			ItemWriter<String> writer) {
		return stepBuilderFactory
					.get("getStep1")
					.<Integer, String>chunk(3)
					.reader(reader)
					.processor(processor)
					.writer(writer)
				//	.listener(new MyJobExecutionListener())
					.build();
	}
	
	@Bean
	public ItemReader<Integer> getReader() {
		return new MyItemReader();
	}
	
	@Bean
	public ItemProcessor<Integer, String> getProcessor() {
		return new MyItemProcesser();
	}
	
	@Bean
	public ItemWriter<String> getWriter() {
		return new MyItemWriter();
	}
	
	/*@Bean
	public JobOperator jobOperator() {
		return (JobOperator) new SimpleJobOperator();
	}*/
	
	/*@Bean
	public ItemReader<Integer> getReader() {
		ItemReaderAdapter<Integer> adapter = new ItemReaderAdapter<Integer>();
		adapter.setTargetObject(new MyItemReaderAdapter());
		adapter.setTargetMethod("nextParams");
		return adapter;
	}*/
}

