package by.andd3dfx.interview.ya;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UrlShortenerTest {

    private UrlShortener urlShortener;

    @Before
    public void setup() {
        urlShortener = new UrlShortener();
    }

    @Test
    public void testEncodeNDecodeStrings() {
        assertThat(urlShortener.buildShortUrl("tut.by"), is("b"));
        assertThat(urlShortener.buildShortUrl("dev.by"), is("c"));
        assertThat(urlShortener.buildShortUrl("thg.ru"), is("d"));

        assertThat(urlShortener.restoreLongUrl("b"), is("tut.by"));
        assertThat(urlShortener.restoreLongUrl("c"), is("dev.by"));
        assertThat(urlShortener.restoreLongUrl("d"), is("thg.ru"));
    }

    @Test
    public void encodePrimaryKeyToShortString() {
        assertThat("Wrong short string for PK=1", urlShortener.encodePrimaryKeyToShortString(1L), is("b"));
        assertThat("Wrong short string for PK=100", urlShortener.encodePrimaryKeyToShortString(100L), is("bM"));
        assertThat("Wrong short string for PK=1000", urlShortener.encodePrimaryKeyToShortString(1000L), is("qi"));
    }

    @Test
    public void decodeShortStringToPrimaryKey() {
        assertThat("Wrong PK for shortString=b", urlShortener.decodeShortStringToPrimaryKey("b"), is(1L));
        assertThat("Wrong PK for shortString=bM", urlShortener.decodeShortStringToPrimaryKey("bM"), is(100L));
        assertThat("Wrong PK for shortString=qi", urlShortener.decodeShortStringToPrimaryKey("qi"), is(1000L));
    }
}
