package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class EntryTest {

  @Test
  public void test() {
    Entry entry = new Entry();
    entry.enter("AB54321");
    entry.enter("UK32032");
    assertThat("First element expected", entry.exit(), is("AB54321"));
    assertThat("Second element expected", entry.exit(), is("UK32032"));
    assertThat("Null expected", entry.exit(), nullValue());
  }
}
