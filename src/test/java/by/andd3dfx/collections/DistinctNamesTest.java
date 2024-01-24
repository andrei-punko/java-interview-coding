package by.andd3dfx.collections;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static by.andd3dfx.collections.DistinctNames.way1;
import static by.andd3dfx.collections.DistinctNames.way2;
import static org.assertj.core.api.Assertions.assertThat;

public class DistinctNamesTest {

    private List<DistinctNames.Person> persons;

    @Before
    public void setUp() throws Exception {
        persons = List.of(
                new DistinctNames.Person(List.of("A", "B", "C")),
                new DistinctNames.Person(List.of("B")),
                new DistinctNames.Person(List.of("B", "C")),
                new DistinctNames.Person(List.of("A", "A", "D")),
                new DistinctNames.Person(List.of()),
                new DistinctNames.Person(List.of("D", "X"))
        );
    }

    @Test
    public void testWay1() {
        assertThat(way1(persons)).containsExactly("A", "B", "C", "D", "X");
    }

    @Test
    public void testWay2() {
        assertThat(way2(persons)).containsExactly("A", "B", "C", "D", "X");
    }
}
