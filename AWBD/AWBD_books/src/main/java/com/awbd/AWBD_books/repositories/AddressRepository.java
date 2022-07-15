package com.awbd.AWBD_books.repositories;

import com.awbd.AWBD_books.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
