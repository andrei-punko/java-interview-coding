package by.andd3dfx.interview.goldmansachs;

public class Card {

    private String vendor;
    private String number;

    public Card(String vendor, String number) {
        this.vendor = vendor;
        this.number = number;
    }

    public String getVendor() {
        return vendor;
    }

    public String getNumber() {
        return number;
    }
}
