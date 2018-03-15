package com.liu.learn.mq;

import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

/**
 * 接收方配置
 * 消息的监听代理类
 * @author liuyq
 * @version 1.0,2017年11月1日
 */
@Configuration
@EnableRabbit
public class ConsumerConfig implements RabbitListenerConfigurer{
	
	@Autowired  
    private ConnectionFactory connectionFactory;  
	
	@Bean
	public DefaultMessageHandlerMethodFactory handlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory=new DefaultMessageHandlerMethodFactory();  
		factory.setMessageConverter(new MappingJackson2MessageConverter());
		return factory;
	}
	
	 @Bean  
     public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(){  
        SimpleRabbitListenerContainerFactory factory=new SimpleRabbitListenerContainerFactory();  
        factory.setConnectionFactory(connectionFactory);  
        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);  
        return factory;  
     }  

	@Override
	public void configureRabbitListeners(RabbitListenerEndpointRegistrar registrar) {
		registrar.setMessageHandlerMethodFactory(handlerMethodFactory());
	}

}
