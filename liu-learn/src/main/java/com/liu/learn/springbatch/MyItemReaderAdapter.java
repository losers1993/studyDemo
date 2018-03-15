/**
 * 
 */
package com.liu.learn.springbatch;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年1月24日
 */
@Component
public class MyItemReaderAdapter implements InitializingBean{
	private List<Integer> params;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		this.params = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}

	public Integer nextParams() {
		if(params.size() > 0) {
			return params.remove(0);
		}
		return null;
	}
}
