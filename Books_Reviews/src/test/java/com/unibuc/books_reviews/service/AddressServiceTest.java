package com.unibuc.books_reviews.service;
import static org.junit.jupiter.api.Assertions.*;

import com.unibuc.books_reviews.model.Address;
import com.unibuc.books_reviews.repository.AddressRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AddressServiceTest {
    @InjectMocks
    AddressService addressService;
    
    @Mock
    AddressRepository addressRepository;

    @Test
    @DisplayName("Running save Address in a happy flow")
    void saveNewAddressHappyFlow(){
        Address address1 = new Address(1,"Street", 12,"City","Country");
        when(addressRepository.save(address1)).thenReturn(address1);
        Address result = addressService.save(address1);
        assertEquals(address1.getCity(), result.getCity());
    }

    @Test
    @DisplayName("Running getAll categories in happy flow")
    void getAllHappyFlow(){
        Address address1 = new Address(1,"Street", 12,"City","Country");
        Address address2 = new Address(2,"Street2", 122,"City2","Country2");
        List<Address> addressList = new ArrayList<>();
        addressList.add(address1);
        addressList.add(address2);
        when(addressRepository.findAll()).thenReturn(addressList);
        List<Address> result = addressService.getAll();
        assertEquals(2, result.size());
    }
}
