/**
 * 
 */
package com.liu.learn.jdk8.chap5;

import java.awt.Menu;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * 
 * @author liuyq
 * @version 1.0,2018年1月11日
 */
public class StreamMapping {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*System.out.println(Dish.menu.stream()
			.map(Dish :: getName)
			.collect(Collectors.toList()));
		
		List<String> hello = Arrays.asList("Hello", "World");
		hello.stream()
			.map(s -> s.split(""))
			.flatMap(Arrays :: stream)
			.distinct()
			.forEach(System.out :: println);
		
		List<Integer> number1 = Arrays.asList(1,2,3);
		List<Integer> number2 = Arrays.asList(3,4);
		List<int[]> list = number1.stream()
			.flatMap(i -> number2.stream()
					.map(j -> new int[] {i,j}))
			.collect(Collectors.toList());*/
		
		Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
            new Transaction(brian, 2011, 300), 
            new Transaction(raoul, 2012, 1000),
            new Transaction(raoul, 2011, 400),
            new Transaction(mario, 2012, 710),	
            new Transaction(mario, 2012, 700),
            new Transaction(alan, 2012, 950)
        );	
		
		System.out.println(transactions.stream()
			.map(al -> al.getTrader().getCity())
			.collect(Collectors.joining(",")));
		
		//1.查询2011年发生的所有交易,并按交易额排序(低到高)
		System.out.println("查询2011年发生的所有交易,并按交易额排序(低到高)");
		transactions.stream()
			.filter(trans2011 -> trans2011.getValue() == 1000 || trans2011.getValue() == 400)
			.sorted(Comparator.comparing(Transaction :: getValue))
			.forEach(System.out :: println);
		
		//2.交易员都在哪些不同的城市工作过
		System.out.println("交易员都在哪些不同的城市工作过");
		transactions.stream()
			.map(Transaction :: getTrader)
			.map(Trader :: getCity)
			.distinct()
			.forEach(System.out :: println);
		
		//3.查找所有来自剑桥的交易员,并按姓名排序
		System.out.println("查找所有来自剑桥的交易员,并按姓名排序");
		transactions.stream()
			.map(Transaction :: getTrader)
			.distinct()
			.filter(traderCambridge -> "Cambridge".equals(traderCambridge.getCity()))
			.sorted(Comparator.comparing(Trader :: getName))
			.forEach(System.out :: println);
		
		//4.返回所有交易员的姓名字符串,按字母顺序排序
		System.out.println("返回所有交易员的姓名字符串,按字母顺序排序");
		System.out.println(transactions.stream()
			.map(transactionss -> transactionss.getTrader().getName())
			.distinct()
			.sorted()
			.reduce("", (a, b) -> a + b));
		
		//5.有没有交易员是在米兰工作的
		System.out.println("有没有交易员是在米兰工作的");
		System.out.println(transactions.stream()
			.map(Transaction :: getTrader)
			.distinct()
			.anyMatch(traderMilan -> "Milan".equals(traderMilan.getCity())));
		
		//6.打印生活在剑桥的交易员的所有交易额
		System.out.println("打印生活在剑桥的交易员的所有交易额");
		transactions.stream()
			.filter(transactionss -> transactionss.getTrader().getCity().equals("Cambridge"))
			.map(Transaction :: getValue)
			.forEach(System.out :: println);
		
		//7.所有交易中最高的交易额是多少
		System.out.println("所有交易中最高的交易额是多少");
		System.out.println(transactions.stream()
			.map(Transaction :: getValue)
			.reduce(Integer :: max));
		
		//8.找到交易额最小的交易
		System.out.println("找到交易额最小的交易");
		transactions.stream()
			.sorted(Comparator.comparing(Transaction :: getValue))
			.limit(1)
			.forEach(System.out :: println);
	}

}
