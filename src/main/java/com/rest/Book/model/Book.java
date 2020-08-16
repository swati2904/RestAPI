package com.rest.Book.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bookdata")
public class Book {
	    private Long id;
	    private String book_name;
	    private String author_name;
	    
	    public Book(){}    
	    
	    public Book( String book_name, String author_name) {
	      super();
	      this.book_name= book_name;
	      this.author_name= author_name;
	      
	        
	    }
	    
	    @Id
		@GeneratedValue(strategy = GenerationType.AUTO)
	    public Long getId() {
	        return id;
	    }
	    public void setId(Long id) {
	        this.id = id;
	    }
		@Column(name = "book_name")
	    public String getBook_name() {
	        return book_name;
	    }
	
	    public void setBook_name(String book_name) {
	        this.book_name = book_name;
	    }
		@Column(name = "author_name")
	    public String getAuthor_name() {
	        return author_name;
	    }
	
	    public void setAuthor_name(String author_name) {
	        this.author_name = author_name;
	    }
	
//	    @Override
//	    public String toString() {
//	    	return "Book [id=" + id + ", book_name=" + book_name + ", author_name=" + author_name + "]";
//		
//	}
	
	
}
