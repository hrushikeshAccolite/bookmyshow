package com.example.bookmyshow.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmyshow.models.Movie;
import com.example.bookmyshow.repository.MovieRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MovieServicesImpl implements MovieServices{

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        Optional<Movie> movieObj = this.movieRepository.findById(movie.getMovieId());
        if(movieObj.isPresent()){
            Movie updatedMovie = movieObj.get();
            updatedMovie.setMovieName(movie.getMovieName());
            updatedMovie.setMovieDescription(movie.getMovieDescription());
            updatedMovie.setMovieLanguage(movie.getMovieLanguage());
            updatedMovie.setMovieGenre(movie.getMovieGenre());
            return this.movieRepository.save(updatedMovie);
        } else {
            throw new RuntimeException("Movie not found with id: " + movie.getMovieId());
        }
    }

    @Override
    public List<Movie> getAllMovie() {
        return this.movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long movieId) {
        Optional<Movie> movieObj = this.movieRepository.findById(movieId);
        if(movieObj.isPresent()){
            return movieObj.get();
        } else {
            throw new RuntimeException("Movie not found with id " + movieObj);
        }
    }

    @Override
    public void deleteMovie(Long movieId) {
        Optional<Movie> movieObj = this.movieRepository.findById(movieId);
        if(movieObj.isPresent()){
            this.movieRepository.deleteById(movieId);
        } else {
            throw new RuntimeException("Movie not found with id " + movieId);
        }
    }
}
