package by.andd3dfx.interview.wf.exam;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import org.junit.Test;

public class HobbiesTest {

  @Test
  public void findHobbyists() {
    Hobbies hobbies = new Hobbies();
    hobbies.add("John", "Piano", "Puzzles", "Yoga");
    hobbies.add("Adam", "Drama", "Fashion", "Pets");
    hobbies.add("Mary", "Magic", "Pets", "Reading");

    List<String> yogaHobbyists = hobbies.findHobbyists("Yoga");
    assertThat("One yoga hobbyist expected", yogaHobbyists.size(), is(1));
    assertThat("Only John expected", yogaHobbyists, hasItem("John"));

    List<String> petHobbyists = hobbies.findHobbyists("Pets");
    assertThat("Two pet hobbyists expected", petHobbyists.size(), is(2));
    assertThat("Adam and Mary expected", petHobbyists, hasItems("Adam", "Mary"));
  }
}
