package com.wad.firstmvc.repositories;

import com.wad.firstmvc.domain.circulation.Loan;

public interface LoanRepository {
    Loan save(Loan loan);
}
