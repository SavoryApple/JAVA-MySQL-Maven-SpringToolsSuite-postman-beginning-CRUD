package com.seannavery.mvc.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.seannavery.mvc.models.Book;
import com.seannavery.mvc.services.BookService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

@Controller
public class BookController {
	private final BookService bookService;
    public BookController(BookService bookService){
        this.bookService = bookService;
    }
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("dojoName", "Burbank");
        return "show.jsp";
    }
    
    @RequestMapping("/books/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        Book book = bookService.findBook(id);
        model.addAttribute("book", book);
        return "show.jsp";
    }
}