package com.abhishek.backendTest.Movie;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> getAllMovies()
    {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieByImdbId(String imdbId)
    {
        return movieRepository.getMovieByImdbId(imdbId);
    }

    public Optional<Movie> getMovieByImdbIdAndReleaseDate(String imdbId, String releaseDate)
    {
        return movieRepository.getMovieByImdbIdAndReleaseDate(imdbId,releaseDate);
    }

    public void saveMovie(Movie movie) {
        movieRepository.save(movie);
    }
}
