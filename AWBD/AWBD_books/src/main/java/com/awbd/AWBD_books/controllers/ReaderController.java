package com.awbd.AWBD_books.controllers;

import com.awbd.AWBD_books.domain.Reader;
import com.awbd.AWBD_books.services.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ReaderController {
    @Autowired
    ReaderService readerService;

    @Autowired
    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @GetMapping("/reader/info/{id}")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("reader",
                readerService.findById(Long.valueOf(id)));
        return "inforeader";
    }

    @RequestMapping("/reader/new")
    public String newReader(Model model) {
        model.addAttribute("reader", new Reader());
        return "readerform";
    }

    @RequestMapping("/reader/update/{id}")
    public String updateReader(@PathVariable String id, Model model) {
        model.addAttribute("reader",
                readerService.findById(Long.valueOf(id)));
        return "readerform";
    }


    @PostMapping("/reader")
    public String saveOrUpdate(@ModelAttribute Reader reader){
        Reader savedReader = readerService.save(reader);
        return "redirect:/reader/info/" + savedReader.getId();
    }

    /* GlobalExceptionHandler.class
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ResourceNotFoundException.class)
    public ModelAndView handlerNotFoundException(Exception exception){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModel().put("exception",exception);
        modelAndView.setViewName("notfound");
        return modelAndView;
    }
    */
}
