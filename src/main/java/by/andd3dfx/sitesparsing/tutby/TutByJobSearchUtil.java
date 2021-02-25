package by.andd3dfx.sitesparsing.tutby;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TutByJobSearchUtil {

    private final String URL_PREFIX = "http://jobs.tut.by";
    private final String USER_AGENT = "Mozilla";
    private final String searchUrlFormat = URL_PREFIX + "/search/vacancy?area=1002&text=%s&page=%d";

    public List<VacancyData> batchSearch(String searchString) {
        List<VacancyData> result = new ArrayList<>();

        String nextPageUrl = buildSearchUrl(searchString);
        while (nextPageUrl != null) {
            SingleSearchResult singleSearchResult = singleSearch(nextPageUrl);
            result.addAll(singleSearchResult.getDataItems());
            nextPageUrl = singleSearchResult.getNextPageUrl();
        }

        return result;
    }

    SingleSearchResult singleSearch(String searchUrl) {
        try {
            Document document = Jsoup
                .connect(searchUrl)
                .userAgent(USER_AGENT).get();

            Elements elements = document
                .select("div[data-qa=vacancy-serp__vacancy]");

            List<VacancyData> vacancyDataList = new ArrayList<>();
            elements.parallelStream().forEach(element -> {
                String vacancyDetailsUrl = element.select("a").attr("href");
                vacancyDataList.add(retrieveVacancyDetails(vacancyDetailsUrl));
            });

            final Elements nextPageItem = document.select("a[data-qa=pager-next]");
            String nextPageUrl = nextPageItem.isEmpty() ? null : URL_PREFIX + nextPageItem.attr("href");
            return new SingleSearchResult(vacancyDataList, nextPageUrl);
        } catch (IOException e) {
            throw new RuntimeException("Single search failed", e);
        }
    }

    private VacancyData retrieveVacancyDetails(String searchUrl) {
        System.out.println("Retrieve vacancy details for " + searchUrl);
        Document document;
        try {
            document = Jsoup
                .connect(searchUrl)
                .userAgent(USER_AGENT).get();
        } catch (IOException e) {
            throw new RuntimeException("Retrieve details failed", e);
        }

        VacancyData vacancyData = new VacancyData();
        vacancyData.setUrl(document.baseUri());
        vacancyData.setCompanyName(document.select("a[class=vacancy-company-name]").text());
        vacancyData.setTextContent(document.select("div[data-qa=vacancy-description]").text());
        vacancyData.setKeywords(document.select("span[data-qa=bloko-tag__text]")
            .stream()
            .map(Element::text)
            .flatMap(keyword -> Arrays.asList(keyword.split(", ")).stream())
            .flatMap(keyword -> Arrays.asList(keyword.split(" & ")).stream())
            .collect(Collectors.toSet())
        );
        vacancyData.setAddressString(document.select("div[class^=vacancy-address-text]").text());
        return vacancyData;
    }

    String buildSearchUrl(String searchString) {
        return String.format(searchUrlFormat, searchString, 0);
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new IllegalArgumentException("Path to output file should be populated!");
        }
        final TutByJobSearchUtil searchUtil = new TutByJobSearchUtil();

        LinkedHashMap<String, Integer> statisticsSortedMap = searchUtil.collectStatistics("java");
        Path path = Paths.get(args[0]);
        byte[] strToBytes = statisticsSortedMap.toString().getBytes();
        Files.write(path, strToBytes);
    }

    public LinkedHashMap<String, Integer> collectStatistics(List<VacancyData> result) {
        final Statistics statistics = new Statistics();
        result.stream().forEach(vacancyData -> {
            vacancyData.getKeywords().stream().forEach(statistics::putKeyword);
        });
        return statistics.buildSortedMap();
    }

    public LinkedHashMap<String, Integer> collectStatistics(String searchString) {
        final List<VacancyData> result = batchSearch(searchString);
        return collectStatistics(result);
    }
}
