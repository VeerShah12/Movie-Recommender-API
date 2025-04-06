package com.example.service;

import com.example.entity.Review;
import com.example.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAllReview() {
        return reviewRepository.findAll();
    }

    public Optional<Review> getReviewById(int id) {
        return reviewRepository.findById(id);
    }

    // Simple title search
    public List<Review> searchReviewByTitle(String title) {
        return reviewRepository.findReviewsByMovieTitleContainingIgnoreCase(title);
    }

    // Simple username search
    public List<Review> searchReviewByUsername(String username) {
        return reviewRepository.findReviewsByUsernameContainingIgnoreCase(username);
    }
    public Review saveReview(Review review) {
        return reviewRepository.save(review);
    }

    public void deleteReview(int id) {
        reviewRepository.deleteById(id);
    }

    public Review updateReview(int id, Review reviewDetails) {
        Review review = reviewRepository.findById(id).orElseThrow();
        review.setUserID(reviewDetails.getUserID());
        review.setMovieID(reviewDetails.getMovieID());
        review.setRating(reviewDetails.getRating());
        review.setComment(reviewDetails.getComment());
        return reviewRepository.save(review);
    }
}