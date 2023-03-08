package com.example.ss9aop.bean;

import javax.persistence.*;
import java.util.Random;

@Entity
public class BorrowTicket {
    @Id
    private int borrowCode;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public BorrowTicket() {
        Random random = new Random();
        this.borrowCode = random.nextInt(90000) + 10000;
    }

    public BorrowTicket(Book book) {
        Random random = new Random();
        this.borrowCode = random.nextInt(90000) + 10000;
        this.book = book;
    }

    public int getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(int borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
