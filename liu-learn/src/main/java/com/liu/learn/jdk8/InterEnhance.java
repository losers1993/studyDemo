/**
 * 
 */
package com.liu.learn.jdk8;

/**
 * jdk1.8接口增强
 * @author liuyq
 * @version 1.0,2017年12月19日
 */
public interface InterEnhance {
	double calculate(int a);    
	default double sqrt(int a) {
		return Math.sqrt(a);
	}
	static int positive(int a) {
		return a > 0 ? a : 0;
	}
}
