package by.andd3dfx.refactoring.refactored.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Event {

    private final EventType type;
    private final byte[] data;
}
