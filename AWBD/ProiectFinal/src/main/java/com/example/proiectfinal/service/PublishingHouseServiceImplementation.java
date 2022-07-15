package com.example.proiectfinal.service;

import com.example.proiectfinal.model.PublishingHouse;
import com.example.proiectfinal.repository.PublishingHouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublishingHouseServiceImplementation implements PublishingHouseService{
    PublishingHouseRepository publishingHouseRepository;

    @Autowired
    public PublishingHouseServiceImplementation(PublishingHouseRepository publishingHouseRepository) {

        this.publishingHouseRepository = publishingHouseRepository;
    }


    @Override
    public List<PublishingHouse> findAll() {
        List<PublishingHouse> categories = new ArrayList<>();
        publishingHouseRepository.findAll().iterator().forEachRemaining(categories::add);
        return categories ;
    }

    @Override
    public PublishingHouse save(PublishingHouse publishingHouse) {
        PublishingHouse savedPublishingHouse = publishingHouseRepository.save(publishingHouse);
        return savedPublishingHouse;
    }
}
