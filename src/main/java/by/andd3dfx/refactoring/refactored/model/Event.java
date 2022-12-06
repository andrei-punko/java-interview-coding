package by.andd3dfx.refactoring.refactored.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Event {
    private final EventType type;
    private final byte[] data;

    public enum EventType {
        SOME_EVENT,
        SOME_OTHER_EVENT,
        ONE_MORE_EVENT
    }
}
