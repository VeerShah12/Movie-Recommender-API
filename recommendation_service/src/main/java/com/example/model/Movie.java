package com.example.model;

public class Movie {

    private int id;
    private int releaseYear;
    private String title;
    private String genre;
    private Double rating;
    private Double popularity;

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie(){
    };

    public Movie(int id, int releaseYear, String title, String genre, Double rating, Double popularity) {
        this.id = id;
        this.releaseYear = releaseYear;
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.popularity = popularity;
    }
}
