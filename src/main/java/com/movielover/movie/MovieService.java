package com.movielover.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> movie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }

    public Optional<Movie> getMovieById(String id) {
        return movieRepository.findById(id);
    }

    public void addNewMovie(Movie movie) {
        Optional<Movie> movieByTitle = movieRepository.findMovieByTitle(movie.getTitle());
        if (movieByTitle.isPresent()) {
            throw new IllegalStateException("title taken");
        }
        // System.out.println(movie);
        movieRepository.save(movie);
    }

    public void deleteMovie(String id) {
        Optional<Movie> movie = movieRepository.findById(id);
        if(!movie.isPresent()){
            throw new IllegalStateException("Movie not found!");
        }
        movieRepository.deleteById(id);
    }

    //Update movie - use @Transactional annotation


}
