package com.capgemini.movieswatched.Controllers;

import com.capgemini.movieswatched.Models.Movie;
import com.capgemini.movieswatched.Repositories.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {

    @Autowired
    private MoviesRepository repository;

    /*
    * Get all movies from repository
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Movie> getAll(){
        return repository.findAll();
    }

    /*
    * Get one movie from the repository
     */
    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Movie get(@PathVariable long roomNumber){
        return repository.findOne(roomNumber);
    }

    /*
    * Add a new movie to the repository
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Movie post(@RequestBody Movie movie){
        return repository.save(movie);
    }

    /*
    * Update a movie from the repsitory
     */
    @RequestMapping(value = "/{movieId}/", method = RequestMethod.PUT)
    public Movie put(@RequestBody Movie movie, @PathVariable long movieId){
        Movie localMovie = repository.findById(movieId);
        localMovie.setName(movie.getName());
        localMovie.setWatched(movie.getWatched());
        repository.save(localMovie);
        return localMovie;
    }

    /*
    * Remove a movie from the repository
     */
    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable long roomNumber){
        repository.delete(roomNumber);
        return true;
    }

}
