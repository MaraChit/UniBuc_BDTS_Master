package com.example.proiectfinal.service;

import com.example.proiectfinal.model.PublishingHouse;

import java.util.List;

public interface PublishingHouseService {
    List<PublishingHouse> findAll();
    PublishingHouse save(PublishingHouse publishingHouse);
}
