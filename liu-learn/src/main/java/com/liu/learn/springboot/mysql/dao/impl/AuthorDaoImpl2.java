package com.liu.learn.springboot.mysql.dao.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.liu.learn.springboot.mysql.dao.AuthorDao;
import com.liu.learn.springboot.mysql.domain.Author;
@Repository
@Qualifier("authorDaoImpl2")
public class AuthorDaoImpl2 implements AuthorDao{

	//@Autowired
	//@Qualifier("jdbcTemplate2")
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int add(Author author) {
		return jdbcTemplate.update("insert into t_author(real_name,nick_name) values (?,?)", author.getRealName(), author.getRealName());
	}

	@Override
	public int update(Author author) {
		return jdbcTemplate.update("update t_author set nick_name = ?,real_name = ? where id = ?",
				new Object[]{author.getNickName(), author.getRealName(), author.getId()});
	}

	@Override
	public int delete(Long id) {
		return jdbcTemplate.update("delete from t_author where id = ?", id);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    public Author findAuthor(Long id) {
        List<Author> list = jdbcTemplate.query("select * from t_author where id = ?", new Object[]{id}, new BeanPropertyRowMapper(Author.class));
        if(null != list && list.size()>0){
            Author auhtor = list.get(0);
            return auhtor;
        }else{
            return null;
        }
    }
    @Override
    public List<Author> findAuthorList() {
        List<Author> list = jdbcTemplate.query("select * from t_author", new Object[]{}, new BeanPropertyRowMapper<Author>(Author.class));
        return list;
    }
}
