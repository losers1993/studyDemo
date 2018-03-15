package com.liu.learn.springboot.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class DemoEventController {
	@Autowired
	private DemoEventPublish demoEventPublish;
	
	@RequestMapping("/test")
	public void test() {
		demoEventPublish.eventPublish("今晚吃鸡");
	}
}
