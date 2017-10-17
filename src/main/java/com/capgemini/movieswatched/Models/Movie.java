package com.capgemini.movieswatched.Models;

public class Movie {
    private String name;
    private Boolean watched;

    public Movie() {
    }

    public Movie(String name, Boolean watched) {
        this.name = name;
        this.watched = watched;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getWatched() {
        return watched;
    }

    public void setWatched(Boolean watched) {
        this.watched = watched;
    }
}
