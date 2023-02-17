package com.example.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookmyshow.models.Theatre;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Long>{
    
}
