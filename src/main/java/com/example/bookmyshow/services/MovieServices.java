package com.example.bookmyshow.services;

import java.util.List;

import com.example.bookmyshow.models.Movie;

public interface MovieServices {
    Movie createMovie(Movie movie);
    Movie updateMovie(Movie movie);
    List<Movie> getAllMovie();
    Movie getMovieById(Long movieId);
    void deleteMovie(Long movieId);
}
