package com.example.bookmyshow.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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

    @Column(name = "movieName", nullable = false)
    private String movieName;

    @Column(name = "movieLanguage", nullable = false)
    private String movieLanguage;

    @Column(name = "movieGenre")        
    private String movieGenre;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Show> shows = new ArrayList<>();
}
