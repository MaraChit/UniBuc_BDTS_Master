package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Info;
import com.awbd.AWBD_books.repositories.InfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    InfoRepository infoRepository;

    @Autowired
    public InfoServiceImpl(InfoRepository infoRepository) {

        this.infoRepository = infoRepository;
    }


    @Override
    public List<Info> findAll() {
        List<Info> infoes = new ArrayList<>();
        infoRepository.findAll().iterator().forEachRemaining(infoes::add);
        return infoes ;
    }
}
