package com.liu.learn;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.liu.learn.springboot.mysql.domain.Author;
import com.liu.learn.springboot.mysql.service.AuthorService;
import com.liu.learn.springboot.mysql.service.impl.AuthorServiceImpl2;
import com.liu.learn.springboot.redis.RedisBaseDao;
import com.liu.learn.springboot.springaware.AwareService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.config.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LiuLearnApplication.class)
@WebAppConfiguration
public class LiuSpringBootTest {
	@Autowired
	private AwareService awareService;
	@Autowired
	@Qualifier("authorServiceImpl1")
	private AuthorService authorService1;
	@Autowired
	@Qualifier("authorServiceImpl2")
	private AuthorService authorService2;
	@Autowired
	private RedisBaseDao redisBaseDao;
	
	@Test
	public void test() {
		System.out.println(awareService.getBeanName());
	}
	
	@Test
	public void ehcacheTest() {
		/*CacheManager cacheManager = CacheManager.create("./src/main/resource/ehcache.xml");
		Cache cache = cacheManager.getCache("a");
		Element element = new Element("a", "aaa");
		Element elementB = new Element("b", "bbb");
		Element elementC = new Element("c", "ccc");
		cache.put(element);
		cache.put(elementB);
		cache.put(elementC);
		
		Element element2 = cache.get("b");
		
		System.out.println(element2.getObjectKey() + "," + element2.getObjectValue());*/
		
		//获取当前CacheManager配置xml文件信息
		CacheManager cacheManager2 = new CacheManager();
		System.out.println(cacheManager2.getActiveConfigurationText());
		
		//新建一个CacheManager配置信息
		Configuration configuration = new Configuration();
		//新建一个cache配置信息
		CacheConfiguration cacheConfiguration = new CacheConfiguration("testConfiguration", 3);
		//将cache配置信息加入到指定的CacheManager配置中
		configuration.addCache(cacheConfiguration);
		
		CacheManager cacheManager3 = CacheManager.create(configuration);
		
		Cache cache2 = cacheManager3.getCache("a");
		cache2.put(new Element("liu", "liuyq2"));
		System.out.println(cache2.get("liu").getObjectKey() + "," + cache2.get("liu").getObjectValue());
		
		Cache cache = cacheManager3.getCache("testConfiguration");
		cache.put(new Element("liu", "liuyq"));
		System.out.println(cache.get("liu").getObjectKey() + "," + cache.get("liu").getObjectValue());
		
		//cacheManager3.shutdown();
	}
	
	@Test
	public void mysqlTest() {
		Author author = new Author();
		author.setId(2l);
		author.setRealName("a");
		author.setNickName("bb");
	//	author = authorService1.findAuthor(2l);
		
		if(authorService1 instanceof AuthorServiceImpl2) System.out.println("YES");
		
	//	System.out.println(author.toString());
		
		//System.out.println("--------" + authorService2.findAuthor(1l).toString());
	}
	
	@Test
	public void redisTest() {
		redisBaseDao.addValue("param", "aa");
		
		System.out.println(redisBaseDao.getValue("param"));
	}
}
