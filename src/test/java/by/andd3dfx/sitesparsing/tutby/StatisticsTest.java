package by.andd3dfx.sitesparsing.tutby;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    private Statistics statistics;

    @Before
    public void setUp() {
        statistics = new Statistics();
    }

    @Test
    public void testStatisticsCollector() {
        statistics.putKeyword("Java");
        statistics.putKeyword("Spring");
        statistics.putKeyword("Java");
        statistics.putKeyword("Spring");
        statistics.putKeyword("SQL");
        statistics.putKeyword("Spring");

        assertThat("Wrong amount of Java items", statistics.get("Java"), is(2));
        assertThat("Wrong amount of SQL items", statistics.get("SQL"), is(1));
        assertThat("Wrong amount of Spring items", statistics.get("Spring"), is(3));
        assertThat("Wrong amount of absent item", statistics.get("EJB"), is(nullValue()));

        final LinkedHashMap<String, Integer> map = statistics.buildSortedMap();
        final Set<Entry<String, Integer>> entries = map.entrySet();
        final Iterator<Entry<String, Integer>> iterator = entries.iterator();

        final Entry<String, Integer> entry1 = iterator.next();
        assertThat("Wrong first key", entry1.getKey(), is("Spring"));
        assertThat("Wrong first value", entry1.getValue(), is(3));

        final Entry<String, Integer> entry2 = iterator.next();
        assertThat("Wrong second key", entry2.getKey(), is("Java"));
        assertThat("Wrong second value", entry2.getValue(), is(2));

        final Entry<String, Integer> entry3 = iterator.next();
        assertThat("Wrong third key", entry3.getKey(), is("SQL"));
        assertThat("Wrong third value", entry3.getValue(), is(1));
    }
}
