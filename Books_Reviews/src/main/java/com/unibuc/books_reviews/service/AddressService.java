package com.unibuc.books_reviews.service;

import com.unibuc.books_reviews.model.Address;
import com.unibuc.books_reviews.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address save(Address address){
        return addressRepository.save(address);
    }
    public List<Address> getAll() {
        return addressRepository.findAll();
    }
}
