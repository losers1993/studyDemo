package com.liu.learn.mq;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 获取mq配置文件
 * 
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
@Component
@ConfigurationProperties(prefix = "spring.rabbitmq")
@PropertySource("classpath:mq.properties")
public class RabbitMq {
	private String host;
	private Integer port;
	private String username;
	private String password;
	private Boolean publisherconfirms;
	
	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getPublisherconfirms() {
		return publisherconfirms;
	}
	public void setPublisherconfirms(Boolean publisherconfirms) {
		this.publisherconfirms = publisherconfirms;
	}
	@Override
	public String toString() {
		return "RabbitMq [host=" + host + ", port=" + port + ", username=" + username + ", password=" + password
				+ ", publisherconfirms=" + publisherconfirms + "]";
	}
	
	
}
