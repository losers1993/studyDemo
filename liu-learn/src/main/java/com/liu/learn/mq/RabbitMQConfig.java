package com.liu.learn.mq;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;


@Configuration
public class RabbitMQConfig {
	@Autowired
	private RabbitMq rabbitMq;
	
	/**
	 * 连接rabbitmq
	 * @return
	 */
	@Bean
	ConnectionFactory connectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setHost(rabbitMq.getHost());
		connectionFactory.setPort(rabbitMq.getPort());
		connectionFactory.setUsername(rabbitMq.getUsername());
		connectionFactory.setPassword(rabbitMq.getPassword());
		/** 
         * 对于每一个RabbitTemplate只支持一个ReturnCallback。 
         * 对于返回消息，模板的mandatory属性必须被设定为true， 
         * 它同样要求CachingConnectionFactory的publisherReturns属性被设定为true。 
         * 如果客户端通过调用setReturnCallback(ReturnCallback callback)注册了RabbitTemplate.ReturnCallback，那么返回将被发送到客户端。 
         * 这个回调函数必须实现下列方法： 
         *void returnedMessage(Message message, intreplyCode, String replyText,String exchange, String routingKey); 
         */  
       // connectionFactory.setPublisherReturns(true);  
        /** 
         * 同样一个RabbitTemplate只支持一个ConfirmCallback。 
         * 对于发布确认，template要求CachingConnectionFactory的publisherConfirms属性设置为true。 
         * 如果客户端通过setConfirmCallback(ConfirmCallback callback)注册了RabbitTemplate.ConfirmCallback，那么确认消息将被发送到客户端。 
         * 这个回调函数必须实现以下方法： 
         * void confirm(CorrelationData correlationData, booleanack); 
         */  
		connectionFactory.setPublisherConfirms(rabbitMq.getPublisherconfirms());
		return connectionFactory;
	}
	
	/**
	 * rabbitmq代理
	 * exchange,queue自动注册
	 * @param connectionFactory
	 * @return
	 */
	@Bean
	RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
		return new RabbitAdmin(connectionFactory);
	}
	
	/** 
     * 创建rabbitTemplate 消息模板类 
     * prototype原型模式:每次获取Bean的时候会有一个新的实例 
     *  因为要设置回调类，所以应是prototype类型，如果是singleton类型，则回调类为最后一次设置 
     * @return 
     */  
	@Bean
	@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
	RabbitTemplate rabbitTemplate() {
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory());
		 // rabbitTemplate.setMandatory(true);//返回消息必须设置为true  
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());//数据转换为json存入消息队列  
        //  rabbitTemplate.setReplyAddress(replyQueue().getName());  
        //  rabbitTemplate.setReplyTimeout(100000000);  
        //发布确认  
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {  
            //消息发送到queue时就执行  
            @Override  
            public void confirm(CorrelationData correlationData, boolean b, String s) {  
               // log.debug(correlationData+"//////");  
                if (!b){  
                    //log.debug("发送到queue失败");
                	System.out.println("发送到queque失败");
                    throw new RuntimeException("send error " + s);  
                }
                System.out.println("发送确认");
            }  
        });  
        return rabbitTemplate;  
	}
	
	/*
	final static String queueName = "spring-boot";
	
	@Bean
	TopicExchange exchange() {
		return new TopicExchange("exchange");
	}
	
	@Bean
	Queue queue() {
		return new Queue(queueName, false);
	}
	
	@Bean
	Binding	binding(Queue queue, TopicExchange exchange) {
		return BindingBuilder.bind(queue).to(exchange).with(queueName);
	}
	
	@Bean
	SimpleMessageListenerContainer container(ConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    Receiver receiver() {
        return new Receiver();
    }
    
    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }*/
}
