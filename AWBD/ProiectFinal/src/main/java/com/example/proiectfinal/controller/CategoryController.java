package com.example.proiectfinal.controller;

import com.example.proiectfinal.model.Category;
import com.example.proiectfinal.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    CategoryService categoryService;


    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @RequestMapping("/categories")
    public ModelAndView ListCategories(){
        ModelAndView modelAndView = new ModelAndView("categoryList");
        List<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories", categories);
        return modelAndView;
    }

    @RequestMapping("/newCategory")
    public String newCategory(Model model) {
        model.addAttribute("category", new Category());
        List<Category> categoriesAll = categoryService.findAll();

        model.addAttribute("categoriesAll", categoriesAll );
        return "categoryform";
    }

    @PostMapping("/completeNewCategory")
    public String saveOrUpdate(@ModelAttribute Category category){
        categoryService.save(category);
        return "redirect:/categories";
    }
}
