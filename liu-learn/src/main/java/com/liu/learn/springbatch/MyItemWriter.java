/**
 * 
 */
package com.liu.learn.springbatch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年1月17日
 */
public class MyItemWriter implements ItemWriter<String>{
	@Override
	public void write(List<? extends String> items) throws Exception {
		System.out.println("写一次");
		if(null != items)
			items.stream()
			.forEach(System.out :: println);
	}
}
