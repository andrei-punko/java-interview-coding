package by.andd3dfx.interview.wf.exam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

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

  public static void main(String[] args) throws Exception {
    SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

    ArrayList<Movie> movies = new ArrayList<Movie>();
    movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
    movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
    movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

    System.out.println(MovieNight.canViewAll(movies));
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