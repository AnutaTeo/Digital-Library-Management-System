package com.dlms.catalogservice.service;

import com.dlms.catalogservice.model.Book;
import com.dlms.catalogservice.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public Book getBook(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public boolean exists(Long id) {
        return repository.existsById(id);
    }
}
