package com.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "movie_trailers")
public class MovieTrailer {

    @Id
    private int id;
    private int movieId;
    private String youtubeUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getYoutubeUrl() {
        return youtubeUrl;
    }

    public void setYoutubeUrl(String youtubeUrl) {
        this.youtubeUrl = youtubeUrl;
    }

    public MovieTrailer(){
    };
}
