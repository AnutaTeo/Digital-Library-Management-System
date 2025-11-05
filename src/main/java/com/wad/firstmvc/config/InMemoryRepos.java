package com.wad.firstmvc.config;

import com.wad.firstmvc.domain.catalog.Book;
import com.wad.firstmvc.domain.catalog.BookBuilder;
import com.wad.firstmvc.domain.catalog.InventoryItem;
import com.wad.firstmvc.domain.circulation.Loan;
import com.wad.firstmvc.repositories.BookRepository;
import com.wad.firstmvc.repositories.InventoryRepository;
import com.wad.firstmvc.repositories.LoanRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class InMemoryRepos implements BookRepository, InventoryRepository, LoanRepository {
    private final List<Book> books = new ArrayList<>();
    private final Map<Long, InventoryItem> inventory = new HashMap<>();
    @Setter
    @Getter
    private long nextLoanId = 1L;

    public InMemoryRepos(){
        var b1 = new BookBuilder().id(1L).title("The Hobbit").addAuthor("Tolkien").genre("Fantasy").isbn("X").build();
        var b2 = new BookBuilder().id(2L).title("Clean Code").addAuthor("Martin").genre("Tech").isbn("Y").build();
        books.addAll(List.of(b1, b2));
        inventory.put(101L, new InventoryItem(101L, b1));
        inventory.put(102L, new InventoryItem(102L, b2));
    }

    public List<Book> search(String q, String genre){
        return books.stream()
                .filter(b -> q==null || q.isBlank() || b.getTitle().toLowerCase().contains(q.toLowerCase()))
                .filter(b -> genre==null || genre.isBlank() || genre.equalsIgnoreCase(b.getGenre()))
                .toList();
    }
    public Optional<Book> findById(Long id){ return books.stream().filter(b -> b.getId().equals(id)).findFirst(); }

    public Optional<InventoryItem> findAvailableByBookId(Long bookId){
        return inventory.values().stream()
                .filter(i -> i.getBook().getId().equals(bookId) && i.getStatus()== InventoryItem.Status.AVAILABLE)
                .findFirst();
    }

    public Loan save(Loan loan){
        return loan;
    }

}
