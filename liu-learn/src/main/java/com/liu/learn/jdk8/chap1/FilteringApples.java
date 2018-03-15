/**
 * 
 */
package com.liu.learn.jdk8.chap1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 
 * @author liuyq
 * @version 1.0,2017年12月28日
 */
public class FilteringApples {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));	
		
		/**
		 * 使用方法传递值
		 */
		List<Apple> greenApples = filterApples(inventory, FilteringApples :: isGreenApple);
		System.out.println(greenApples.toString());
		
		List<Apple> heavyApples = filterApples(inventory, FilteringApples :: isHeavyApple);
		System.out.println(heavyApples.toString());
		
		/**
		 * 使用Lambda传递值
		 */
		List<Apple> greenApplesLambda = filterApples(inventory, (Apple a) -> "green".equals(a.getColor()));
		System.out.println(greenApplesLambda.toString());
		
		List<Apple> heavyApplesLambda = filterApples(inventory, (Apple a) -> a.getWeight() > 150);
		System.out.println(heavyApplesLambda.toString());
		
		System.out.println(filterApples(inventory, (Apple a) -> a.getWeight() < 150 && "red".equals(a.getColor())));
		
		/**
		 * 使用流
		 */
	}
	
	public static List<Apple> filterGreenApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if ("green".equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
	}
	
	public static List<Apple> filterHeavyApples(List<Apple> inventory) {
		List<Apple> result = new ArrayList<>();
        for (Apple apple: inventory){
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
	}
	
	public static boolean isGreenApple(Apple apple) {
		return "green".equals(apple.getColor());
	}
	
	public static boolean isHeavyApple(Apple apple) {
		return apple.getWeight() > 150;
	}
	
	public static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple: inventory){
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
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
}
