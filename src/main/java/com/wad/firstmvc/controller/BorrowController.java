package com.wad.firstmvc.controller;

import com.wad.firstmvc.domain.circulation.Loan;
import com.wad.firstmvc.domain.users.Member;
import com.wad.firstmvc.services.BorrowService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BorrowController {
    private final BorrowService borrowService;
    public BorrowController(BorrowService s){
        this.borrowService = s;
    }

    @PostMapping("/borrow/{bookId}")
    public Loan borrow(@PathVariable Long bookId){
        Member m = new Member(1L, "user@example.com", "Monica");
        return borrowService.borrow(m, bookId);
    }

    @GetMapping("/borrow/{bookId}")
    public String simulateBorrow(@PathVariable Long bookId) {
        return "To borrow a book, wait for the website to be done" + bookId;
    }

}