package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkipItemsByConditionTest {

    private SkipItemsByCondition skipItemsByCondition;

    @Before
    public void setUp() throws Exception {
        skipItemsByCondition = new SkipItemsByCondition();
    }

    @Test
    public void filterUsingIterator1() {
        Map<Integer, String> map = buildMap();

        Map<Integer, String> result = skipItemsByCondition.filterUsingIterator(map, key -> key % 2 == 1);

        assertThat(result.size(), is(1));
        assertThat(result.get(2), is("table"));
    }

    @Test
    public void filterUsingIterator2() {
        Map<Integer, String> map = buildMap();

        Map<Integer, String> result = skipItemsByCondition.filterUsingIterator(map, key -> key % 2 == 0);

        assertThat(result.size(), is(2));
        assertThat(result.get(1), is("penguin"));
        assertThat(result.get(3), is("bubble"));
    }

    @Test
    public void filterUsingRemoveIf1() {
        Map<Integer, String> map = buildMap();

        Map<Integer, String> result = skipItemsByCondition.filterUsingRemoveIf(map, key -> key % 2 == 1);

        assertThat(result.size(), is(1));
        assertThat(result.get(2), is("table"));
    }

    @Test
    public void filterUsingRemoveIf2() {
        Map<Integer, String> map = buildMap();

        Map<Integer, String> result = skipItemsByCondition.filterUsingRemoveIf(map, key -> key % 2 == 0);

        assertThat(result.size(), is(2));
        assertThat(result.get(1), is("penguin"));
        assertThat(result.get(3), is("bubble"));
    }

    private static HashMap<Integer, String> buildMap() {
        return new HashMap<>() {{
            put(1, "penguin");
            put(2, "table");
            put(3, "bubble");
        }};
    }
}
