package by.andd3dfx.sitesparsing.firstcatalog;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

@Ignore("Should not track 1k.by layout 24/7")
public class PriceSearchUtilTest {

    private String FIRST_CATALOG_SEARCH_URL = "https://komp.1k.by/utility-graphicscards/msi/" +
        "MSI_Radeon_RX_580_8192Mb_Armor_OC_RX_580_ARMOR_8G_OC-2876289.html";

    private PriceSearchUtil priceSearchUtil;

    @Before
    public void setup() {
        priceSearchUtil = new PriceSearchUtil();
    }

    @Test
    public void testGetLowestFirstCatalogPriceByUrl() throws Exception {
        Double price = priceSearchUtil.getLowestFirstCatalogPriceByUrl(FIRST_CATALOG_SEARCH_URL);
        assertThat("Price should be greater than 0", price, Matchers.greaterThan(0.0));
    }
}
