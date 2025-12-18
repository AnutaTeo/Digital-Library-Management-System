package com.wad.firstmvc.controller;
import com.wad.firstmvc.domain.catalog.Book;
import com.wad.firstmvc.domain.users.Member;
import com.wad.firstmvc.services.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class RecommendationController {
    private final RecommendationService service;
    public RecommendationController(RecommendationService s){
        this.service = s;
    }

    @GetMapping("/recommendations")
    public List<Book> recommend(){
        Member m = new Member(1L, "user@example.com", "Ana");
        return service.recommendFor(m);
    }
}
