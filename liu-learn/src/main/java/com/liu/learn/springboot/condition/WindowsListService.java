package com.liu.learn.springboot.condition;

import org.springframework.stereotype.Service;

@Service
public class WindowsListService implements ListService{

	@Override
	public void showListCmd() {
		System.out.println("Windows");
	}

}
