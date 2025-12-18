package com.wad.firstmvc.repositories;
import com.wad.firstmvc.domain.catalog.Book;
import java.util.*;

public interface BookRepository {
    List<Book> search(String query, String genre);
    Optional<Book> findById(Long id);
}