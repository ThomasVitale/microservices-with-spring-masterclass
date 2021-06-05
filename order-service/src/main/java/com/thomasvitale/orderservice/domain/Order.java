package com.thomasvitale.orderservice.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("orders")
@Data @NoArgsConstructor
public class Order {

	@Id
	private Long id;
	private String isbn;
	private OrderStatus status;

	public Order(String isbn, OrderStatus status) {
		this.isbn = isbn;
		this.status = status;
	}
}
