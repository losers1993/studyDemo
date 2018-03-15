package com.liu.learn.jdk8.chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.liu.learn.jdk8.chap1.FilteringApples.Apple;

/**
 * AppleComparator使用匿名类实现
 * 
 * @author liuyq
 * @version 1.0,2018年1月10日
 */
public class AppleComparatorAnonymous {
	public static void main(String...arg1) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));	
		
		inventory.sort(new Comparator<Apple>() {
			@Override
			public int compare(Apple arg0, Apple arg1) {
				return arg0.getWeight().compareTo(arg1.getWeight());
			}
		});
		
		System.out.println(inventory.toString());
	}
}
