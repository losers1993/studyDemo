package com.liu.learn.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController //@controller + @ResponseBody
@EnableConfigurationProperties({ConfigBean.class})
public class SpringBootController {
	@Value("${liu.springboot.name}")
	private String name;
	
	@Autowired
	private ProfilesDBConnector profilesDBConnector;
	
	@Autowired
	private ConfigBean configBean;
	
	@Bean(initMethod="init",destroyMethod="destory")
	public ProfilesDBConnectorDev beanProfilesDBConnector() {
		return new ProfilesDBConnectorDev();
	}
	
	@RequestMapping("/")
	public void test() {
		System.out.println(configBean.getName());
	}
	
	@RequestMapping("/test1")
	public String test1() {
		return "index";
	}
	
	@RequestMapping("/testProfiles")
	public void testProfiles(@RequestBody Rest rest) {
		profilesDBConnector.showDB();
	}
}
