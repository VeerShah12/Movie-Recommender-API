package com.example.service;

import com.example.repository.MovieClient;
import com.example.entity.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RecommendationService {

    @Autowired
    private MovieClient movieClient;

    public List<Movie> recommendByTitle(String title) {
        List<Movie> allMovies = movieClient.getAllMovies();
        Movie inputMovie = allMovies.stream()
                .filter(m -> m.getTitle().equalsIgnoreCase(title))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        return allMovies.stream()
                .filter(m -> !m.getTitle().equalsIgnoreCase(title))
                .filter(m -> m.getGenre().equalsIgnoreCase(inputMovie.getGenre()))
                .sorted(Comparator.comparingDouble(m ->
                        Math.abs(m.getRating() - inputMovie.getRating()) +
                                Math.abs(m.getPopularity() - inputMovie.getPopularity())))
                .limit(5)
                .collect(Collectors.toList());
    }

    public List<Movie> recommendByPreferences(String genre, Double minRating, Double minPopularity) {
        return movieClient.getAllMovies().stream()
                .filter(m -> genre == null || m.getGenre().equalsIgnoreCase(genre))
                .filter(m -> minRating == null || m.getRating() >= minRating)
                .filter(m -> minPopularity == null || m.getPopularity() >= minPopularity)
                .sorted(Comparator.comparing(Movie::getRating).reversed()
                        .thenComparing(Movie::getPopularity).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }
}
