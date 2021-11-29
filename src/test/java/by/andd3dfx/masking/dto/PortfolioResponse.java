package by.andd3dfx.masking.dto;

import by.andd3dfx.masking.Masked;
import by.andd3dfx.masking.MaskedProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Builder
@AllArgsConstructor
@Data
@Masked
public class PortfolioResponse {

    private String string;
    @MaskedProperty
    private String maskedString;
    @MaskedProperty(pattern = "(\\d{6})\\d+(\\d{4})", replacement = "$1******$2")
    private String maskedStringWithPattern;

    private List<String> stringList;
    @MaskedProperty
    private List<String> maskedStringList;

    private Set<String> stringSet;
    @MaskedProperty(pattern = "(\\d{6})\\d+(\\d{4})", replacement = "$1-ZZZ-$2")
    private Set<String> maskedStringSet;

    private Map<String, String> stringToStringMap;
    @MaskedProperty(pattern = "(\\d{6})\\d+(\\d{4})", replacement = "$1-XYZ-$2")
    private Map<String, String> maskedStringToStringMap;

    private PortfolioResponse portfolioResponse;

    private List<PortfolioResponse> portfolioResponseList;
    private Set<PortfolioResponse> portfolioResponseSet;
    private Map<String, PortfolioResponse> stringToPortfolioResponseMap;

    private Integer integer;
    private List<Integer> integerList;
    private int baseInt;
    private int[] baseIntArray;
}
