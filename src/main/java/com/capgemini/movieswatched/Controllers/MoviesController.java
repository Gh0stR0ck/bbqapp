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
    @RequestMapping(value = "/{movieId}/", method = RequestMethod.GET)
    public Movie get(@PathVariable long movieId){
        return repository.findOne(movieId);
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
    public Boolean delete(@PathVariable long movieId){
        repository.delete(movieId);
        return true;
    }

    /*
    * Set movie as watched
     */
    @RequestMapping(value = "/watched/{movieId}/", method = RequestMethod.PUT)
    public Movie movieWatched(@PathVariable long movieId){
        Movie localMovie = repository.findById(movieId);
        localMovie.setWatched(true);
        repository.save(localMovie);
        return localMovie;
    }

    /*
    * Set movie as not watched
    */
    @RequestMapping(value = "/unwatched/{movieId}/", method = RequestMethod.PUT)
    public Movie movieUnwatched(@PathVariable long movieId){
        Movie localMovie = repository.findById(movieId);
        localMovie.setWatched(false);
        repository.save(localMovie);
        return localMovie;
    }
}
