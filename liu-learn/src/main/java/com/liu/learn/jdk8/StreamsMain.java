/**
 * 
 */
package com.liu.learn.jdk8;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.scheduling.config.Task;

/**
 * 
 * @author liuyq
 * @version 1.0,2017年12月20日
 */
public class StreamsMain{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*final Collection<Streams.Task> tasks = Arrays.asList(
				new Streams.Task(Streams.Status.OPEN, 5),
				new Streams.Task(Streams.Status.OPEN, 13),
				new Streams.Task(Streams.Status.CLOSED, 8));
		
		final long totalPointsOfOpenTasks = tasks
				.stream()
				.filter(task -> task.getStatus() == Streams.Status.OPEN)
				.mapToInt(Streams.Task :: getPoints)
				.sum();
		
		System.out.println(totalPointsOfOpenTasks);*/
		
		String str = null;
		System.out.println(Integer.valueOf(str));
		
	}

}
