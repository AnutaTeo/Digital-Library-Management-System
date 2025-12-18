package com.wad.firstmvc.notifications;

import com.wad.firstmvc.domain.circulation.Loan;

public class DueSoonNotification extends Notification {
    private final Loan loan;
    public DueSoonNotification(Loan loan){
        this.loan = loan;
    }
    public String render(){
        return "Your loan " + loan.getId() + " is due on " + loan.getDueAt();
    }
}