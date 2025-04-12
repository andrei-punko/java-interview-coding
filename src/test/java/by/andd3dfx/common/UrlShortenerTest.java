package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class UrlShortenerTest {

    private UrlShortener urlShortener;

    @Before
    public void setup() {
        urlShortener = new UrlShortener();
    }

    @Test
    public void testEncodeNDecodeStrings() {
        assertThat(urlShortener.buildShortUrl("tut.by")).isEqualTo("b");
        assertThat(urlShortener.buildShortUrl("dev.by")).isEqualTo("c");
        assertThat(urlShortener.buildShortUrl("thg.ru")).isEqualTo("d");

        assertThat(urlShortener.restoreLongUrl("b")).isEqualTo("tut.by");
        assertThat(urlShortener.restoreLongUrl("c")).isEqualTo("dev.by");
        assertThat(urlShortener.restoreLongUrl("d")).isEqualTo("thg.ru");
    }

    @Test
    public void encodePrimaryKeyToShortString() {
        assertThat(urlShortener.encodePrimaryKeyToShortString(1L))
                .as("Wrong short string for PK=1")
                .isEqualTo("b");
        assertThat(urlShortener.encodePrimaryKeyToShortString(100L))
                .as("Wrong short string for PK=100")
                .isEqualTo("bM");
        assertThat(urlShortener.encodePrimaryKeyToShortString(101L))
                .as("Wrong short string for PK=101")
                .isEqualTo("bN");
    }

    @Test
    public void decodeShortStringToPrimaryKey() {
        assertThat(urlShortener.decodeShortStringToPrimaryKey("b"))
                .as("Wrong PK for shortString=b")
                .isEqualTo(1L);
        assertThat(urlShortener.decodeShortStringToPrimaryKey("bM"))
                .as("Wrong PK for shortString=bM")
                .isEqualTo(100L);
        assertThat(urlShortener.decodeShortStringToPrimaryKey("bN"))
                .as("Wrong PK for shortString=bN")
                .isEqualTo(101L);
    }
}
