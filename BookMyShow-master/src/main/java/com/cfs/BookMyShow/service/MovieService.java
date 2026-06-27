package com.cfs.BookMyShow.service;


import com.cfs.BookMyShow.entity.Movie;
import com.cfs.BookMyShow.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;

    public Movie addMovie(Movie movie){
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies(){
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id){
        return movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with id : "+id));
    }

    public List<Movie> searchByTitle(String title){
        return movieRepository.findByTitleContainingIgnoreCase(title);
    }

    public List<Movie> getByGenre(String genre){
        return movieRepository.findByGenre(genre);
    }
    public List<Movie> getByLanguage(String language){
        return movieRepository.findByLanguage(language);
    }

    
    

    public Movie updateMovie(Long id,Movie movie){
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Movie not found with id : "+id));

        existingMovie.setDescription(movie.getDescription());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setRating(movie.getRating());
        existingMovie.setReleaseDate(movie.getReleaseDate());
        existingMovie.setDurationMinutes(movie.getDurationMinutes());

        return movieRepository.save(existingMovie);

    }

}
