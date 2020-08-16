package com.rest.Book.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rest.Book.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
  
	//List<Book> findAll();
//	 List<Book> findByPublished(boolean published);
//	  List<Book> findByTitleContaining(String title);
}
