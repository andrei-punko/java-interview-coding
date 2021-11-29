package by.andd3dfx.masking.dto;

import by.andd3dfx.masking.MaskedProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class WithoutMasked {

    private String string;

    @MaskedProperty
    private String maskedString;
}
