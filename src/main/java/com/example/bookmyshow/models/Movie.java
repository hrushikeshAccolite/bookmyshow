package com.example.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "movies")
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long movieId;

    @Column(name = "movieName")
    private String movieName;

    @Column(name = "movieDescription")
    private String movieDescription;

    @Column(name = "movieLanguage")
    private String movieLanguage;

    @Column(name = "movieGenre")        
    private String movieGenre;
}
