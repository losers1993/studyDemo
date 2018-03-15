package com.liu.learn.springboot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("dev")
public class ProfilesDBConnectorDev implements ProfilesDBConnector{
	
	public ProfilesDBConnectorDev() {
		System.out.println("执行构造方法");
	}
	
	public void init() {
		System.out.println("构造方法执行完之后");
	}
	
	@Override
	public void showDB() {
		System.out.println("dev");
	}
	
	public void destory() {
		System.out.println("bean销毁之前执行");
	}
}
