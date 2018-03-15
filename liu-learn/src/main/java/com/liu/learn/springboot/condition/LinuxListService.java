package com.liu.learn.springboot.condition;

import org.springframework.stereotype.Service;

@Service
public class LinuxListService implements ListService{

	@Override
	public void showListCmd() {
		System.out.println("Linux");
	}

}
