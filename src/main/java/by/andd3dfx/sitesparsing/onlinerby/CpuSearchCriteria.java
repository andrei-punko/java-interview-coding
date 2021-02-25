package by.andd3dfx.sitesparsing.onlinerby;

public class CpuSearchCriteria {

    private Double maxPrice = 0.0;
    private Integer minCoresAmount = 0;
    private Double minFrequency = 0.0;

    public CpuSearchCriteria(Double maxPrice, Integer minCoresAmount, Double minFrequency) {
        this.maxPrice = maxPrice;
        this.minCoresAmount = minCoresAmount;
        this.minFrequency = minFrequency;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Integer getMinCoresAmount() {
        return minCoresAmount;
    }

    public void setMinCoresAmount(Integer minCoresAmount) {
        this.minCoresAmount = minCoresAmount;
    }

    public Double getMinFrequency() {
        return minFrequency;
    }

    public void setMinFrequency(Double minFrequency) {
        this.minFrequency = minFrequency;
    }

    public static class Builder {

        private Double maxPrice;
        private Integer minCoresAmount;
        private Double minFrequency;

        public Builder setMaxPrice(Double maxPrice) {
            this.maxPrice = maxPrice;
            return this;
        }

        public Builder setMinCoresAmount(Integer minCoresAmount) {
            this.minCoresAmount = minCoresAmount;
            return this;
        }

        public Builder setMinFrequency(Double minFrequency) {
            this.minFrequency = minFrequency;
            return this;
        }

        public CpuSearchCriteria build() {
            return new CpuSearchCriteria(maxPrice, minCoresAmount, minFrequency);
        }
    }
}
