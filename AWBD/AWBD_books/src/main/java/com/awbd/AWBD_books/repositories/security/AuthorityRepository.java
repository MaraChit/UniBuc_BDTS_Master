package com.awbd.AWBD_books.repositories.security;

import com.awbd.AWBD_books.domain.security.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
