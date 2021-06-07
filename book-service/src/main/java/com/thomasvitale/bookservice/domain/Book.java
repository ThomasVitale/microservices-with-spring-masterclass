package com.thomasvitale.bookservice.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Book {

	@Id
	private Long id;
	private String isbn;
	private String title;

	public Book() {}

	public Book(String isbn, String title) {
		this.isbn = isbn;
		this.title = title;
	}

}
