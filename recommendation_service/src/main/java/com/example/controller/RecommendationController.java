package com.example.controller;

import com.example.model.Movie;
import com.example.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/title/{title}")
    public List<Movie> recommendByTitle(@PathVariable String title) {
        return recommendationService.recommendByTitle(title);
    }

    @GetMapping("/preference")
    public List<Movie> recommendByPreferences(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Double minPopularity) {
        return recommendationService.recommendByPreferences(genre, minRating, minPopularity);
    }
}
