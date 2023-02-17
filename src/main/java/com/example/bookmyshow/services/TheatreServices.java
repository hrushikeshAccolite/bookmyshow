package com.example.bookmyshow.services;

import java.util.List;

import com.example.bookmyshow.models.Theatre;

public interface TheatreServices {
    Theatre createTheatre(Theatre theatre);
    Theatre updateTheatre(Theatre user);
    List<Theatre> getAllTheatres();
    Theatre getTheatreById(Long theatreId);
    void deleteTheatre(Long theatreId);
}
