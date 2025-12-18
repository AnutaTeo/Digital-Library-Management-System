package com.wad.firstmvc.controller;


import com.wad.firstmvc.domain.catalog.Book;
import com.wad.firstmvc.domain.catalog.BookBuilder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/books")
public class BookController {

    @PostMapping
    public Book create(@RequestBody CreateBookDto dto){
        return new BookBuilder()
                .id(dto.id)
                .title(dto.title)
                .addAuthor(dto.author)
                .genre(dto.genre)
                .isbn(dto.isbn)
                .build();
    }
    @GetMapping("/book1")
    public Book sample() {
        return new BookBuilder()
                .id(10L)
                .title("Poezii")
                .addAuthor("Mihai Eminescu")
                .genre("Demo")
                .isbn("0000")
                .build();
    }


    public static class CreateBookDto {
        public Long id; public String title; public String author; public String genre; public String isbn;
    }
}
