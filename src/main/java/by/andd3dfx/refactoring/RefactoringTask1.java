package by.andd3dfx.refactoring;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static by.andd3dfx.refactoring.RefactoringTask1.EventType.*;

/**
 * Провести рефакторинг 3-х классов:
 * <pre>
 * public class Event {
 *         private final String type;
 *         private final byte[] data;
 *
 *         public Event(String type, byte[] data) {
 *                 this.type = type;
 *                 this.data = data;
 *         }
 *         public String getType() {
 *                 return type;
 *         }
 *         public byte[] getData() {
 *                 return data;
 *         }
 * }
 *
 * public class EventParser {
 *         public List<String> parse(List<Event> events) {
 *                 List<String> result = new ArrayList<>();
 *
 *                 for (Event event : events) {
 *                 if (event.getType().equals(""someEvent"")) {
 *                         result.add(ParserUtil.parseSomeEvent(event.getData()));
 *                 } else if (event.getType().equals(""someOtherEvent"")) {
 *                         result.add(ParserUtil.parseSomeOtherEvent(event.getData()));
 *                 } else if (event.getType().equals(""oneMoreEvent"")) {
 *                         result.add(ParserUtil.parseOneMoreEvent(event.getData()));
 *                 }
 *         }
 *
 *         return result;
 *         }
 * }
 *
 * public final class ParserUtil {
 *         private ParserUtil() {}
 *
 *         public static String parseSomeEvent(byte[] data) {
 *                 throw new UnsupportedOperationException();
 *         }
 *         public static String parseSomeOtherEvent(byte[] data) {
 *                 throw new UnsupportedOperationException();
 *         }
 *         public static String parseOneMoreEvent(byte[] data) {
 *                 throw new UnsupportedOperationException();
 *         }
 * }
 * </pre>
 */
public class RefactoringTask1 {

    @AllArgsConstructor
    @Getter
    public class Event {
        private final EventType type;
        private final byte[] data;
    }

    public enum EventType {
        SOME_EVENT, SOME_OTHER_EVENT, ONE_MORE_EVENT
    }

    public class EventParser {
        private Map<EventType, IEventParser> map = Map.of(
                SOME_EVENT, new SomeEventParser(),
                SOME_OTHER_EVENT, new SomeOtherEventParser(),
                ONE_MORE_EVENT, new OneMoreEventParser()
        );

        public List<String> parse(List<Event> events) {
            return events.stream()
                    .map(event -> map.get(event.getType()).parse(event.data))
                    .collect(Collectors.toList());
        }
    }

    public interface IEventParser {
        String parse(byte[] data);
    }

    public class SomeEventParser implements IEventParser {
        @Override
        public String parse(byte[] data) {
            throw new UnsupportedOperationException();
        }
    }

    public class SomeOtherEventParser implements IEventParser {
        @Override
        public String parse(byte[] data) {
            throw new UnsupportedOperationException();
        }
    }

    public class OneMoreEventParser implements IEventParser {
        @Override
        public String parse(byte[] data) {
            throw new UnsupportedOperationException();
        }
    }
}
