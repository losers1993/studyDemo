/**
 * 
 */
package com.liu.learn.jdk8.chap4;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.liu.learn.jdk8.chap1.FilteringApples.Apple;

/**
 * 
 * @author liuyq
 * @version 1.0,2018年1月11日
 */
public class StreamMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));	
		
		System.out.println(inventory.stream()
			.filter(apple -> "green".equals(apple.getColor()))
			.collect(Collectors.toList()));
		
		
		List<Integer> number = Arrays.asList(1,
                2,
                2,
                3,
                4);	
		/**
		 * 筛选各异元素
		 */
		/*number.stream()
			.filter(num -> num % 2 == 0)
			.distinct()
			.forEach(System.out :: println);*/
		
		/**
		 * 截短流
		 */
		number.stream()
		.filter(num -> num % 2 == 0)
		.limit(2)
		.forEach(System.out :: println);
		
		/**
		 * 跳过元素
		 */
		number.stream()
			.filter(num -> num % 2 == 0)
			.skip(2)
			.forEach(System.out :: println);
	}

}
