package com.liu.learn.mq;

import java.util.Objects;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
/**
 * 封装MQ发布方法
 * 
 * @author liuyq
 * @version 1.0,2017年11月2日
 */
@Component
public class MQGateway {
	private static RabbitTemplate rabbitTemplate;
	
	@Autowired
	private void bindings(@PathVariable("rabbitTemplate") RabbitTemplate rabbitTemplate) {
		MQGateway.rabbitTemplate = rabbitTemplate;
	}
	
	public static RabbitTemplate getRabbitTemplate() {
		return rabbitTemplate;
	}
	

	private static void bindingsNonNull(QueueBindings bindings) {
		Objects.requireNonNull(bindings, "bindings is null");
		Objects.requireNonNull(bindings.getExchange(), "exchange is null");
		Objects.requireNonNull(bindings.getRoutingKey(), "routingKey is null");
	}
	
	public static void sendMessage(QueueBindings bindings, Object message) {
		bindingsNonNull(bindings);
		
		sendMessage(bindings.getExchange(), bindings.getRoutingKey(), message);
	}
	
	public static void sendMessage(String exchange, String routingKey, Object message) {
		
		sendMessage(rabbitTemplate, exchange, routingKey, message);
	}
	
	public static void sendMessage(RabbitTemplate rabbitTemplate, String exchange, String routingKey, Object message) {
	    Objects.requireNonNull(rabbitTemplate, "template must be not null.");
	    Objects.requireNonNull(message, "message must be not null.");
		
		rabbitTemplate.convertAndSend(exchange, routingKey, message);
	}
}
