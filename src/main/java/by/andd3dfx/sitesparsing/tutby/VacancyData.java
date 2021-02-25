package by.andd3dfx.sitesparsing.tutby;

import java.util.Set;

public class VacancyData {

    private String url;
    private String companyName;
    private String textContent;
    private Set<String> keywords;
    private String addressString;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    public Set<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(Set<String> keywords) {
        this.keywords = keywords;
    }

    public String getAddressString() {
        return addressString;
    }

    public void setAddressString(String addressString) {
        this.addressString = addressString;
    }

    @Override
    public String toString() {
        return "VacancyData{" +
            "url='" + url + '\'' +
            ", keywords=" + keywords +
            '}';
    }
}
