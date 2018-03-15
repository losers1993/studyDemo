package com.liu.learn.springboot.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.liu.learn.springboot.mysql.dao.AuthorDao;
import com.liu.learn.springboot.mysql.domain.Author;
import com.liu.learn.springboot.mysql.service.AuthorService;
@Service("authorServiceImpl1")
public class AuthorServiceImpl1 implements AuthorService{
	@Autowired
	@Qualifier("authorDaoImpl")
	public AuthorDao authorDao;
	
	public int add(Author author) {
		return authorDao.add(author);
	}
	public int update(Author author) {
		return authorDao.update(author);
	}
	public int delete(Long id) {
		return authorDao.delete(id);
	}
	public Author findAuthor(Long id) {
		return authorDao.findAuthor(id);
	}
	public List<Author> findAuthorList() {
		return authorDao.findAuthorList();
	}
}
