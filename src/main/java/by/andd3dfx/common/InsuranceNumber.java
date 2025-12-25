package by.andd3dfx.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * An insurance company has decided to change the format of its policy numbers from XXX-YY-ZZZZ to XXX/ZZZZ/YY
 * (where X, Y and Z each represent the digits 0-9). Write a method that re-format all policy numbers in a
 * well-formatted paragraph ('-' may appear elsewhere in the text).
 * <p>
 * For example, changeFormat("Please quote your policy number: 112-39-8552.") should return
 * "Please quote your policy number: 112/8552/39.".
 *
 * @see <a href="https://youtu.be/SdNLzjbXyo8">Video solution</a>
 */
public class InsuranceNumber {

    private static final Pattern PATTERN_1 = Pattern.compile("\\d{3}\n*-\n*\\d{2}\n*-\n*\\d{4}");
    private static final Pattern PATTERN_2 = Pattern.compile("(\\d{3}\n*)-(\n*\\d{2}\n*)-(\n*\\d{4})");

    public static String changeFormat(String paragraph) {
        Matcher matcher = PATTERN_1.matcher(paragraph);
        while (matcher.find()) {
            String s = matcher.group(0);
            String[] parts = s.split("-");
            String result = parts[0] + "/" + parts[2] + "/" + parts[1];
            paragraph = paragraph.replaceAll(matcher.group(0), result);
        }
        return paragraph;
    }

    public static String changeFormatUsingRegExGroups(String paragraph) {
        Matcher matcher = PATTERN_2.matcher(paragraph);
        while (matcher.find()) {
            paragraph = matcher.replaceAll("$1/$3/$2");
        }
        return paragraph;
    }
}
