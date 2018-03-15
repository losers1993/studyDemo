package com.liu.learn.mq;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Test {
    @Autowired
    RabbitTemplate rabbitTemplate;
    @Autowired
	private RabbitMq rabbitMq;

    @RequestMapping(value = "/test/{abc}",method = RequestMethod.GET)
    private String test(@PathVariable(value = "abc") String abc){
    	System.out.println("exchange = " + rabbitTemplate.getExchange() + "queue = " + rabbitTemplate.getRoutingKey());
        rabbitTemplate.convertAndSend("exchange-1", "spring-boot", abc + " from RabbitMQ!" + rabbitTemplate.getExchange());
        return  "abc";
    }
    
    @RequestMapping(value = "contract/topic",method = {RequestMethod.POST,RequestMethod.GET})  
    private void test1() {
    	SelfRabbitMq selfRabbitMq = new SelfRabbitMq();
    	selfRabbitMq.setId("15");  
    	selfRabbitMq.setName("测试"); 
    	List<String> list = new ArrayList<>();
    	list.add("111");
    	list.add("222");
    	selfRabbitMq.setTestList(list);  
    	selfRabbitMq.setCreateDate(new Date());  
    	MQGateway.sendMessage(QueueBindingsEnum.CONTRACT_TOPIC_SELF, "@RabbitHandler");
    }
    
    /**
     * java使用mq
     */
    @RequestMapping(value = "hello/mq/{aa}",method = {RequestMethod.POST,RequestMethod.GET})  
    private void simpleMQ(@PathVariable(value = "aa") String aa) {
    	CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
    	AmqpAdmin admin = new RabbitAdmin(connectionFactory);
    	//admin.declareExchange(exchange); //可以不使用,MQ会自动绑定默认的exchange
    	admin.declareQueue(new Queue("ofo"));
    	AmqpTemplate template = new RabbitTemplate(connectionFactory);
    	template.convertAndSend("ofo", "hello mq" + aa);
    	String message = (String) template.receiveAndConvert("ofo");
    	System.out.println("------------------------" + message);
    }
}