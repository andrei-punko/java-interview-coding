package by.andd3dfx.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Implement the canViewAll() method, which given a collection of movies, checks if they all can be
 * viewed completely without overlap.
 * <p>
 * For example, for the movies below, the method should return true because they don't overlap:
 * <pre>
 * - 1/1/2015 20:00-21:30
 * - 1/1/2015 23:10-23:30
 * - 1/1/2015 21:30-23:00
 * </pre>
 */
public class MovieNight {

    public static boolean canViewAll(List<Movie> movies) {
        movies = new ArrayList<>(movies);
        Collections.sort(movies);

        for (int i = 1; i < movies.size(); i++) {
            if (movies.get(i - 1).end.after(movies.get(i).start)) {
                return false;
            }
        }

        return true;
    }

    @AllArgsConstructor
    @Getter
    public static class Movie implements Comparable<Movie> {
        private Date start, end;

        @Override
        public int compareTo(Movie movie) {
            if (start.before(movie.start)) {
                return -1;
            }
            if (start.after(movie.start)) {
                return 1;
            }
            return 0;
        }
    }
}
