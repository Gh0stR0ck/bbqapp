package com.capgemini.movieswatched.Controllers;

import com.capgemini.movieswatched.Repositories.MoviesRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/movies")
public class MoviesController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String Get(){
        return "Test";
    }

    /*@Autowired
    private MoviesRepository repository;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Iterable<Movie> Post(@RequestBody Movie room){
        repository.save(room);
        return repository.findAll();
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.PUT)
    public Iterable<Movie> Put(@RequestBody Movie room, @PathVariable long roomNumber){
        repository.save(room);
        return repository.findAll();
    }


    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.GET)
    public Movie Get(@PathVariable long roomNumber){
        return repository.findOne(roomNumber);
    }

    @RequestMapping(value = "/{roomNumber}/", method = RequestMethod.DELETE)
    public Boolean Delete(@PathVariable long roomNumber){
        repository.delete(roomNumber);
        return true;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public Iterable<Movie> GetAll(){
        return repository.findAll();
    }*/

}
