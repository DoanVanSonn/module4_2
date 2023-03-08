package com.example.ss9aop.repository;

import com.example.ss9aop.bean.BorrowTicket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBorrowTicketRepository extends JpaRepository<BorrowTicket,Integer> {
}
