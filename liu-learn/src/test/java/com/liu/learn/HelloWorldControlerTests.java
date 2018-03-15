package com.liu.learn;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.liu.learn.springboot.SpringBootController;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {LiuLearnApplication.class,MockServletContext.class})
@WebAppConfiguration
public class HelloWorldControlerTests {
	private MockMvc mvc;
	
	@Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new SpringBootController()).build();
    }
    @Test
    public void getHello() throws Exception {
	    mvc.perform(MockMvcRequestBuilders.get("/test1").accept(MediaType.APPLICATION_JSON))
	                .andExpect(MockMvcResultMatchers.status().isOk())
	                .andDo(MockMvcResultHandlers.print())
	                .andReturn();
    }
}
