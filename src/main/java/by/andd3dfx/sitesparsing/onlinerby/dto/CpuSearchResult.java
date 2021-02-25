package by.andd3dfx.sitesparsing.onlinerby.dto;

import java.util.List;

public class CpuSearchResult {

    private List<CpuItem> cpuItems;
    private Integer pagesAmount;

    public CpuSearchResult(List<CpuItem> cpuItems, Integer pagesAmount) {
        this.cpuItems = cpuItems;
        this.pagesAmount = pagesAmount;
    }

    public List<CpuItem> getCpuItems() {
        return cpuItems;
    }

    public Integer getPagesAmount() {
        return pagesAmount;
    }

    @Override
    public String toString() {
        return "CpuSearchResult{" +
            "cpuItems=" + cpuItems +
            ", pagesAmount=" + pagesAmount +
            '}';
    }
}
