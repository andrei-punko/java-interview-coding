package by.andd3dfx.common;

import by.andd3dfx.common.MovieNight.Movie;
import lombok.SneakyThrows;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import static by.andd3dfx.common.MovieNight.canViewAll;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovieNightTest {

    private final SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m");

    @Test
    public void canViewAllForEmptyList() {
        assertTrue(canViewAll(new ArrayList<>()));
    }

    @Test
    public void canViewAllForSingleMovie() {
        assertTrue(canViewAll(List.of(buildMovie("2023-01-01 20:00", "2023-01-01 21:00"))));
    }

    @Test
    public void canViewAllWhenNoOverlap() {
        assertTrue(canViewAll(List.of(
            buildMovie("2023-01-01 20:00", "2023-01-01 21:00"),
            buildMovie("2023-01-01 22:30", "2023-01-01 23:45"),
            buildMovie("2023-01-01 21:00", "2023-01-01 22:30"),
            buildMovie("2023-01-01 23:47", "2023-01-01 23:49")
        )));
    }

    @Test
    public void canViewAllWhenOverlapPresent() {
        assertFalse(canViewAll(List.of(
            buildMovie("2023-01-01 20:00", "2023-01-01 22:00"),
            buildMovie("2023-01-01 22:30", "2023-01-01 23:45"),
            buildMovie("2023-01-01 21:45", "2023-01-01 22:30")
        )));
    }

    @SneakyThrows
    private Movie buildMovie(String start, String end) {
        return new Movie(sdf.parse(start), sdf.parse(end));
    }
}
