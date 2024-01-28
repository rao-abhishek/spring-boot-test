package com.abhishek.backendTest.Movie;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> allMovies(){
        return new ResponseEntity<List<Movie>>(movieService.getAllMovies(), HttpStatus.OK);
    }
    @GetMapping(params = {"imdbId"})
    public ResponseEntity<Optional<Movie>> getMovieByImdbId(@RequestParam String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbId(imdbId), HttpStatus.OK);
    }
    @GetMapping(params = {"imdbId", "releaseDate"})
    public ResponseEntity<Optional<Movie>> getMovieByImdbIdAndReleaseDate(@RequestParam String releaseDate, @RequestParam String imdbId){
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieByImdbIdAndReleaseDate(imdbId, releaseDate), HttpStatus.OK);
    }
}
