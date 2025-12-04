package com.dlms.borrowingservice.repository;

import com.dlms.borrowingservice.model.Borrowing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRepository extends JpaRepository<Borrowing, Long> {
}
