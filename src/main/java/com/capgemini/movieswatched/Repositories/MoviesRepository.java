package com.capgemini.movieswatched.Repositories;

import com.capgemini.movieswatched.Models.*;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie, Long> {

}