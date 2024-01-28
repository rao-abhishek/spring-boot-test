package com.abhishek.backendTest.Movie;

import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, ObjectId> {

    public Optional<Movie> getMovieByImdbId(String imdbId);
    public Optional<Movie> getMovieByImdbIdAndReleaseDate(String imdbId, String releaseDate);
} 
