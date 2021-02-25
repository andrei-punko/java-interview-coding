package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import by.andd3dfx.interview.wf.exam.MovieNight.Movie;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.junit.Test;

public class MovieNightTest {

  @Test
  public void canViewAll() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");
    ArrayList<Movie> movies = new ArrayList<Movie>();
    movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
    movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
    movies.add(new Movie(sdf.parse("2015-01-01 21:30"), sdf.parse("2015-01-01 23:00")));

    assertThat("True expected", MovieNight.canViewAll(movies), is(true));
  }

  @Test
  public void canViewAllWithOverlap() throws ParseException {
    SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");
    ArrayList<Movie> movies = new ArrayList<Movie>();
    movies.add(new Movie(sdf.parse("2015-01-01 20:00"), sdf.parse("2015-01-01 21:30")));
    movies.add(new Movie(sdf.parse("2015-01-01 23:10"), sdf.parse("2015-01-01 23:30")));
    movies.add(new Movie(sdf.parse("2015-01-01 23:20"), sdf.parse("2015-01-01 23:40")));

    assertThat("False expected", MovieNight.canViewAll(movies), is(false));
  }
}
