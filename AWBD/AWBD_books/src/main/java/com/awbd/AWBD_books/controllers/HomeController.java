package com.awbd.AWBD_books.controllers;

import com.awbd.AWBD_books.domain.Book;
import com.awbd.AWBD_books.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    BookService bookService;

    @GetMapping("/showLogInForm")
    public String showLogInForm(){ return "login"; }

    @RequestMapping({"", "/", "/index"})
    public ModelAndView booksList(){
        ModelAndView modelAndView = new ModelAndView("books");
        List<Book> books = bookService.findAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

    @GetMapping("/access_denied")
    public String accessDenied() {
        return "access_denied";
    }


}
