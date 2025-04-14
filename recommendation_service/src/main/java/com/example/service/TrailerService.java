package com.example.service;

import com.example.repository.MovieTrailerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrailerService {

    @Autowired
    private MovieTrailerRepository trailerRepository;

    public String getTrailerUrlForMovie(int movieId) {
        return trailerRepository.findFirstByMovieId(movieId)
                .map(t -> t.getYoutubeUrl())
                .orElse(null);
    }
}
