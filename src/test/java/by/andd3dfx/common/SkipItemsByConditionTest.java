package by.andd3dfx.common;

import by.andd3dfx.common.SkipItemsByCondition;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SkipItemsByConditionTest {

    private SkipItemsByCondition skipItemsByCondition;

    @Before
    public void setup() {
        skipItemsByCondition = new SkipItemsByCondition();
    }

    @Test
    public void filter1() throws Exception {
        Map<Integer, String> map = new HashMap<Integer, String>() {{
            put(1, "penguin");
            put(2, "table");
            put(3, "bubble");
        }};

        Map<Integer, String> result = skipItemsByCondition.filter(map, key -> key % 2 == 1);

        assertThat("One element expected", result.size(), is(1));
        assertThat("The 'table' item expected", result.get(2), is("table"));
    }

    @Test
    public void filter2() throws Exception {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("penguin", 1);
            put("table", 2);
            put("bubble", 3);
        }};

        Map<String, Integer> result = skipItemsByCondition.filter(map, key -> "penguin".equals(key));

        assertThat("Two elements expected", result.size(), is(2));
        assertThat("The 'table' item expected", result.get("table"), is(2));
        assertThat("The 'bubble' item expected", result.get("bubble"), is(3));
    }
}
