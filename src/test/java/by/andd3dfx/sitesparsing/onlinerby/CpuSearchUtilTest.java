package by.andd3dfx.sitesparsing.onlinerby;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.MatcherAssert.assertThat;

import by.andd3dfx.sitesparsing.onlinerby.dto.CpuSearchResult;
import java.io.IOException;
import org.junit.Before;
import org.junit.Test;

public class CpuSearchUtilTest {

    private CpuSearchUtil cpuSearchUtil;
    private String DESCRIPTION = "Picasso, AM4, 4 ядра, частота 4.2/3.6 ГГц, кэш 2 МБ + 4 МБ, техпроцесс 12 нм, TDP 65W";

    @Before
    public void setup() {
        cpuSearchUtil = new CpuSearchUtil();
    }

    @Test
    public void getLowestFirstCatalogPriceByUrl() throws IOException {
        CpuSearchResult cpuItems = cpuSearchUtil.extractPage(1);
        System.out.println(cpuItems);

        assertThat(cpuItems.getCpuItems().size(), is(30));
        assertThat(cpuItems.getPagesAmount(), greaterThan(0));
    }

    @Test
    public void extractCoresAmount() {
        assertThat(cpuSearchUtil.extractCoresAmount(DESCRIPTION), is(4));
    }

    @Test
    public void extractFrequency() {
        assertThat(cpuSearchUtil.extractFrequency(DESCRIPTION), is(4.2));
    }
}
