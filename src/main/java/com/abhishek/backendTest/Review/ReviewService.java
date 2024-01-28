package com.abhishek.backendTest.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abhishek.backendTest.Movie.Movie;
import com.abhishek.backendTest.Movie.MovieService;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MovieService movieService;

    @Transactional
    public Review createReview(String reviewBody, String imdbId){
        Review review = new Review(reviewBody);

        reviewRepository.insert(review);
        Movie movie = movieService.getMovieByImdbId(imdbId).get();
        movie.getReviewIds().add(review);
        movieService.saveMovie(movie);
        return review;
    }
}
