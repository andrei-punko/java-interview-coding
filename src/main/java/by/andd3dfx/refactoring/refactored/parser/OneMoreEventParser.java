package by.andd3dfx.refactoring.refactored.parser;

import by.andd3dfx.refactoring.refactored.model.EventType;

import static by.andd3dfx.refactoring.refactored.model.EventType.ONE_MORE_EVENT;

public class OneMoreEventParser implements IEventParser {

    @Override
    public EventType getEventType() {
        return ONE_MORE_EVENT;
    }

    @Override
    public String parse(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
