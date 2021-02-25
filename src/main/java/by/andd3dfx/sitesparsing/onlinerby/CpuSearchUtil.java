package by.andd3dfx.sitesparsing.onlinerby;

import by.andd3dfx.sitesparsing.onlinerby.dto.CpuItem;
import by.andd3dfx.sitesparsing.onlinerby.dto.CpuSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CpuSearchUtil {

    private static final String CPU_URL_TEMPLATE = "https://catalog.onliner.by/sdapi/catalog.api/search/cpu?page=%d";
    private static final ObjectMapper mapper = new ObjectMapper();
    private static final Pattern CPU_CORES_PATTERN = Pattern.compile("\\d+ яд");
    private static final Pattern CPU_FREQ_PATTERN = Pattern.compile("частота \\d+([.]\\d+){0,1}");

    public CpuSearchResult extractPage(int pageNumber) throws IOException {
        String urlSpec = String.format(CPU_URL_TEMPLATE, pageNumber);

        Map items = mapper.readValue(new URL(urlSpec), Map.class);
        List<Map> products = (List<Map>) items.get("products");

        List<CpuItem> cpuItems = products.stream().map(product -> {
            String name = String.valueOf(product.get("name"));
            String url = String.valueOf(product.get("html_url"));
            Double price = extractPrice(product);
            String description = String.valueOf(product.get("description"));
            int coresAmount = extractCoresAmount(description);
            double frequency = extractFrequency(description);
            return new CpuItem(name, url, price, coresAmount, frequency);
        }).collect(Collectors.toList());
        Integer lastPageNumber = (Integer) ((Map) items.get("page")).get("last");

        return new CpuSearchResult(cpuItems, lastPageNumber);
    }

    private double extractPrice(Map product) {
        final Map prices = (Map) product.get("prices");
        if (prices == null) {
            return 0;
        }
        final Map price_min = (Map) prices.get("price_min");
        return Double.parseDouble(String.valueOf(price_min.get("amount")));
    }

    public List<CpuItem> calculateUsefulness(CpuSearchCriteria criteria) throws IOException {
        List<CpuItem> result = new ArrayList<>();

        for (int pageNumber = 1; ; pageNumber++) {
            System.out.println("Retrieve page N=" + pageNumber);

            CpuSearchResult searchResult = extractPage(pageNumber);
            result.addAll(
                searchResult.getCpuItems().stream()
                    .filter(item -> item.getPrice() > 0)
                    .filter(item -> item.getPrice() <= criteria.getMaxPrice())
                    .filter(item -> item.getCoresAmount() >= criteria.getMinCoresAmount())
                    .filter(item -> item.getFrequency() >= criteria.getMinFrequency())
                    .map(item -> {
                        item.setUsefulness(item.getPrice() / (item.getCoresAmount() * item.getFrequency()));
                        return item;
                    }).collect(Collectors.toList())
            );

            if (pageNumber == searchResult.getPagesAmount()) {
                break;
            }
        }

        Collections.sort(result, (o1, o2) -> {
            if (o1.getUsefulness() < o2.getUsefulness()) {
                return -1;
            }
            if (o1.getUsefulness() > o2.getUsefulness()) {
                return 1;
            }
            return 0;
        });
        return result;
    }

    int extractCoresAmount(String description) {
        Matcher matcher = CPU_CORES_PATTERN.matcher(description);
        if (matcher.find()) {
            final String group = matcher.group();
            return Integer.parseInt(group.replace(" яд", ""));
        }
        return 0;
    }

    double extractFrequency(String description) {
        Matcher matcher = CPU_FREQ_PATTERN.matcher(description);
        if (matcher.find()) {
            String group = matcher.group();
            group = group.replace("частота ", "");
            return Double.parseDouble(group);
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        final CpuSearchCriteria criteria = new CpuSearchCriteria.Builder()
            .setMaxPrice(1000.0)
            .setMinCoresAmount(6)
            .setMinFrequency(3.5d)
            .build();

        final List<CpuItem> cpuItems = new CpuSearchUtil().calculateUsefulness(criteria);

        System.out.println(cpuItems);
    }
}
