package com.example.ss9aop.controller;

import com.example.ss9aop.bean.Book;
import com.example.ss9aop.bean.BorrowTicket;
import com.example.ss9aop.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookController {
    private IService<Book> bookService;
    private IService<BorrowTicket> ticketService;

    @Autowired
    public BookController(IService<Book> bookService, IService<BorrowTicket> ticketService) {
        this.bookService = bookService;
        this.ticketService = ticketService;
    }
    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("list", bookService.findAll());
        return "list";
    }

    @GetMapping("/detail")
    public String showDetail(Model model, @RequestParam("id") int id) {
        model.addAttribute("book", bookService.findById(id));
        return "detail";
    }

    @PostMapping("/borrow")
    public String borrow(Model model, @ModelAttribute("book") Book book) {
        if (book.getPrice() == 0) {
            model.addAttribute("mess", "This book is out of stock, can't borrow");
            return "/detail";
        } else {
            book.setPrice(book.getPrice() - 1);
            BorrowTicket ticket = new BorrowTicket(book);
            model.addAttribute("mess", "Success, your borrow code is " + ticket.getBorrowCode());
            ticketService.save(ticket);
            bookService.save(book);
            return "/detail";
        }
    }

    @GetMapping("/return")
    public String returnBook(@RequestParam("code") int borrowCode, Model model) {
        if (ticketService.findById(borrowCode) == null) {
            model.addAttribute("mess", "Can't find that borrow code");
        } else {
            BorrowTicket ticket = ticketService.findById(borrowCode);
            Book book = ticket.getBook();
            book.setPrice(book.getPrice() + 1);
            bookService.save(book);
            ticket.setBook(null);
            ticketService.delete(ticket);
            model.addAttribute("mess", "Return success " + book.getName());
        }
        model.addAttribute("list", bookService.findAll());
        return "list";
    }
}
