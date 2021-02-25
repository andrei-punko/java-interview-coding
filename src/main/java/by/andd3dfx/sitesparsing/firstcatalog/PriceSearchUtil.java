package by.andd3dfx.sitesparsing.firstcatalog;

import org.jsoup.Jsoup;

import java.io.IOException;

public class PriceSearchUtil {
    private static final String USER_AGENT = "Mozilla";

    public Double getLowestFirstCatalogPriceByUrl(String firstCatalogUrl) throws IOException {
        String text = Jsoup
                .connect(firstCatalogUrl)
                .userAgent(USER_AGENT).get().select("[class=spec-about__price]").get(0).text();
        // text = 486,00 – 515,10 б.р.
        text = text.substring(0, text.indexOf(",")).replace(" ", "");
        return Double.parseDouble(text);
    }
}
