package com.example.demo.service;

import java.text.ParseException;
import java.util.List;

import com.example.demo.model.Book;

public interface BookService {
	public abstract Book findById(int id) throws ParseException;
	public abstract List<Book> getListBook()  throws ParseException ;

}
