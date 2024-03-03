package com.springapps.jpaexamples.tememovies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {
    CharacterService characterService;
    MovieService movieService;
    @Autowired
    public Runner(CharacterService characterService, MovieService movieService) {
        this.characterService = characterService;
        this.movieService = movieService;
    }

    @Override
    public void run(String... args) throws Exception {
        Character character = new Character("Jamie Fox");
        Movie movie = new Movie("The blind man");
        Movie savedMovie = movieService.addMovie(movie);
        characterService.addCharacterToMovie(savedMovie.getMovieId(),character);
    }
}
