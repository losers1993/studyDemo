package com.liu.learn.springboot.mysql.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.liu.learn.springboot.mysql.domain.Author;
@Service
public interface AuthorService {
	
	public int add(Author author);
	public int update(Author author);
	public int delete(Long id);
	public Author findAuthor(Long id);
	public List<Author> findAuthorList();
}
