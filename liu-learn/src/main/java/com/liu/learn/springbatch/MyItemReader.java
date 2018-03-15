/**
 * 
 */
package com.liu.learn.springbatch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.batch.runtime.JobInstance;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.InitializingBean;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年1月17日
 * ItemStream支持reader重启
 */
public class MyItemReader implements ItemReader<Integer>, InitializingBean, ItemStream {
	
	private List<Integer> params = new ArrayList<>();
	private int currentLocation = 0;
	private static final String CURRENT_LOCATION = "current.location";
	
	public MyItemReader() {
		super();
		this.params = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
	}

	@Override
	public Integer read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		//while(i != 10) {
			//i++;
		if(!params.isEmpty()) {
			Integer i = params.get(0);
			this.params = params.subList(1, params.size());
			return i;
		}
		return null;
		//}
		
		//return null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		this.params = Arrays.asList(11,12,13,14,15,16,17,18,19,20);
	}

	/**
	 * 从上下文获取当前位置
	 */
	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		if(executionContext.containsKey(CURRENT_LOCATION)) {
			currentLocation = new Long(executionContext.getLong(CURRENT_LOCATION)).intValue();
		} else {
			currentLocation = 0;
		}
	}

	/**
	 * 将已经读过数据的位置放入上下文中
	 */
	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		executionContext.putLong(CURRENT_LOCATION, new Long(currentLocation).intValue());
	}

	@Override
	public void close() throws ItemStreamException {}

}
