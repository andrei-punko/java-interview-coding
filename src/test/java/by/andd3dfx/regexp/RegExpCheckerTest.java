package by.andd3dfx.regexp;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import by.andd3dfx.interview.wf.exam.Paragraph;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;

/**
 * For replacement example
 *
 * @see Paragraph#changeFormatAnotherWay(java.lang.String)
 */
public class RegExpCheckerTest {

    @Test
    public void repeatableExpressions() {
        assertThat("Color should be found",
            extractStringByRegExp("#[0-9A-Fa-f]{6}", "RGB color: #FF3E20"),
            is("#FF3E20"));
    }

    @Test
    public void digitAndSpaceAndWordBound() {
        assertThat("Amount of shirts should be found",
            extractStringByRegExp("\\d+", "We bought 2 shirts for 30$ and socks for 9$."),
            is("2"));
        assertThat("Amount of shirts should be found with space chars",
            extractStringByRegExp("\\s\\d+\\s", "We bought\t2 shirts for 30$ and socks for 9$."),
            is("\t2 "));
        assertThat("All text should be found (word bounds and hungry quantifiers)",
            extractStringByRegExp("\\w\\d+\\w", "We bought 2 shirts for 30$ and socks for 9$."),
            is("We bought 2 shirts for 30$ and socks for 9$."));
        assertThat("Amount of shirts should be found (word bounds and lazy quantifiers)",
            extractStringByRegExp("\\w?\\d+\\w?", "We bought\t2 shirts for 30$ and socks for 9$."),
            is("2"));
    }

    @Test
    public void reuseAlreadyDeclaredExpressionWithLink() {
        assertThat("Tag h1 with its content should be found",
            extractStringByRegExp("<([hH][1-6])>.*</\\1>", "Bla, some <h1>test string</h1> here."),
            is("<h1>test string</h1>"));
    }

    @Test
    public void lookForwardAndBackward() {
        assertThat("Color without '#' should be found",
            extractStringByRegExp("(?<=#)[0-9A-F]{6}", "RGB color: #FF3E20"),
            is("FF3E20"));
        assertThat("First price without '$' sign should be found",
            extractStringByRegExp("\\d+(?=\\$)", "We bought 2 shirts for 30$ and socks for 9$."),
            is("30"));
    }

    @Test
    public void compositeExpression() {
        assertThat("Phone in +ddd-dd-ddd-dd-dd format should be found",
            extractStringByRegExp("\\+\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}", "bla +375-29-861-86-28 bla-bla"),
            is("+375-29-861-86-28"));
        assertThat("Phone in +ddd-dd-ddd-dd-dd format should be found",
            extractStringByRegExp("\\(\\d{3}\\)\\d{2} \\d{3}-\\d{2}-\\d{2}", "bla (375)29 861-86-28 bla-bla"),
            is("(375)29 861-86-28"));

        assertThat("Phone in +ddd-dd-ddd-dd-dd format should be found for regex with 2 cases",
            extractStringByRegExp("((\\+\\d{3}-\\d{2})|(\\(\\d{3}\\)\\d{2}))[- ]\\d{3}-\\d{2}-\\d{2}",
                "bla +375-29-861-86-28 bla-bla"), is("+375-29-861-86-28"));
        assertThat("Phone in +ddd-dd-ddd-dd-dd format should be found for regex with 2 cases",
            extractStringByRegExp("((\\+\\d{3}-\\d{2})|(\\(\\d{3}\\)\\d{2}))[- ]\\d{3}-\\d{2}-\\d{2}",
                "bla (375)29 861-86-28 bla-bla"), is("(375)29 861-86-28"));
    }

    private String extractStringByRegExp(String regExp, String testString) {
        Pattern pattern = Pattern.compile(regExp);
        Matcher matcher = pattern.matcher(testString);
        if (matcher.find()) {
            return matcher.group();
        }
        return testString;
    }
}
