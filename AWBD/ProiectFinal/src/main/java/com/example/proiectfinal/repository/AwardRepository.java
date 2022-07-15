package com.example.proiectfinal.repository;

import com.example.proiectfinal.model.Awards;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AwardRepository extends JpaRepository<Awards, Long> {

}