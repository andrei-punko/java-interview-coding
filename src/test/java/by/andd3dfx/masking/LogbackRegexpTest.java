package by.andd3dfx.masking;

import lombok.AllArgsConstructor;
import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * This test needed to check regexp which used in %replace of logback config.
 */
public class LogbackRegexpTest {

    final String SISB_NAME_REGEXP = "([\"(\\s](embosibleName|clientNameF|clientNameI|clientNameO)(\":\"|=).).*?(.{2}[\",)])";
    final String NAME_REPLACEMENT = "$1***$4";

    final String SISB_NUMBER_REGEXP =
            "([\"(\\s](contractNumber|externalIdPart1|maskedNumber|number|tokenNumber|cardNumber|currentAccount|account|loanAccount)(\":\"|=)\\S{6})\\S+?(\\S{4}[\",)])";
    final String SVI_JSON_NUMBER_REGEXP = "([\"(\\s](cardNumber)(\":\"|=)\\d{6})\\d+?(\\d{4}[\",)])";
    final String JSON_NUMBER_REPLACEMENT = "$1***$4";

    final String SVI_XML_NUMBER_REGEXP = "(<CardNumber>\\d{6})\\d+?(\\d{4}</CardNumber>)";
    final String XML_NUMBER_REPLACEMENT = "$1***$2";

    @Test
    public void nameReplacement() {
        String[][] testData = {
                // Non-quoted strings
                {" embosibleName=Василий Куропаткин,", " embosibleName=В***ин,"},
                {"(clientNameF=Василий Куропаткин, embosibleName=Василий Куропаткин)", "(clientNameF=В***ин, embosibleName=В***ин)"},
                {", clientNameI=Василий Куропаткин,", ", clientNameI=В***ин,"},
                {", clientNameO=Василий Куропаткин)", ", clientNameO=В***ин)"},
                {"(embosibleName=Василий Куропаткин)", "(embosibleName=В***ин)"},

                // Quoted strings
                {" \"embosibleName\":\"Василий Куропаткин\",", " \"embosibleName\":\"В***ин\","},
                {"{\"clientNameF\":\"Василий Куропаткин\", \"embosibleName\":\"Василий Куропаткин\"}",
                        "{\"clientNameF\":\"В***ин\", \"embosibleName\":\"В***ин\"}"},
                {", \"clientNameI\":\"Василий Куропаткин\",", ", \"clientNameI\":\"В***ин\","},
                {", \"clientNameO\":\"Василий Куропаткин\"}", ", \"clientNameO\":\"В***ин\"}"},
                {"{\"embosibleName\":\"Василий Куропаткин\"}", "{\"embosibleName\":\"В***ин\"}"},
        };

        Arrays.stream(testData)
                .map(record -> new TestData(record[0], record[1]))
                .forEach(
                        record -> assertThat(record.from.replaceAll(SISB_NAME_REGEXP, NAME_REPLACEMENT)).isEqualTo(record.to)
                );
    }

    @Test
    public void numberReplacement() {
        String[][] testData = {
                // Non-quoted strings
                {" externalIdPart1=1AB4567890123CD6,", " externalIdPart1=1AB456***3CD6,"},
                {"(cardNumber=1AB4567890123CD6, contractNumber=1AB4567890123CD6)",
                        "(cardNumber=1AB456***3CD6, contractNumber=1AB456***3CD6)"},
                {", maskedNumber=1AB4567890123CD6,", ", maskedNumber=1AB456***3CD6,"},
                {", number=1AB4567890123CD6)", ", number=1AB456***3CD6)"},
                {"(tokenNumber=1AB4567890123CD6)", "(tokenNumber=1AB456***3CD6)"},

                // Quoted strings
                {" \"externalIdPart1\":\"1AB4567890123CD6\",", " \"externalIdPart1\":\"1AB456***3CD6\","},
                {"{\"cardNumber\":\"1AB4567890123CD6\", \"contractNumber\":\"1AB4567890123CD6\"}",
                        "{\"cardNumber\":\"1AB456***3CD6\", \"contractNumber\":\"1AB456***3CD6\"}"},
                {", \"maskedNumber\":\"1AB4567890123CD6\",", ", \"maskedNumber\":\"1AB456***3CD6\","},
                {", \"number\":\"1AB4567890123CD6\"}", ", \"number\":\"1AB456***3CD6\"}"},
                {"{\"tokenNumber\":\"1AB4567890123CD6\"}", "{\"tokenNumber\":\"1AB456***3CD6\"}"},
        };

        Arrays.stream(testData)
                .map(record -> new TestData(record[0], record[1]))
                .forEach(
                        record -> assertThat(record.from.replaceAll(SISB_NUMBER_REGEXP, JSON_NUMBER_REPLACEMENT)).isEqualTo(record.to)
                );
    }

    @Test
    public void sviNumberInJsonReplacement() {
        String[][] testData = {
                // Non-quoted strings
                {" cardNumber=5666500002414376,", " cardNumber=566650***4376,"},
                {"(cardNumber=5666500002414376, cardNumber=5666500002414376)",
                        "(cardNumber=566650***4376, cardNumber=566650***4376)"},
                {", cardNumber=5666500002414376,", ", cardNumber=566650***4376,"},
                {", cardNumber=5666500002414376)", ", cardNumber=566650***4376)"},
                {"(cardNumber=5666500002414376)", "(cardNumber=566650***4376)"},

                // Quoted strings
                {" \"cardNumber\":\"5666500002414376\",", " \"cardNumber\":\"566650***4376\","},
                {"{\"cardNumber\":\"5666500002414376\", \"cardNumber\":\"5666500002414376\"}",
                        "{\"cardNumber\":\"566650***4376\", \"cardNumber\":\"566650***4376\"}"},
                {", \"cardNumber\":\"5666500002414376\",", ", \"cardNumber\":\"566650***4376\","},
                {", \"cardNumber\":\"5666500002414376\"}", ", \"cardNumber\":\"566650***4376\"}"},
                {"{\"cardNumber\":\"5666500002414376\"}", "{\"cardNumber\":\"566650***4376\"}"},
        };

        Arrays.stream(testData)
                .map(record -> new TestData(record[0], record[1]))
                .forEach(
                        record -> assertThat(record.from.replaceAll(SVI_JSON_NUMBER_REGEXP, JSON_NUMBER_REPLACEMENT)).isEqualTo(record.to)
                );
    }

    @Test
    public void sviNumberInXmlReplacement() {
        String[][] testData = {
                {"<AnotherTag><CardNumber>5666500002414376</CardNumber></AnotherTag>",
                        "<AnotherTag><CardNumber>566650***4376</CardNumber></AnotherTag>"},
        };

        Arrays.stream(testData)
                .map(record -> new TestData(record[0], record[1]))
                .forEach(
                        record -> assertThat(record.from.replaceAll(SVI_XML_NUMBER_REGEXP, XML_NUMBER_REPLACEMENT)).isEqualTo(record.to)
                );
    }

    @AllArgsConstructor
    class TestData {
        String from;
        String to;
    }
}
