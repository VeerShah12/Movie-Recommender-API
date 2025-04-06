package com.example.controller;

import com.example.entity.Review;
import com.example.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public List<Review> getAllReview() {
        return reviewService.getAllReview();
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable int id) {
        return reviewService.getReviewById(id).orElseThrow();
    }

    // Title search
    @GetMapping("/search/title")
    public List<Review> searchReviewByTitle(@RequestParam String title) {
        return reviewService.searchReviewByTitle(title);
    }
    // Username search
    @GetMapping("/search/username")
    public List<Review> searchReviewByUsername(@RequestParam String username) {
        return reviewService.searchReviewByUsername(username);
    }


    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return reviewService.saveReview(review);
    }

    @PutMapping("/{id}")
    public Review updateReview(@PathVariable int id, @RequestBody Review reviewDetails) {
        return reviewService.updateReview(id, reviewDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable int id) {
        reviewService.deleteReview(id);
    }
}