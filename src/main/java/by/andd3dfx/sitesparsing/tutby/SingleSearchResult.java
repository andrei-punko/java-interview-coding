package by.andd3dfx.sitesparsing.tutby;

import java.util.List;

public class SingleSearchResult {

    private final List<VacancyData> dataItems;
    private final String nextPageUrl;

    public SingleSearchResult(List<VacancyData> dataItems, String nextPageUrl) {
        this.dataItems = dataItems;
        this.nextPageUrl = nextPageUrl;
    }

    public List<VacancyData> getDataItems() {
        return dataItems;
    }

    public String getNextPageUrl() {
        return nextPageUrl;
    }
}
