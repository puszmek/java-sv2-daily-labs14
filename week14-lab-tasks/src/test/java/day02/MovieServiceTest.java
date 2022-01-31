package day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieServiceTest {

    @Test
    void testMovieService(){
        MovieService movieService = new MovieService();
        Movie m1 = new Movie("Hold", 96, List.of("Jakab Péter", "Cseh Janka"));
        Movie m2 = new Movie("Nap", 102, List.of("Tóth Imre", "Fehér Tímea"));
        Movie m3 = new Movie("Bolygó", 88, List.of("Tóth Imre", "Jakab Péter"));

        movieService.addMovie(m1);
        movieService.addMovie(m2);
        movieService.addMovie(m3);

        assertEquals(102, movieService.findLengthOfLongestMovie());
        assertEquals(List.of(m1, m3), movieService.findMoviesContainsActor("Jakab Péter"));
    }
}