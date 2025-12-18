package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.catalog.Book;
import com.wad.firstmvc.domain.users.Member;
import com.wad.firstmvc.repositories.BookRepository;
import com.wad.firstmvc.strategy.RecommendationStrategy;
import lombok.Setter;

import java.util.List;

public class RecommendationService {
    @Setter
    private RecommendationStrategy strategy;
    private final BookRepository repo;

    public RecommendationService(RecommendationStrategy strategy, BookRepository repo){
        this.strategy = strategy; this.repo = repo;
    }

    public List<Book> recommendFor(Member m){
        return strategy.recommend(m, repo); }
}
