package com.example.controller;

import com.example.entity.Movies;
import com.example.service.MoviesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MoviesService moviesService;

    @GetMapping
    public List<Movies> getAllMovies() {
        return moviesService.getAllMovies();
    }

    @GetMapping("/{id}")
    public Movies getMoviesById(@PathVariable int id) {
        return moviesService.getMoviesById(id).orElseThrow();
    }

    // Simple title search
    @GetMapping("/search/title")
    public List<Movies> searchMoviesByTitle(@RequestParam String title) {
        return moviesService.searchMoviesByTitle(title);
    }

    // Advanced search with multiple optional parameters
    @GetMapping("/search")
    public List<Movies> searchMovies(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Integer releaseYear,
            @RequestParam(required = false) Double aboveRating) {
        return moviesService.searchMovies(title, genre, releaseYear, aboveRating);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public Movies createMovies(@RequestBody Movies movies) {
        return moviesService.saveMovies(movies);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public Movies updateMovies(@PathVariable int id, @RequestBody Movies moviesDetails) {
        return moviesService.updateMovies(id, moviesDetails);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public void deleteMovies(@PathVariable int id) {
        moviesService.deleteMovies(id);
    }
}