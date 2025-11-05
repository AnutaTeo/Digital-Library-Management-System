package com.wad.firstmvc.domain.catalog;

import java.util.ArrayList;
import java.util.List;

public class BookBuilder {
    private Long id; private String title; private final List<String> authors = new ArrayList<>();
    private String genre; private String isbn;

    public BookBuilder id(Long id){ this.id = id; return this; }
    public BookBuilder title(String t){ this.title = t; return this; }
    public BookBuilder addAuthor(String a){ this.authors.add(a); return this; }
    public BookBuilder genre(String g){ this.genre = g; return this; }
    public BookBuilder isbn(String i){ this.isbn = i; return this; }

    public Book build(){
        if (title == null || authors.isEmpty()) throw new IllegalStateException("title & author required");
        return new Book(id, title, authors, genre, isbn);
    }
}