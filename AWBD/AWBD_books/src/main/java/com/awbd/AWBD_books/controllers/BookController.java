package com.awbd.AWBD_books.controllers;

import com.awbd.AWBD_books.domain.Book;
import com.awbd.AWBD_books.services.BookService;
import com.awbd.AWBD_books.services.CategoryService;
import com.awbd.AWBD_books.domain.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    /*    @RequestMapping("/book/list")
    public String booksList(Model model){
        List<Book> books = bookService.findAll();
        model.addAttribute("books",books);

        return "books";
    }*/



    @RequestMapping("/book/list")
    public ModelAndView booksList(){
        ModelAndView modelAndView = new ModelAndView("books");
        List<Book> books = bookService.findAll();
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/book/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("book",
                bookService.findById(Long.valueOf(id)));
        return "info";
    }

    @RequestMapping("/book/delete/{id}")
    public String deleteById(@PathVariable String id){
        bookService.deleteById(Long.valueOf(id));
        return "redirect:/book/list";
    }

    @RequestMapping("/book/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        List<Category> categoriesAll = categoryService.findAll();

        model.addAttribute("categoriesAll", categoriesAll );
        return "bookform";
    }

    @PostMapping("/book")
    public String saveOrUpdate(@Valid @ModelAttribute Book book,
                                          BindingResult bindingResult,
                               @ModelAttribute ArrayList<Category> categoriesAll
                               ){
        System.out.println(book.getInfo());
        if (bindingResult.hasErrors()){
            return "bookform";
        }

        Book savedBook = bookService.save(book);
        return "redirect:/book/list" ;
    }

}
