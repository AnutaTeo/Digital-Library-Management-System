package com.dlms.borrowingservice.controller;

import com.dlms.borrowingservice.dto.BorrowRequest;
import com.dlms.borrowingservice.model.Borrowing;
import com.dlms.borrowingservice.service.BorrowingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow")
public class BorrowingController {

    private final BorrowingService service;

    public BorrowingController(BorrowingService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Borrowing> borrowBook(@RequestBody BorrowRequest request) {
        return ResponseEntity.ok(service.borrowBook(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Borrowing> getBorrowing(@PathVariable Long id) {
        Borrowing borrowing = service.getBorrowing(id);
        if (borrowing == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(borrowing);
    }

    @GetMapping
    public ResponseEntity<List<Borrowing>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
