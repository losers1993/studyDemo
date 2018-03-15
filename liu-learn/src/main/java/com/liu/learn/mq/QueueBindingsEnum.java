package com.liu.learn.mq;
/**
 * 绑定实例
 * 
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
public enum QueueBindingsEnum implements QueueBindings{
	CONTRACT_FANOUT_SELF(RabbitMqExchange.CONTRACT_FANOUT, RabbitMqQueue.CONTRACE_SELF),
	CONTRACT_FANOUT_TENANT(RabbitMqExchange.CONTRACT_FANOUT, RabbitMqQueue.CONTRACE_TENANT),
	CONTRACT_TOPIC_SELF(RabbitMqExchange.CONTRACT_TOPIC, RabbitMqQueue.CONTRACE_SELF),
	CONTRACT_TOPIC_TENANT(RabbitMqExchange.CONTRACT_TOPIC, RabbitMqQueue.CONTRACE_TENANT),
	CONTRACT_DIRECT_SELF(RabbitMqExchange.CONTRACT_DIRECT, RabbitMqQueue.CONTRACE_SELF),
	CONTRACT_DIRECT_TENANT(RabbitMqExchange.CONTRACT_DIRECT, RabbitMqQueue.CONTRACE_TENANT);

	private QueueBindingsEnum(String exchange, String routingKey) {
		this.exchange = exchange;
		this.routingKey = routingKey;
	}

	private String exchange;
	private String routingKey;
	
	@Override
	public String getExchange() {
		return exchange;
	}

	@Override
	public String getRoutingKey() {
		return routingKey;
	}

}
