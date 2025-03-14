package com.example.repository;

import com.example.entity.Movies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MoviesRepository extends JpaRepository<Movies, Integer> {
    // Simple Search by movie title
    @Query("SELECT m FROM Movies m WHERE LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Movies> findByTitleContainingIgnoreCase(@Param("title") String title);

    // Advanced search with multiple optional parameters
    @Query("SELECT m FROM Movies m WHERE " +
            "(:title IS NULL OR LOWER(m.title) LIKE LOWER(CONCAT('%', :title, '%'))) AND " +
            "(:genre IS NULL OR LOWER(m.genre) = LOWER(:genre)) AND " +
            "(:releaseYear IS NULL OR m.releaseYear = :releaseYear) AND " +
            "(:aboveRating IS NULL OR m.rating >= :aboveRating)")
    List<Movies> findByMultipleParameters(
            @Param("title") String title,
            @Param("genre") String genre,
            @Param("releaseYear") Integer releaseYear,
            @Param("aboveRating") Double aboveRating);
}