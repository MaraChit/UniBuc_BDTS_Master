package com.example.proiectfinal.controller;

import com.example.proiectfinal.model.Author;
import com.example.proiectfinal.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AuthorController {
    @Autowired
    AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @RequestMapping("/authors")
    public ModelAndView ListAuthors(){
        ModelAndView modelAndView = new ModelAndView("authorList");
        List<Author> authors = authorService.findAll();
        modelAndView.addObject("authors", authors);
        return modelAndView;
    }

    @RequestMapping("/newAuthor")
    public String newAuthor(Model model) {
        model.addAttribute("author", new Author());
        List<Author> authorsAll = authorService.findAll();

        model.addAttribute("authorsAll", authorsAll );
        return "authorform";
    }

    @PostMapping("/completeNewAuthor")
    public String saveOrUpdate(@ModelAttribute Author author){
        authorService.save(author);
        return "redirect:/authors";
    }
}
