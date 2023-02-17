package com.example.bookmyshow.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bookmyshow.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{
    
}
