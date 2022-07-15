package com.awbd.AWBD_books.services;

import com.awbd.AWBD_books.domain.Address;
import com.awbd.AWBD_books.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService{

    AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }


    @Override
    public List<Address> findAll() {
        List<Address> addresses = new ArrayList<>();
        addressRepository.findAll().iterator().forEachRemaining(addresses::add);
        return addresses ;
    }
}
