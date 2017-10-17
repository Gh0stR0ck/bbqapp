package com.capgemini.movieswatched.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String name;
    private Boolean watched;

    public Movie() {
    }

    public Movie(long id, String name, Boolean watched) {
        this.id = id;
        this.name = name;
        this.watched = watched;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
