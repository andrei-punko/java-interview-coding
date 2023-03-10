package by.andd3dfx.refactoring.refactored.parser;

import by.andd3dfx.refactoring.refactored.model.EventType;

import static by.andd3dfx.refactoring.refactored.model.EventType.SOME_EVENT;

public class SomeEventParser implements IEventParser {

    @Override
    public EventType getEventType() {
        return SOME_EVENT;
    }

    @Override
    public String parse(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
