package com.rest.Book.controller;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rest.Book.dao.BookRepository;
import com.rest.Book.model.Book;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "books")
public class BookController {

	@Autowired
	private BookRepository bookRepository;
	
	 @GetMapping("/book")
	   public List<Book> getUser()
	   {
		    System.out.println("My List "+ bookRepository.findAll());
		   return bookRepository.findAll();
	   }
	 
	 @GetMapping("/book/{id}")
	 public Book retrieveStudent(@PathVariable long id) throws Exception {
	 	Optional<Book> student = bookRepository.findById(id);

	 	if (!student.isPresent())
	 		throw new Exception("id-" + id);

	 	return student.get();
	 }
	 @DeleteMapping("/book/{id}")
	 public void deleteBook(@PathVariable long id) {
		 bookRepository.deleteById(id);
	 }
	 @PostMapping("/book")
	 public ResponseEntity<Object> createBook(@RequestBody Book book) {
	 	Book savedBook = bookRepository.save(book);

	 	URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	 			.buildAndExpand(savedBook.getId()).toUri();

	 	return ResponseEntity.created(location).build();

	 }
	 @PutMapping("/book/{id}")
	 public ResponseEntity<Object> updateBook(@RequestBody Book book, @PathVariable long id) {

	 	Optional<Book> bookOptional = bookRepository.findById(id);

	 	if (!bookOptional.isPresent())
	 		return ResponseEntity.notFound().build();

	 	book.setId(id);
	 	bookRepository.save(book);
	 	return ResponseEntity.noContent().build();
	 }

}
