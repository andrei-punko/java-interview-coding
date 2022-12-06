package by.andd3dfx.refactoring.refactored;

import by.andd3dfx.refactoring.refactored.model.Event;
import by.andd3dfx.refactoring.refactored.parser.IEventParser;
import by.andd3dfx.refactoring.refactored.parser.OneMoreEventParser;
import by.andd3dfx.refactoring.refactored.parser.SomeEventParser;
import by.andd3dfx.refactoring.refactored.parser.SomeOtherEventParser;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static by.andd3dfx.refactoring.refactored.model.Event.EventType.ONE_MORE_EVENT;
import static by.andd3dfx.refactoring.refactored.model.Event.EventType.SOME_EVENT;
import static by.andd3dfx.refactoring.refactored.model.Event.EventType.SOME_OTHER_EVENT;

public class EventParser {
    private static final Map<Event.EventType, IEventParser> map = Map.of(
            SOME_EVENT, new SomeEventParser(),
            SOME_OTHER_EVENT, new SomeOtherEventParser(),
            ONE_MORE_EVENT, new OneMoreEventParser()
    );

    public List<String> parse(List<Event> events) {
        return events.stream()
                .map(this::apply)
                .collect(Collectors.toList());
    }

    private String apply(Event event) {
        return map.get(event.getType())
                .parse(event.getData());
    }
}
