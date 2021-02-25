package by.andd3dfx.interview.goldmansachs;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import by.andd3dfx.interview.goldmansachs.BestAverageScore.Item;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class BestAverageScoreTest {

    @Test
    public void calculate() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Name1", 80));
        items.add(new Item("Name2", 67));
        items.add(new Item("Name1", 60));

        assertThat(BestAverageScore.calculate(items), is(70.0));
    }

    @Test
    public void calculate2() {
        List<Item> items = new ArrayList<>();
        items.add(new Item("Name1", 80));
        items.add(new Item("Name2", 67));
        items.add(new Item("Name1", 60));

        assertThat(BestAverageScore.calculate2(items), is(70.0));
    }
}
