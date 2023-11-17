package com.movielover.movie;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findMovieByImdbId(String imdbId);

    // @Query("SELECT s FROM Movie s WHERE s.email = ?1");
    Optional<Movie> findMovieByTitle(String title);

    void deleteById(String id);
}
