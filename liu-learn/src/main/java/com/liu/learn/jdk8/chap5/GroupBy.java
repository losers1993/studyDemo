package com.liu.learn.jdk8.chap5;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupBy {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Dish.Type, List<Dish>> map = Dish.menu.stream()
			.collect(Collectors.groupingBy(Dish :: getType));
		
		System.out.println(map.toString());
	}
}
