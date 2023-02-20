package com.example.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.bookmyshow.models.Show;

public interface ShowRepository extends JpaRepository<Show, Long>{
    
}
