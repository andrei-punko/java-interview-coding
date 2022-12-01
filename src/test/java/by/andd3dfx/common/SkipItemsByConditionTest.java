package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SkipItemsByConditionTest {

    private SkipItemsByCondition skipItemsByCondition;

    @Before
    public void setUp() throws Exception {
        skipItemsByCondition = new SkipItemsByCondition();
    }

    @Test
    public void filter1() {
        Map<Integer, String> map = buildMap();

        Map<Integer, String> result = skipItemsByCondition.filter(map, key -> key % 2 == 1);

        assertThat(result.size(), is(1));
        assertThat(result.get(2), is("table"));
    }

    @Test
    public void filter2() {
        Map<Integer, String> map = buildMap();

        Map<Integer, String> result = skipItemsByCondition.filter(map, key -> key % 2 == 0);

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
