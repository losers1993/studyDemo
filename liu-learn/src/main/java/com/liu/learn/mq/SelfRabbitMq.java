package com.liu.learn.mq;

import java.util.Date;
import java.util.List;

/**
 * 消息载体
 * 
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
public class SelfRabbitMq {
	private String id;
	private String name;
	private List<String> testList;
	private Date createDate;
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
	public List<String> getTestList() {
		return testList;
	}
	public void setTestList(List<String> testList) {
		this.testList = testList;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
