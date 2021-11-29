package by.andd3dfx.masking.dto;

import by.andd3dfx.masking.Masked;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Masked
public class WithoutMaskedProperty {

    private String string;
}
