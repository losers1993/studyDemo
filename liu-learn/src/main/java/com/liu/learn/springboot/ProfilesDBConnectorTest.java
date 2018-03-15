package com.liu.learn.springboot;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("test")
public class ProfilesDBConnectorTest implements ProfilesDBConnector{

	@Override
	public void showDB() {
		System.out.println("test");
	}

}
