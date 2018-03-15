package com.liu.learn.springboot.event;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
/**
 * spring事件监听类
 * 
 * @author liuyq
 * @version 1.0,2017年9月8日
 */
@Component
public class DemoEventListener implements ApplicationListener<DemoEvent>{

	@Override
	public void onApplicationEvent(DemoEvent event) {
		System.out.println("我监听到了DemoEvent事件:"+event.getMsg());
	}

}
