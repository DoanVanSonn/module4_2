package com.example.ss9aop.service;

import com.example.ss9aop.bean.BorrowTicket;
import com.example.ss9aop.repository.IBorrowTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BorrowTicketService implements IService<BorrowTicket>{
    private IBorrowTicketRepository ticketRepository;
    @Autowired
    @Override
    public List<BorrowTicket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public BorrowTicket findById(int id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public void save(BorrowTicket borrowTicket) {
        ticketRepository.save(borrowTicket);
    }

    @Override
    public void delete(BorrowTicket borrowTicket) {
        ticketRepository.delete(borrowTicket);
    }
}
