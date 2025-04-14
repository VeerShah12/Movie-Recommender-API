package com.example.repository;

import com.example.entity.MovieTrailer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieTrailerRepository extends JpaRepository<MovieTrailer, Integer> {
    Optional<MovieTrailer> findFirstByMovieId(int movieId);
}
