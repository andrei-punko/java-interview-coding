package by.andd3dfx.interview.wf.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Paragraph {

  private static final String PATTERN = "\\d[\n]*\\d[\n]*\\d[\n]*-[\n]*\\d[\n]*\\d[\n]*-[\n]*\\d[\n]*\\d[\n]*\\d[\n]*\\d";

  public static String changeFormat(String paragraph) {
    Pattern p = Pattern.compile(PATTERN);
    Matcher m = p.matcher(paragraph);
    while (m.find()) {
      String s = m.group(0);
      String[] parts = s.split("-");
      String result = parts[0] + "/" + parts[2] + "/" + parts[1];
      paragraph = paragraph.replaceAll(m.group(0), result);
    }
    return paragraph;
  }

  public static String changeFormatAnotherWay(String paragraph) {
    Pattern p = Pattern.compile("(\\d{3}[^-]*)-([^-]*\\d{2}[^-]*)-([^-]*\\d{4})");
    Matcher m = p.matcher(paragraph);
    while (m.find()) {
      paragraph = m.replaceAll("$1/$3/$2");
    }
    return paragraph;
  }

  public static void main(String[] args) {
    System.out.println(changeFormatAnotherWay("Please quote your policy number: 112-39-8552."));
    System.out.println(changeFormatAnotherWay("Please quote your policy number: 112-39-\n8552."));
  }
}
