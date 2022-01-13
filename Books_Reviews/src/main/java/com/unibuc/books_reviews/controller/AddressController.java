package com.unibuc.books_reviews.controller;

import com.unibuc.books_reviews.model.Address;
import com.unibuc.books_reviews.service.AddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("/new")
    public ResponseEntity<Address> saveAddress(@Valid @RequestBody Address address){
            return ResponseEntity.ok()
                    .body(addressService.save(address));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Address>> retrieveAddresses() {
        return ResponseEntity.ok().body(addressService.getAll());
    }
}
