package by.andd3dfx.numeric;

import by.andd3dfx.numeric.BestAverageScore.Item;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BestAverageScoreTest {

    @Test
    public void calculateUsingStreams() {
        var items = buildItemsList();
        var items2 = buildBigItemsList();

        assertThat(BestAverageScore.calculateUsingStreams(items), is(70.0));
        assertThat(BestAverageScore.calculateUsingStreams(items2), is(500.0));
    }

    @Test
    public void calculateUsualWay() {
        var items = buildItemsList();
        var items2 = buildBigItemsList();

        assertThat(BestAverageScore.calculateUsualWay(items), is(70.0));
        assertThat(BestAverageScore.calculateUsualWay(items2), is(500.0));
    }

    private List<Item> buildItemsList() {
        return List.of(
                new Item("Name1", 80),
                new Item("Name2", 67),
                new Item("Name1", 60)
        );
    }

    private List<Item> buildBigItemsList() {
        return List.of(
                new Item("Name1", 80),
                new Item("Name2", 400),
                new Item("Name2", 600),
                new Item("Name1", 60),
                new Item("Name1", 55),
                new Item("Name2", 100),
                new Item("Name2", 900),
                new Item("Name1", 85)
        );
    }
}
