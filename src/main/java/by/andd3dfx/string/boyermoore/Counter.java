package by.andd3dfx.string.boyermoore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Counter {
    private int value;

    public void inc() {
        value++;
    }
}
