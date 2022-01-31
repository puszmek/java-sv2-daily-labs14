package day02;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie){
        movies.add(movie);
    }

    // Add vissza azon filmek listáját amiben szerepel egy paraméterül átadott színész.

    public List<Movie> findMoviesContainsActor(String name){
        return movies.stream()
                .filter(m->m.getActors().contains(name))
                .toList();
    }

    // Add vissza a leghosszabb film hosszát

    public long findLengthOfLongestMovie(){
        return movies.stream()
                .mapToInt(Movie::getLength)
                .max()
                .orElseThrow(()->new IllegalStateException("List is Empty"));
    }
}