package com.springapps.jpaexamples.tememovies;

import com.springapps.jpaexamples.twitterapp.User;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
public class CharacterService {

    CharacterRepository characterRepository;
    MovieRepository movieRepository;
    @Autowired
    public CharacterService(CharacterRepository characterRepository, MovieRepository movieRepository) {
        this.characterRepository = characterRepository;
        this.movieRepository = movieRepository;
    }
    @Transactional
    public Movie addCharacterToMovie(Long movieId, Character character){
        Movie movie = movieRepository.findById(movieId).orElseThrow(()-> new EntityNotFoundException("ID nt found"));
        movie.getCharacters().add(character);
        character.getMovies().add(movie);
        return movieRepository.save(movie);
    }

}
