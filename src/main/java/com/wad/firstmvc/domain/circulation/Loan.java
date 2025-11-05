package com.wad.firstmvc.domain.circulation;

import com.wad.firstmvc.domain.catalog.InventoryItem;
import com.wad.firstmvc.domain.users.Member;
import lombok.Getter;

import java.time.LocalDate;

public class Loan {
    @Getter
    private final Long id; @Getter
    private final Member borrower; private final InventoryItem item;
    private final LocalDate borrowedAt; @Getter
    private final LocalDate dueAt; private LocalDate returnedAt;

    public Loan(Long id, Member borrower, InventoryItem item, LocalDate borrowedAt, LocalDate dueAt){
        this.id=id;
        this.borrower=borrower;
        this.item=item;
        this.borrowedAt=borrowedAt;
        this.dueAt=dueAt;
    }

    public void markReturned(){
        this.returnedAt = LocalDate.now();
        item.markReturned();
    }
}
