package com.thomasvitale.bookservice.domain;

import lombok.Data;

import org.springframework.data.annotation.Id;

@Data
public class Book {

	@Id
	private Long id;
	private String isbn;
	private String title;

}
