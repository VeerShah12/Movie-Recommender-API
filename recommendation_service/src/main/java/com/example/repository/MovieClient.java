package com.example.repository;

import com.example.entity.Movie;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "MOVIE-SERVICE", url = "http://localhost:8082")
public interface MovieClient {
    @GetMapping("/movies")
    List<Movie> getAllMovies();

    @GetMapping("/search/title")
    List<Movie> searchByTitle(@RequestParam String title);
}
