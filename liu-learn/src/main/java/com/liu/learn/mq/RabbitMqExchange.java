package com.liu.learn.mq;
/**
 * 交换机配置
 * 
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
public interface RabbitMqExchange {
	/** 扇形交换机  */
	final String CONTRACT_FANOUT = "CONTRACT_FANOUT";  
    /** 匹配符交换机  */
	final String CONTRACT_TOPIC = "CONTRACT_TOPIC";  
    /** 定向交换机  */
	final String CONTRACT_DIRECT = "CONTRACT_DIRECT";  
}
