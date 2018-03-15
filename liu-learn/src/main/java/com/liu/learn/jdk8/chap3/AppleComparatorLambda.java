/**
 * 
 */
package com.liu.learn.jdk8.chap3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.liu.learn.jdk8.chap1.FilteringApples.Apple;
import static java.util.Comparator.comparing;

/**
 * AppleComparator使用Lambda表达式实现
 * @author liuyq
 * @version 1.0,2018年1月10日
 */
public class AppleComparatorLambda {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple(80,"green"),
                new Apple(155, "green"),
                new Apple(120, "red"));	
		
		/**
		 * lambda初版
		 */
		//inventory.sort((apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight()));
		
		/**
		 * 继续简化代码
		 */
		//inventory.sort(Comparator.comparing((Apple apple) -> apple.getWeight()));
		
		/**
		 * 静态方法可以直接导入,代码更简洁
		 */
		//inventory.sort(comparing(apple -> apple.getWeight()));
		
		/**
		 * 使用方法引用
		 */
		//inventory.sort(comparing(Apple :: getWeight));
		
		/**
		 * 比较器复合,逆序排序
		 */
		//inventory.sort(comparing(Apple :: getWeight).reversed());
		//System.out.println(inventory.toString());
		
		/**
		 * 谓词复合
		 */
	}

}
