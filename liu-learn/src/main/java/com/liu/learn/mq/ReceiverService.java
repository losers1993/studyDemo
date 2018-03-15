package com.liu.learn.mq;

import java.io.IOException;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class ReceiverService {
	@RabbitListener(queues = RabbitMqQueue.CONTRACE_SELF)  
    @RabbitHandler  
    public void receiveContractQueue(SelfRabbitMq contract) {  
        ObjectMapper objectMapper=new ObjectMapper();  
        try {  
            System.out.println("Received contract<" + objectMapper.writeValueAsString(contract) + ">");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
	
	@RabbitListener(queues = RabbitMqQueue.CONTRACE_SELF)  
    @RabbitHandler  //配合rabbitListener接收不同入参类型的消息使用不同的方法来处理。
    public void receiveContractQueueString(String msg) {  
        ObjectMapper objectMapper=new ObjectMapper();  
        try {  
            System.out.println("Received contract<" + objectMapper.writeValueAsString(msg) + ">");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    }
  
    @RabbitListener(queues = RabbitMqQueue.CONTRACE_TENANT)  
    public void receiveTenantQueue(TenantRabbitMq tenant) {  
        ObjectMapper objectMapper=new ObjectMapper();  
        try {  
            System.out.println("Received contract<" + objectMapper.writeValueAsString(tenant) + ">");  
        } catch (IOException e) {  
            e.printStackTrace();  
        }  
    } 
}
