package by.andd3dfx.refactoring.refactored.parser;

import by.andd3dfx.refactoring.refactored.model.EventType;

public interface IEventParser {

    EventType getEventType();

    String parse(byte[] data);
}
