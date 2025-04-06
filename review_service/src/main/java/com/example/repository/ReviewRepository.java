package com.example.repository;

import com.example.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // Search reviews by movie title
    @Query(value = "SELECT * FROM Review r JOIN movies m ON r.movieID = m.id WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))", nativeQuery = true)
    List<Review> findReviewsByMovieTitleContainingIgnoreCase(@Param("title") String title);

    // Search reviews by username
    @Query(value = "SELECT * FROM Review r JOIN user_entity u ON r.userID = u.id WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))", nativeQuery = true)
    List<Review> findReviewsByUsernameContainingIgnoreCase(@Param("username") String username);
}
