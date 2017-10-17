package com.capgemini.movieswatched;

import com.capgemini.movieswatched.Controllers.MoviesController;
import com.capgemini.movieswatched.Repositories.MoviesRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import com.capgemini.movieswatched.Models.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieswatchedApplicationTests {

	@InjectMocks
	private MoviesController moviesController;

	@Mock
	private MoviesRepository moviesRepository;

	@Mock
	private Movie mockMovie;

	@Test
	public void getAll() throws Exception {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Film 1", false));
        movieList.add(new Movie("Film 2", false));

	    when(moviesRepository.findAll()).thenReturn(movieList);

        assertEquals(movieList, moviesController.getAll());
    }

    @Test
    public void get() throws Exception {
        Movie movie = new Movie("Film 3", false);
        long movieId = 1;

        when(moviesRepository.findOne(movieId)).thenReturn(movie);

        assertEquals(movie, moviesController.get(1));
    }

    @Test
    public void post() throws Exception {
        Movie movie = new Movie("Film 4", false);

        when(moviesRepository.save(movie)).thenReturn(movie);

        assertEquals(movie, moviesController.post(movie));
    }

    @Test
    public void put() throws Exception {
        Movie oldMovie = new Movie("Film 5", false);
        Movie newMovie = new Movie("Film 6", false);
        long movieId = 1;

        when(moviesRepository.findById(movieId)).thenReturn(oldMovie);
        when(moviesRepository.save(newMovie)).thenReturn(newMovie);

        assertEquals(oldMovie, moviesController.put(newMovie, movieId));
    }

    /*
    @Test
    public void delete() throws Exception {
        Movie oldMovie = new Movie("Film 5", false);
        Movie newMovie = new Movie("Film 6", false);
        long movieId = 1;

        //Wil niet werken ivm void waarde
        when(moviesRepository.delete(movieId));

        verify(moviesRepository,times(1)).delete(movieId);
    }
    */

    @Test
    public void movieWatched() throws Exception {
        Movie oldMovie = new Movie("Blade", false);
        Movie newMovie = new Movie("Blade", true);
        long movieId = 1;

        when(moviesRepository.findById(movieId)).thenReturn(oldMovie);
        when(moviesRepository.save(newMovie)).thenReturn(newMovie);

        assertEquals(oldMovie, moviesController.movieWatched(movieId));
    }

    @Test
    public void movieUnwatched() throws Exception {
        Movie oldMovie = new Movie("Matrix", true);
        Movie newMovie = new Movie("Matrix", false);
        long movieId = 1;

        when(moviesRepository.findById(movieId)).thenReturn(oldMovie);
        when(moviesRepository.save(newMovie)).thenReturn(newMovie);

        assertEquals(oldMovie, moviesController.movieWatched(movieId));
    }

}
