package com.liu.learn.springboot.springaware;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
@Service
public class AwareService implements BeanNameAware{
	
	private String beanName;
	
	public String getBeanName() {
		return beanName;
	}

	@Override
	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
