package com.example.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.service.BookService;

@Service
@Qualifier("bookService")
public class BookServiceImpl implements BookService {
	 private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);
	    SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy"); 

	@Override
	public Book findById(int id) throws ParseException {
		Book book =  new Book(id,"Spring Boot in Action","Una guía centrada en el "
				+ "desarrollador para escribir aplicaciones usando Spring Boot.","Craig Walls",sdf.parse("03/01/2016"));
		return book;
	}
	@Override
	public List<Book> getListBook() throws ParseException {
		List<Book> books = new ArrayList<>();
		books.add(new Book(1, "La Guerra del Fin del mundo", "Una novela extremadamente reveladora sobre un episodio verídico en América Latina", "Mario Vargas Llosa", sdf.parse("23/02/2016")));
		books.add(new Book(2, "Tu supercerebro", "Tu supercerebro", " Kaja Nordengen", sdf.parse("01/10/2018")));
		books.add(new Book(3, "Genética: Un enfoque conceptual", "La genética es la base del fascinante proceso de la evolución", "Benjamin A. Pierce", sdf.parse("27/11/2015")));
		books.add(new Book(4, "El libro de los negocios", "Un gran líder empresarial", "DK", sdf.parse("19/02/2019")));
		books.add(new Book(5, "Persepolis", "Persépolis se ha convertido por méritos propios en un clásico de la novela gráfica", "Marjane Satapri", sdf.parse("01/01/2014")));
		return books;
	}
}
