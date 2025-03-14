package com.example.service;

import com.example.entity.Movies;
import com.example.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MoviesService {

    @Autowired
    private MoviesRepository moviesRepository;

    public List<Movies> getAllMovies() {
        return moviesRepository.findAll();
    }

    public Optional<Movies> getMoviesById(int id) {
        return moviesRepository.findById(id);
    }

    // Simple title search
    public List<Movies> searchMoviesByTitle(String title) {
        return moviesRepository.findByTitleContainingIgnoreCase(title);
    }

    // Advanced search with multiple parameters
    public List<Movies> searchMovies(String title, String genre, Integer releaseYear, Double aboveRating) {
        return moviesRepository.findByMultipleParameters(title, genre, releaseYear, aboveRating);
    }

    public Movies saveMovies(Movies movies) {
        return moviesRepository.save(movies);
    }

    public void deleteMovies(int id) {
        moviesRepository.deleteById(id);
    }

    public Movies updateMovies(int id, Movies movieDetails) {
        Movies movies = moviesRepository.findById(id).orElseThrow();
        movies.setTitle(movieDetails.getTitle());
        movies.setGenre(movieDetails.getGenre());
        movies.setReleaseYear(movieDetails.getReleaseYear());
        movies.setRating(movieDetails.getRating());
        movies.setPopularity(movieDetails.getPopularity());
        return moviesRepository.save(movies);
    }
}