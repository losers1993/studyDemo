package com.liu.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {LiuLearnApplication.class,MockServletContext.class})
@WebAppConfiguration
public class RabbitMQTest {
	@Autowired
    RabbitTemplate rabbitTemplate;
	
	@Test
	public void test() {
		 rabbitTemplate.convertAndSend("spring-boot", "test from RabbitMQ!");
	}
	
}
