package com.cfs.BookMyShow.controller;

import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@RequiredArgsConstructor

public class MovieController {

    private final MovieService movieService;

    @PostMapping
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movieRequest){
        return ResponseEntity.ok(movieService.addMovie(movieRequest));
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovie(){
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam String title) {
        return ResponseEntity.ok(movieService.searchByTitle(title));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<Movie>> getByGenre(@PathVariable String genre) {
        return ResponseEntity.ok(movieService.getByGenre(genre));
    }

    @GetMapping("/genre/{language}")
    public ResponseEntity<List<Movie>> getByLanguage(@PathVariable String language) {
        return ResponseEntity.ok(movieService.getByLanguage(language));
    }

}
