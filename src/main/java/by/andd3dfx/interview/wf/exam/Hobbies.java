package by.andd3dfx.interview.wf.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Hobbies {

  private final HashMap<String, List<String>> hobbyists = new HashMap<>();
  private final HashMap<String, String[]> hobbyToPersonsMap = new HashMap<>();

  public static void main(String[] args) {
    Hobbies hobbies = new Hobbies();
    hobbies.add("John", "Piano", "Puzzles", "Yoga");
    hobbies.add("Adam", "Drama", "Fashion", "Pets");
    hobbies.add("Mary", "Magic", "Pets", "Reading");

    System.out.println(Arrays.toString(hobbies.findHobbyists("Yoga").toArray()));
  }

  public void add(String hobbyist, String... hobbies) {
    for (String hobby : hobbies) {
      if (hobby != null && !hobby.isEmpty()) {
        addHobbyist(hobby, hobbyist);
      }
    }
    hobbyToPersonsMap.put(hobbyist, hobbies);
  }

  public void addHobbyist(String h, String hobbyist) {
    if (hobbyist != null) {
      if (hobbyists.containsKey(h)) {
        hobbyists.get(h).add(hobbyist);
      } else {
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add(hobbyist);
        hobbyists.put(h, arrayList);
      }
    }
  }

  public List<String> findHobbyists(String hobby) {
    if (hobby == null || hobby.isEmpty() || !hobbyists.containsKey(hobby)) {
      return new ArrayList();
    }
    return hobbyists.get(hobby);
  }
}
