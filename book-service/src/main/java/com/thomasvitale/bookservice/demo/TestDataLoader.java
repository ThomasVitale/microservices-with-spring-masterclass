package com.thomasvitale.bookservice.demo;

import com.thomasvitale.bookservice.domain.Book;
import com.thomasvitale.bookservice.domain.BookRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("test-data")
public class TestDataLoader {

	private final BookRepository bookRepository;

	public TestDataLoader(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void loadTestData() {
		bookRepository.deleteAll();
		var book1 = new Book(null, "1234567899", "The Silmarillion");
		var book2 = new Book(null, "1234567898", "His Dark Materials");
		bookRepository.saveAll(List.of(book1, book2));
	}

}
