/**
 * 
 */
package com.liu.learn.springbatch;

import org.springframework.batch.item.ItemProcessor;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年1月17日
 */
public class MyItemProcesser implements ItemProcessor<Integer, String>{

	@Override
	public String process(Integer item) throws Exception {
		if(item % 2 == 0) return null;
		return item + "A";
	}

	

}
