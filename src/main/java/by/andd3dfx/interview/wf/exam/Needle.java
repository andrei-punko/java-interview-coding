package by.andd3dfx.interview.wf.exam;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Needle {

  public static int count(String needle, InputStream haystack) throws Exception {
    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(haystack));
    String line;
    int count = 0;
    while ((line = bufferedReader.readLine()) != null) {
      if (line.contains(needle)) {
        count++;
      }
    }
    return count;
  }

  public static void main(String[] args) throws Exception {
    String inMessage = "Hello, 1!\nHow are you today?\nYes, you over there.";

    try (InputStream inStream = new ByteArrayInputStream(inMessage.getBytes())) {
      System.out.println(Needle.count("there", inStream));
    }
  }
}
