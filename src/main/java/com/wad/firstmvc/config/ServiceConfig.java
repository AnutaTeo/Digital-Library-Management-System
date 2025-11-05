package com.wad.firstmvc.config;

import com.wad.firstmvc.notifications.NotificationCenter;
import com.wad.firstmvc.notifications.NotificationFactory;
import com.wad.firstmvc.repositories.BookRepository;
import com.wad.firstmvc.repositories.InventoryRepository;
import com.wad.firstmvc.repositories.LoanRepository;
import com.wad.firstmvc.services.BorrowService;
import com.wad.firstmvc.services.RecommendationService;
import com.wad.firstmvc.strategy.GenreBasedStrategy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {
    @Bean
    BorrowService borrowService(InventoryRepository inv, LoanRepository loans,
                                NotificationCenter nc, NotificationFactory nf){
        return new BorrowService(inv, loans, nc, nf);
    }
    @Bean
    RecommendationService recommendationService(BookRepository repo){
        return new RecommendationService(new GenreBasedStrategy(), repo);
    }
}
