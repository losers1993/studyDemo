package com.liu.learn.springboot.event;

import org.springframework.context.ApplicationEvent;
/**
 * spring事件
 * 
 * @author liuyq
 * @version 1.0,2017年9月8日
 */
public class DemoEvent extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String msg;

	public DemoEvent(Object source, String msg) {
		super(source);
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	

}
