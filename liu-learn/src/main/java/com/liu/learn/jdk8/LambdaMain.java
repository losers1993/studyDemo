package com.liu.learn.jdk8;
/**
 * 函数式编程
 * 
 * @author liuyq
 * @version 1.0,2017年12月19日
 */
public class LambdaMain {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InterEnhance interEnhance = new InterEnhance() {
			
			@Override
			public double calculate(int a) {
				return sqrt(a * 100);
			}
		};
		
		interEnhance.calculate(100);
		interEnhance.sqrt(16);
		InterEnhance.positive(-4);
		System.out.println(interEnhance.calculate(100) + "," + interEnhance.sqrt(16) + "," + InterEnhance.positive(-4));
	}
}
