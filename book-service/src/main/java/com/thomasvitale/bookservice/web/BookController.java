package com.thomasvitale.bookservice.web;

import com.thomasvitale.bookservice.domain.Book;
import com.thomasvitale.bookservice.domain.BookNotFoundException;
import com.thomasvitale.bookservice.domain.BookRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
@RequiredArgsConstructor
public class BookController {
	private static final Logger log = LoggerFactory.getLogger(BookController.class);
	private final BookRepository bookRepository;

	@GetMapping
	public Iterable<Book> getAllBooks() {
		log.info("Accessing all books");
		return bookRepository.findAll();
	}

	@GetMapping("{isbn}")
	public Book getBookByIsbn(@PathVariable("isbn") String isbn) {
		log.info("Accessing book with isbn {}", isbn);
		return bookRepository.findByIsbn(isbn)
				.orElseThrow(() -> new BookNotFoundException(isbn));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Book addBook(@RequestBody Book book) {
		log.info("Creating book with isbn {}", book.getIsbn());
		return bookRepository.save(book);
	}

}
