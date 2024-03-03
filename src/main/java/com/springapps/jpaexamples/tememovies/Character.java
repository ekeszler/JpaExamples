package com.springapps.jpaexamples.tememovies;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name= "characters")
public class Character {
    @Id
    @GeneratedValue
    private long characterId;

    @Column
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "movies_characters",
            joinColumns = @JoinColumn(name = "character_id"),
            inverseJoinColumns = @JoinColumn(name="movie_id")
    )
    private Set<Movie> movies;

//    @OneToMany(mappedBy = "character")
//    private Set<MovieCharacters> movieCharacters;

    public Character(String name) {
        this.name = name;
    }

    public Character() {
    }

    public long getCharacterId() {
        return characterId;
    }

    public void setCharacterId(long characterId) {
        this.characterId = characterId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getMovies() {
        if (movies == null){
            movies= new HashSet<>();
        }
        return movies;
    }

    public void setMovies(Set<Movie> movies) {
        this.movies = movies;
    }


//    public Set<MovieCharacters> getMovieCharacters() {
//        return movieCharacters;
//    }
//
//    public void setMovieCharacters(Set<MovieCharacters> movieCharacters) {
//        this.movieCharacters = movieCharacters;
//    }

    @Override
    public String toString() {
        return "Character{" +
                "Id=" + characterId +
                ", name='" + name + '\'' +
                '}';
    }
}
