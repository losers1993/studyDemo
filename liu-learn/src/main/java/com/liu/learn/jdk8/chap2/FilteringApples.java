package com.liu.learn.jdk8.chap2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;


public class FilteringApples {
	public static void main(String ... args){
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"), new Apple(155, "green"), new Apple(120, "red"));	
		
		System.out.println(filter(inventory, new AppleWeightPredicate()));
		System.out.println(filter(inventory, new AppleColorPredicate()));
		System.out.println(filter(inventory, new AppleRedAndHeavyPredicate()));
		
		/**
		 * 自定义
		 */
		List<Apple> list = filter(inventory, new ApplePredicate() { //当前类实例只是用一次,使用匿名类更为合理
			@Override
			public boolean test(Apple apple) {
				return "red".equals(apple.getColor()) 
						&& apple.getWeight() < 150; 
			}
			
		});
		System.out.println(list.toString());
		
		filterFormatter(inventory, new AppleFancyFormatter());
		filterFormatter(inventory, new AppleSimpleFormatter());
		
		/**
		 * filterAbstract抽象后,适用各种情况
		 */
		List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(filterAbstract(intList, (Integer i) -> i % 2 == 0));
		
		/**
		 * 真实案例
		 
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("hello lambda");
			}
		});
		thread.start();
		*/
		Thread thread = new Thread(() -> System.out.println("hello lambda"));
		thread.start();
	}
	
	public static class Apple {
		private int weight = 0;
		private String color = "";

		public Apple(int weight, String color){
			this.weight = weight;
			this.color = color;
		}

		public Integer getWeight() {
			return weight;
		}

		public void setWeight(Integer weight) {
			this.weight = weight;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}

		public String toString() {
			return "Apple{" +
					"color='" + color + '\'' +
					", weight=" + weight +
					'}';
		}
	}
	
	public static List<Apple> filter(List<Apple> inventory, ApplePredicate p){
		List<Apple> result = new ArrayList<>();
		for(Apple apple : inventory){
			if(p.test(apple)){
				result.add(apple);
			}
		}
		return result;
	} 
	
	/**
	 * List抽象化,filter加强版
	 * @param <T>
	 * @param inventory
	 * @param p
	 */
	public static <T> List<T> filterAbstract(List<T> inventory, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for(T t : inventory) {
			if(p.test(t)) {
				result.add(t);
			}
		}
		return result;
	}
	
	public static void filterFormatter(List<Apple> inventory, AppleFormatter p){
		for(Apple apple : inventory){
			System.out.println(p.accept(apple));
		}
	} 
	
	interface ApplePredicate {
		boolean test(Apple apple);
	}
	
	static class AppleWeightPredicate implements ApplePredicate{
		@Override
		public boolean test(Apple apple) {
			return apple.getWeight() > 150; 
		}
	}
	
	static class AppleColorPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "green".equals(apple.getColor());
		}
	}

	static class AppleRedAndHeavyPredicate implements ApplePredicate{
		public boolean test(Apple apple){
			return "red".equals(apple.getColor()) 
					&& apple.getWeight() > 150; 
		}
	}
	
	interface AppleFormatter {
		String accept(Apple apple);
	}
	
	static class AppleFancyFormatter implements AppleFormatter {
		@Override
		public String accept(Apple apple) {
			String s = apple.getWeight() > 150 ? "weight" : "light";
			return "A " + s + " " + apple.getColor() + " apple";
		}
	}
	
	static class AppleSimpleFormatter implements AppleFormatter {
		@Override
		public String accept(Apple apple) {
			return "An apple of " + apple.getWeight() + "g";
		}
	}
}
