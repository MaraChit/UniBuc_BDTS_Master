package com.awbd.AWBD_books.repositories;


import com.awbd.AWBD_books.domain.Borrow;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Long> {
}

