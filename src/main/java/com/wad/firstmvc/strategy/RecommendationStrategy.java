package com.wad.firstmvc.strategy;
import com.wad.firstmvc.domain.catalog.Book;
import com.wad.firstmvc.domain.users.Member;
import com.wad.firstmvc.repositories.BookRepository;

import java.util.List;

public interface RecommendationStrategy {
    List<Book> recommend(Member m, BookRepository repo);
}
