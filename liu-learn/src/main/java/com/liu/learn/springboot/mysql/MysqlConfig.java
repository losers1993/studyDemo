package com.liu.learn.springboot.mysql;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;


/**
 * mysql手动配置数据源
 * 
 * @author liuyq
 * @version 1.0,2017年9月26日
 */
@Configuration
@EnableTransactionManagement
@PropertySource(value = {"classpath:mysql-resource.properties"})
public class MysqlConfig {
	@Autowired
	//private Environment env;
	
	@Bean(destroyMethod = "close")
	@Qualifier("dataSource1")
	@Primary
	@ConfigurationProperties(prefix="spring.datasource.one")
	public DataSource dataSource() {
		/*DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("source.driver-class-name").trim());
        dataSource.setUrl(env.getProperty("source.url").trim());
        dataSource.setUsername(env.getProperty("source.username").trim());
        dataSource.setPassword(env.getProperty("source.password").trim());
        return dataSource;*/
		
		return DataSourceBuilder.create().build();
	} 
	
	@Bean
	@Qualifier("jdbcTemplate1")
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource1") DataSource dataSource) {
		return new JdbcTemplate(dataSource);
    }
	
	/*@Bean(destroyMethod = "close")
	@Qualifier("dataSource2")
	@ConfigurationProperties(prefix="spring.datasource.two")
	public DataSource dataSource2() {
		DruidDataSource dataSource = new DruidDataSource();
		dataSource.setDriverClassName(env.getProperty("source.driver-class-name2").trim());
        dataSource.setUrl(env.getProperty("source.url2").trim());
        dataSource.setUsername(env.getProperty("source.username2").trim());
        dataSource.setPassword(env.getProperty("source.password2").trim());
        return dataSource;
		return DataSourceBuilder.create().build();
	} 
	
	@Bean
	@Qualifier("jdbcTemplate2")
    public JdbcTemplate jdbcTemplate2(@Qualifier("dataSource2") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }*/
}
