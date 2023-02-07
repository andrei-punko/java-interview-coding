package by.andd3dfx.common;

import java.util.Collection;
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

  public static Boolean canViewAll(Collection<Movie> movies) {
    List<Movie> m = (List<Movie>) movies;
    Collections.sort(m);

    for (int i = 1; i < movies.size(); i++) {
      if (m.get(i - 1).getEnd().after(m.get(i).getStart())) {
        return false;
      }
    }

    return true;
  }

  public static class Movie implements Comparable<Movie> {

    private Date start, end;

    public Movie(Date start, Date end) {
      this.start = start;
      this.end = end;
    }

    public Date getStart() {
      return this.start;
    }

    public Date getEnd() {
      return this.end;
    }

    @Override
    public int compareTo(Movie m) {
      if (this.start.before(m.start)) {
        return -1;
      }
      if (this.start.after(m.start)) {
        return 1;
      }
      return 0;
    }
  }
}