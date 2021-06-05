package com.thomasvitale.orderservice.web;

import lombok.Data;

@Data
public class Book {
	private Long id;
	private String isbn;
	private String title;
}
