package com.liu.learn.springboot.mysql.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.liu.learn.springboot.mysql.dao.AuthorDao;
import com.liu.learn.springboot.mysql.domain.Author;
import com.liu.learn.springboot.mysql.service.AuthorService;
@Service("authorServiceImpl2")
public class AuthorServiceImpl2 implements AuthorService{
	@Autowired
	@Qualifier("authorDaoImpl2")
	public AuthorDao authorDao2;
	
	public int add(Author author) {
		return authorDao2.add(author);
	}
	public int update(Author author) {
		return authorDao2.update(author);
	}
	public int delete(Long id) {
		return authorDao2.delete(id);
	}
	public Author findAuthor(Long id) {
		return authorDao2.findAuthor(id);
	}
	public List<Author> findAuthorList() {
		return authorDao2.findAuthorList();
	}
}
