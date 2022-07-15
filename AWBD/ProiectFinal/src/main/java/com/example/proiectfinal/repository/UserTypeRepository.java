package com.example.proiectfinal.repository;

import com.example.proiectfinal.model.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTypeRepository extends JpaRepository<UserType, Long> {

    @Query("SELECT u FROM UserType u WHERE u.email = ?1")
    UserType findByEmail(String email);
}
