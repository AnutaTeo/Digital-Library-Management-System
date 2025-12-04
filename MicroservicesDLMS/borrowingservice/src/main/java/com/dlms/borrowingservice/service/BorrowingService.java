package com.dlms.borrowingservice.service;

import com.dlms.borrowingservice.dto.BorrowRequest;
import com.dlms.borrowingservice.model.Borrowing;
import com.dlms.borrowingservice.repository.BorrowingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class BorrowingService {

    private final BorrowingRepository repository;
    private final RestTemplate restTemplate;

    public BorrowingService(BorrowingRepository repository, RestTemplate restTemplate) {
        this.repository = repository;
        this.restTemplate = restTemplate;
    }

    public Borrowing borrowBook(BorrowRequest request) {
        Boolean userExists = restTemplate.getForObject(
                "http://user-service:8081/users/" + request.getUserId() + "/exists",
                Boolean.class
        );

        if (userExists == null || !userExists) {
            throw new RuntimeException("User does not exist");
        }

        Boolean bookExists = restTemplate.getForObject(
                "http://catalog-service:8082/books/" + request.getBookId() + "/exists",
                Boolean.class
        );

        if (bookExists == null || !bookExists) {
            throw new RuntimeException("Book does not exist");
        }

        Borrowing borrowing = new Borrowing(
                request.getUserId(),
                request.getBookId(),
                LocalDate.now(),
                LocalDate.now().plusWeeks(2)
        );

        return repository.save(borrowing);
    }

    public Borrowing getBorrowing(Long id) {
        return repository.findById(id).orElse(null);
    }

    public java.util.List<Borrowing> getAll() {
        return repository.findAll();
    }
}
