package com.liu.learn.springboot.mysql.dao;

import java.util.List;


import com.liu.learn.springboot.mysql.domain.Author;
public interface AuthorDao {
	int add(Author author);
    int update(Author author);
    int delete(Long id);
    Author findAuthor(Long id);
    List<Author> findAuthorList();
}
