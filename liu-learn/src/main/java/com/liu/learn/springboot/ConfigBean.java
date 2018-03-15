package com.liu.learn.springboot;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="liu.springboot")
public class ConfigBean {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
