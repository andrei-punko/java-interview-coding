package by.andd3dfx.regexp;

import by.andd3dfx.common.InsuranceNumber;
import org.junit.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * For replacement example
 *
 * @see InsuranceNumber#changeFormatUsingRegExGroups(java.lang.String)
 */
public class RegExpCheckerTest {

    @Test
    public void ipAddressRegExp() {
        assertThat(extractStringByRegExp("((\\d{1,2}|1\\d{2}|2[0-5]{2})\\.){3}((\\d{1,2}|1\\d{2}|2[0-5]{2}))",
            "Bla, some ip-address 192.168.1.1 here."))
            .isEqualTo("192.168.1.1");
    }

    @Test
    public void repeatableExpressions() {
        assertThat(extractStringByRegExp("#[0-9A-Fa-f]{6}", "RGB color: #FF3E20"))
            .as("Color should be found")
            .isEqualTo("#FF3E20");
    }

    @Test
    public void digitAndSpaceAndWordBound() {
        assertThat(extractStringByRegExp("\\d+", "We bought 2 shirts for 30$ and socks for 9$."))
            .as("Amount of shirts should be found")
            .isEqualTo("2");
        assertThat(extractStringByRegExp("\\s\\d+\\s", "We bought\t2 shirts for 30$ and socks for 9$."))
            .as("Amount of shirts should be found with space chars")
            .isEqualTo("\t2 ");
        assertThat(extractStringByRegExp("\\w\\d+\\w", "We bought 2 shirts for 30$ and socks for 9$."))
            .as("All text should be found (word bounds and hungry quantifiers)")
            .isEqualTo("We bought 2 shirts for 30$ and socks for 9$.");
        assertThat(extractStringByRegExp("\\w?\\d+\\w?", "We bought\t2 shirts for 30$ and socks for 9$."))
            .as("Amount of shirts should be found (word bounds and lazy quantifiers)")
            .isEqualTo("2");
    }

    @Test
    public void reuseAlreadyDeclaredExpressionWithLink() {
        assertThat(extractStringByRegExp("<([hH][1-6])>.*</\\1>", "Bla, some <h1>test string</h1> here."))
            .as("Tag h1 with its content should be found")
            .isEqualTo("<h1>test string</h1>");
    }

    @Test
    public void lookForwardAndBackward() {
        assertThat(extractStringByRegExp("(?<=#)[0-9A-F]{6}", "RGB color: #FF3E20"))
            .as("Color without '#' should be found")
            .isEqualTo("FF3E20");
        assertThat(extractStringByRegExp("\\d+(?=\\$)", "We bought 2 shirts for 30$ and socks for 9$."))
            .as("First price without '$' sign should be found")
            .isEqualTo("30");
    }

    @Test
    public void reuseAlreadyDeclaredExpressionWithLinkAndLookForwardAndBackward() {
        assertThat(extractStringByRegExp("(?<=<([hH][1-6])>).*(?=</\\1>)", "Bla, some <h1>test string</h1> here."))
            .as("Inner content of tag <h1> should be found")
            .isEqualTo("test string");
    }

    @Test
    public void compositeExpression() {
        assertThat(extractStringByRegExp("\\+\\d{3}-\\d{2}-\\d{3}-\\d{2}-\\d{2}", "bla +375-29-861-86-28 bla-bla"))
            .as("Phone in +ddd-dd-ddd-dd-dd format should be found")
            .isEqualTo("+375-29-861-86-28");
        assertThat(extractStringByRegExp("\\(\\d{3}\\)\\d{2} \\d{3}-\\d{2}-\\d{2}", "bla (375)29 861-86-28 bla-bla"))
            .as("Phone in +ddd-dd-ddd-dd-dd format should be found")
            .isEqualTo("(375)29 861-86-28");

        assertThat(extractStringByRegExp("((\\+\\d{3}-\\d{2})|(\\(\\d{3}\\)\\d{2}))[- ]\\d{3}-\\d{2}-\\d{2}",
            "bla +375-29-861-86-28 bla-bla"))
            .as("Phone in +ddd-dd-ddd-dd-dd format should be found for regex with 2 cases")
            .isEqualTo("+375-29-861-86-28");
        assertThat(extractStringByRegExp("((\\+\\d{3}-\\d{2})|(\\(\\d{3}\\)\\d{2}))[- ]\\d{3}-\\d{2}-\\d{2}",
            "bla (375)29 861-86-28 bla-bla"))
            .as("Phone in +ddd-dd-ddd-dd-dd format should be found for regex with 2 cases")
            .isEqualTo("(375)29 861-86-28");
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
