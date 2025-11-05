package com.wad.firstmvc.domain.catalog;

import lombok.Getter;

import java.util.List;
public class Book {
    @Getter
    private final Long id;
    @Getter
    private final String title;
    private final List<String> authors;
    @Getter
    private final String genre;
    private final String isbn;

    Book(Long id, String title, List<String> authors, String genre, String isbn) {
        this.id = id;
        this.title = title;
        this.authors = List.copyOf(authors);
        this.genre = genre;
        this.isbn = isbn;
    }

}