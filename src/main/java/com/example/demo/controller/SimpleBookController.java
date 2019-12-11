package com.example.demo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@RestController
@RequestMapping
public class SimpleBookController {
    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleBookController.class);
    private SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 

    @Autowired
    @Qualifier("bookService")
    private BookService bookService;

    
	@GetMapping(path = "/book/{id}",produces = "application/json")
	public Book getBook(@PathVariable int id) throws ParseException{
		LOGGER.info("Get a Book with id:"+ id);
		return bookService.findById(id);
	}
	
	@GetMapping(path = "/book/all",produces = "application/json")
	public List<Book> getAllBook() throws ParseException{
		LOGGER.info("Get All Book!!!");
		return bookService.getListBook();	
	}
}




