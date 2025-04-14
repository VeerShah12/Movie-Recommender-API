package com.example.controller;

import com.example.entity.Movie;
import com.example.service.RecommendationService;
import com.example.service.TrailerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/recommend/ui")
public class RecommendationUiController {

    @Autowired
    private RecommendationService recommendationService;

    @Autowired
    private TrailerService trailerService;

    @GetMapping("/title/{title}")
    public String recommendByTitle(@PathVariable String title, Model model) {
        List<Movie> recommendedMovies = recommendationService.recommendByTitle(title);

        recommendedMovies.forEach(movie -> {
            String trailerUrl = trailerService.getTrailerUrlForMovie(movie.getId());
            movie.setTrailerUrl(trailerUrl);
        });

        model.addAttribute("movies", recommendedMovies);
        model.addAttribute("queryTitle", title);
        return "recommendations";
    }
    @GetMapping("/preferences")
    public String showPreferencesForm() {
        return "preferences-form";
    }

    @GetMapping("/results")
    public String recommendByPreferences(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Double minRating,
            @RequestParam(required = false) Double minPopularity,
            Model model) {

        List<Movie> recommendedMovies = recommendationService.recommendByPreferences(genre, minRating, minPopularity);

        recommendedMovies.forEach(movie -> {
            String trailerUrl = trailerService.getTrailerUrlForMovie(movie.getId());
            movie.setTrailerUrl(trailerUrl);
        });

        model.addAttribute("movies", recommendedMovies);
        model.addAttribute("genre", genre);
        model.addAttribute("minRating", minRating);
        model.addAttribute("minPopularity", minPopularity);

        return "preferences-results";
    }

}
