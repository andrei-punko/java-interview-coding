package by.andd3dfx.sorting;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SortAnagramsTest {

    private SortAnagrams sortAnagrams;

    @Before
    public void setup() {
        sortAnagrams = new SortAnagrams();
    }

    @Test
    public void groupAnagrams() throws Exception {
        List<List<String>> result = sortAnagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

        assertThat("Size should be equal to 3", result.size(), is(3));
        checkListContent(result.get(0), new String[]{"ate", "eat", "tea"});
        checkListContent(result.get(1), new String[]{"nat", "tan"});
        checkListContent(result.get(2), new String[]{"bat"});
    }

    private void checkListContent(List<String> list, String[] array) {
        assertThat("Sizes of list and array should be the same", list.size(), is(array.length));
        for (int i = 0; i < list.size(); i++) {
            assertThat("Items should be the same for " + array[i], list.get(i).equals(array[i]), is(true));
        }
    }
}
