package com.thomasvitale.orderservice.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
public record Order(

	@Id
	Long id,
	String isbn,
	OrderStatus status

){}
