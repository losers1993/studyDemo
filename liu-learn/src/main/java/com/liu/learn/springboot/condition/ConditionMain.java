package com.liu.learn.springboot.condition;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionMain {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConditionConfiguration.class);
		
		ListService listService = (ListService) context.getBean(ListService.class);
		
		listService.showListCmd();
		
		context.close();
	}
}
