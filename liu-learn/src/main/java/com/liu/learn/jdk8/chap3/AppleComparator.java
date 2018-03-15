package com.liu.learn.jdk8.chap3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.liu.learn.jdk8.chap1.FilteringApples.Apple;

public class AppleComparator implements Comparator<Apple>{
	
	public static void main(String...arg1) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));	
		
		inventory.sort(new AppleComparator());
		
		System.out.println(inventory.toString());
	}

	@Override
	public int compare(Apple arg0, Apple arg1) {
		return arg0.getWeight().compareTo(arg1.getWeight());
	}

}
