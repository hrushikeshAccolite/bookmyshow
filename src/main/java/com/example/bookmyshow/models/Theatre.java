package com.example.bookmyshow.models;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@Getter
@Setter
@Table(name = "theatre")
public class Theatre {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long theatreId;

    @Column(name = "theatreName")
    private String theatreName;

    @Column(name = "theatreCity")
    private String theatreCity;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Show> shows = new ArrayList<>();
}
