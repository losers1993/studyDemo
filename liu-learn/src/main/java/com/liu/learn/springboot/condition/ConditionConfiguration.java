package com.liu.learn.springboot.condition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConditionConfiguration {
	
	@Bean
	@Conditional(WindowsCondition.class)
	public ListService getBeanWindowsListService                                                                                                                                                                                                                                                                                                                                                                                                                                                      () {
		return new WindowsListService();
	}
	
	@Bean
	@Conditional(LinuxCondition.class)
	public ListService getBeanLinuxListService() {
		return new LinuxListService();
	}
}
