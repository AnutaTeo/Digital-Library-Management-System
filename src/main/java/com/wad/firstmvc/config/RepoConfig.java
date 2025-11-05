package com.wad.firstmvc.config;

import com.wad.firstmvc.repositories.BookRepository;
import com.wad.firstmvc.repositories.InventoryRepository;
import com.wad.firstmvc.repositories.LoanRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class RepoConfig {
    @Bean
    @Primary
    InMemoryRepos inMemoryRepos(){ return new InMemoryRepos(); }
    @Bean
    BookRepository bookRepository(InMemoryRepos r){ return r; }
    @Bean
    InventoryRepository inventoryRepository(InMemoryRepos r){ return r; }
    @Bean
    LoanRepository loanRepository(InMemoryRepos r){ return r; }
}