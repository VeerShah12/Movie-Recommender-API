package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Movies {

    @Id
    private int id;
    private int releaseYear;
    private String title;
    private String genre;
    private Double rating;
    private Double popularity;

    public int getId() {
        return id;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public Double getRating() {
        return rating;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReleaseYear(int releaseYear) {  // Changed setter name
        this.releaseYear = releaseYear;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    // Default constructor
    public Movies() {
    }

    // Parameterized Constructor
    public Movies(int id, int releaseYear, String title, String genre, Double rating, Double popularity) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.popularity = popularity;
    }
}