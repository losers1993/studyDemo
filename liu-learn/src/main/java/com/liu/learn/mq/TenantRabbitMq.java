package com.liu.learn.mq;
/**
 * Tenant消息载体
 * 
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
public class TenantRabbitMq {
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
