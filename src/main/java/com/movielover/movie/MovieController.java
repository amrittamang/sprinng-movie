package com.movielover.movie;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
    return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }
    @GetMapping("/{imdbId}")
   public ResponseEntity<Optional<Movie>> getMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.movie(imdbId), HttpStatus.OK);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<Movie>>getMovieById(@PathVariable String id) {
        return new ResponseEntity<>(movieService.getMovieById(id), HttpStatus.OK);
    }

    @PostMapping
    public void addNewMovie(@RequestBody Movie movie) {
        movieService.addNewMovie(movie);
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable String id) {
       movieService.deleteMovie(id);
    }

    @PutMapping("/{id}")
    public void updateMovie(@PathVariable("id") String id, @RequestParam String title) {
        movieService.updateMovie(id, title);
    }

}
