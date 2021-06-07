package com.thomasvitale.bookservice.demo;

import java.util.List;

import com.thomasvitale.bookservice.domain.Book;
import com.thomasvitale.bookservice.domain.BookRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Profile("test-data")
@RequiredArgsConstructor
public class TestDataLoader {
	private final BookRepository bookRepository;

	@EventListener(ApplicationReadyEvent.class)
	public void loadTestData() {
		var book1 = new Book("1234567899", "The Silmarillion");
		var book2 = new Book("1234567898", "His Dark Materials");
		bookRepository.saveAll(List.of(book1, book2));
	}
}
