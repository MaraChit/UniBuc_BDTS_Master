package com.example.proiectfinal.controller;

import com.example.proiectfinal.model.PublishingHouse;
import com.example.proiectfinal.service.PublishingHouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PublishingHouseController {
    @Autowired
    PublishingHouseService publishingHouseService;


    public PublishingHouseController(PublishingHouseService publishingHouseService) {
        this.publishingHouseService = publishingHouseService;
    }

    @RequestMapping("/publishingHouses")
    public ModelAndView ListPublishingHouses(){
        ModelAndView modelAndView = new ModelAndView("publishingHouseList");
        List<PublishingHouse> publishingHouses = publishingHouseService.findAll();
        modelAndView.addObject("publishingHouses", publishingHouses);
        return modelAndView;
    }

    @RequestMapping("/newPublishingHouse")
    public String newPublishingHouse(Model model) {
        model.addAttribute("publishingHouse", new PublishingHouse());
        List<PublishingHouse> publishingHousesAll = publishingHouseService.findAll();

        model.addAttribute("publishingHousesAll", publishingHousesAll );
        return "publishingHouseForm";
    }

    @PostMapping("/completeNewPublishingHouse")
    public String saveOrUpdate(@ModelAttribute PublishingHouse publishingHouse){
        publishingHouseService.save(publishingHouse);
        return "redirect:/publishingHouses";
    }
}
