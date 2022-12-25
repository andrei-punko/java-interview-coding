package by.andd3dfx.interview.exam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An insurance company has decided to change the format of its policy numbers from XXX-YY-ZZZZ to XXX/ZZZZ/YY
 * (where X, Y and Z each represent the digits 0-9). Write a method that re-format all policy numbers in a
 * well-formatted paragraph ('-' may appear elsewhere in the text).
 * <p>
 * For example, changeFormat("Please quote your number: 112-39-8552.") should return
 * "Please quote your policy number: 112/8552/39".
 */
public class Paragraph {

  private static final String PATTERN_1 = "\\d\n*\\d\n*\\d\n*-\n*\\d\n*\\d\n*-\n*\\d\n*\\d\n*\\d\n*\\d";
  private static final String PATTERN_2 = "(\\d{3}[^-]*)-([^-]*\\d{2}[^-]*)-([^-]*\\d{4})";

  public static String changeFormat(String paragraph) {
    Pattern p = Pattern.compile(PATTERN_1);
    Matcher m = p.matcher(paragraph);
    while (m.find()) {
      String s = m.group(0);
      String[] parts = s.split("-");
      String result = parts[0] + "/" + parts[2] + "/" + parts[1];
      paragraph = paragraph.replaceAll(m.group(0), result);
    }
    return paragraph;
  }

  public static String changeFormat2(String paragraph) {
    Pattern p = Pattern.compile(PATTERN_2);
    Matcher m = p.matcher(paragraph);
    while (m.find()) {
      paragraph = m.replaceAll("$1/$3/$2");
    }
    return paragraph;
  }
}
