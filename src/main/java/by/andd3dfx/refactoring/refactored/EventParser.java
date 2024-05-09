package by.andd3dfx.refactoring.refactored;

import by.andd3dfx.refactoring.refactored.model.Event;
import by.andd3dfx.refactoring.refactored.model.EventType;
import by.andd3dfx.refactoring.refactored.parser.IEventParser;
import lombok.SneakyThrows;
import org.reflections.Reflections;

import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

public class EventParser {

    private static final EnumMap<EventType, IEventParser> map = new EnumMap<>(EventType.class);

    static {
        Reflections reflections = new Reflections(IEventParser.class.getPackageName());
        reflections.getSubTypesOf(IEventParser.class).stream()
                .forEach(aClass -> extracted(aClass));

        for (EventType eventType : EventType.values()) {
            if (!map.containsKey(eventType)) {
                throw new IllegalStateException("Not all values of EventType have appropriate EventParser!");
            }
        }
    }

    @SneakyThrows
    private static void extracted(Class<? extends IEventParser> aClass) {
        var instance = aClass.getDeclaredConstructor().newInstance();
        map.put(instance.getEventType(), instance);
    }

    public String parse(Event event) {
        return map.get(event.getType())
                .parse(event.getData());
    }

    public List<String> parse(List<Event> events) {
        return events.stream()
                .map(this::parse)
                .collect(Collectors.toList());
    }
}
