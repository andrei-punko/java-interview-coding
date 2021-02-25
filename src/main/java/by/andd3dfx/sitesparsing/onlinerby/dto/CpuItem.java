package by.andd3dfx.sitesparsing.onlinerby.dto;

public class CpuItem {

    private String name;
    private String url;
    private double price;

    private int coresAmount;
    private double frequency;

    private double usefulness;

    public CpuItem(String name, String url, double price, int coresAmount, double frequency) {
        this.name = name;
        this.url = url;
        this.price = price;
        this.coresAmount = coresAmount;
        this.frequency = frequency;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public double getPrice() {
        return price;
    }

    public int getCoresAmount() {
        return coresAmount;
    }

    public double getFrequency() {
        return frequency;
    }

    public double getUsefulness() {
        return usefulness;
    }

    public void setUsefulness(double usefulness) {
        this.usefulness = usefulness;
    }

    @Override
    public String toString() {
        return "CpuItem{" +
            "name='" + name + '\'' +
            ", url='" + url + '\'' +
            ", price=" + price +
            ", cores=" + coresAmount +
            ", frequency=" + frequency +
            ", revUsefulness=" + usefulness +
            '}';
    }
}
