package com.springapps.jpaexamples.tememovies;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name= "movies")
public class Movie {

    //Un film contine mai multe caracatere, iar un caracter poate juca in mai multe filme. Un film poate apartine unei francize,
    // iar o franciza poate contine mai multe filme. De exemplu, franciza Marvel contine 23 de filme.


    @Id
    @GeneratedValue
    private long movieId;
    @Column
    private String name;

    @ManyToMany(mappedBy = "movies", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Character> characters;

    @ManyToOne
    @JoinColumn(name= "francise_id")
    private Francise francise;

//    @OneToMany(mappedBy = "movie")
//    private Set<MovieCharacters> movieCharacters;


    public Movie(String name) {
        this.name = name;
    }

    public Movie() {
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Character> getCharacters() {
        if(characters==null){
            characters=new HashSet<>();
        }
        return characters;
    }

    public void setCharacters(Set<Character> characters) {
        this.characters = characters;
    }

//    public Set<MovieCharacters> getMovieCharacters() {
//        return movieCharacters;
//    }
//
//    public void setMovieCharacters(Set<MovieCharacters> movieCharacters) {
//        this.movieCharacters = movieCharacters;
//    }

    public Francise getFrancise() {
        return francise;
    }

    public void setFrancise(Francise francise) {
        this.francise = francise;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "Id=" + movieId +
                ", name='" + name + '\'' +
                '}';
    }
}
