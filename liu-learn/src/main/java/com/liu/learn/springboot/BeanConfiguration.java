package com.liu.learn.springboot;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.liu.learn")
public class BeanConfiguration {
	@Bean(initMethod="init",destroyMethod="destory")
	public ProfilesDBConnectorDev beanProfilesDBConnector() {
		return new ProfilesDBConnectorDev();
	}
}
