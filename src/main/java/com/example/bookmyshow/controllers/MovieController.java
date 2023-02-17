package com.example.bookmyshow.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.services.MovieServices;

@RestController
public class MovieController {

    @Autowired
    private MovieServices movieServices;

    @GetMapping("/movies")
    private ResponseEntity<List<Movie>> getAllMovies(){
        return ResponseEntity.ok().body(this.movieServices.getAllMovie());
    }

    @GetMapping("/movies/{movieId}")
    private Movie getMovieById(@PathVariable long movieId) {
        return this.movieServices.getMovieById(movieId);
    }

    @PostMapping("/createMovie")
    private ResponseEntity<Movie> addMovie(@RequestBody Movie movie){
        return ResponseEntity.ok().body(this.movieServices.createMovie(movie));
    }

    @PutMapping("/updateMovie/{movieId}")
    private ResponseEntity<Movie> updateMovie(@PathVariable long movieId, @RequestBody Movie movie){
        movie.setMovieId(movieId);
        return ResponseEntity.ok().body(this.movieServices.updateMovie(movie));
    }

    @DeleteMapping("/deleteMovie/{movieId}")
    private HttpStatus deleteMovie(@PathVariable long movieId){
        this.movieServices.deleteMovie(movieId);
        return HttpStatus.OK;
    }
}
