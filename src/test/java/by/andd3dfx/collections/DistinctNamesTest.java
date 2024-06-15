package by.andd3dfx.collections;

import by.andd3dfx.collections.DistinctNames.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static by.andd3dfx.collections.DistinctNames.way1;
import static by.andd3dfx.collections.DistinctNames.way2;
import static org.assertj.core.api.Assertions.assertThat;

public class DistinctNamesTest {

    private List<Person> persons;

    @Before
    public void setUp() throws Exception {
        persons = List.of(
                new Person(List.of("A", "B", "C")),
                new Person(List.of("B")),
                new Person(List.of("B", "C")),
                new Person(List.of("A", "A", "D")),
                new Person(List.of()),
                new Person(List.of("D", "X"))
        );
    }

    @Test
    public void testWay1() {
        assertThat(way1(persons))
                .containsExactlyInAnyOrder("A", "B", "D", "C", "X");
    }

    @Test
    public void testWay2() {
        assertThat(way2(persons))
                .containsExactlyInAnyOrder("A", "B", "D", "C", "X");
    }
}