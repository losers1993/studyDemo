package com.liu.learn.springboot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * spring事件发布类
 * 
 * @author liuyq
 * @version 1.0,2017年9月8日
 */
@Component
public class DemoEventPublish {

	@Autowired
	private ApplicationContext applicationContext;
	
	public void eventPublish(String msg) {
		applicationContext.publishEvent(new DemoEvent(this, msg));
	}

}
