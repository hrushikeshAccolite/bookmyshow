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
}
