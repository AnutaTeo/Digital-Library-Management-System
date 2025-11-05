package com.wad.firstmvc.services;

import com.wad.firstmvc.domain.catalog.InventoryItem;
import com.wad.firstmvc.domain.circulation.Loan;
import com.wad.firstmvc.domain.users.Member;
import com.wad.firstmvc.config.DatabaseConnectionManager;
import com.wad.firstmvc.notifications.NotificationFactory;
import com.wad.firstmvc.notifications.NotificationSubject;
import com.wad.firstmvc.repositories.InventoryRepository;
import com.wad.firstmvc.repositories.LoanRepository;

import java.time.LocalDate;

public class BorrowService {
    private final InventoryRepository inventory;
    private final LoanRepository loans;
    private final NotificationSubject notifier;
    private final NotificationFactory factory;

    public BorrowService(InventoryRepository inventory, LoanRepository loans,
                         NotificationSubject notifier, NotificationFactory factory){
        this.inventory = inventory;
        this.loans = loans;
        this.notifier = notifier;
        this.factory = factory;
    }

    public Loan borrow(Member member, Long bookId){
        DatabaseConnectionManager.getInstance();

        InventoryItem item = inventory.findAvailableByBookId(bookId).orElseThrow();
        item.markBorrowed();
        Loan loan = new Loan(1L, member, item, LocalDate.now(), LocalDate.now().plusDays(14));
        loans.save(loan);

        notifier.notifyAll(factory.create("DUE_SOON", loan));
        return loan;
    }
}
