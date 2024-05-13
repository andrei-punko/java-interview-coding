
Провести рефакторинг 3-х классов:
```java
public class Event {
    private final String type;
    private final byte[] data;

    public Event(String type, byte[] data) {
        this.type = type;
        this.data = data;
    }

    public String getType() {
        return type;
    }

    public byte[] getData() {
        return data;
    }
}

public class EventParser {
    public List<String> parse(List<Event> events) {
        List<String> result = new ArrayList<>();
        for (Event event : events) {
            if (event.getType().equals("someEvent")) {
                result.add(ParserUtil.parseSomeEvent(event.getData()));
            } else if (event.getType().equals("someOtherEvent")) {
                result.add(ParserUtil.parseSomeOtherEvent(event.getData()));
            } else if (event.getType().equals("oneMoreEvent")) {
                result.add(ParserUtil.parseOneMoreEvent(event.getData()));
            }
        }
        return result;
    }
}

public final class ParserUtil {
    private ParserUtil() {
    }

    public static String parseSomeEvent(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public static String parseSomeOtherEvent(byte[] data) {
        throw new UnsupportedOperationException();
    }

    public static String parseOneMoreEvent(byte[] data) {
        throw new UnsupportedOperationException();
    }
}
```

Check [video solution](https://youtu.be/jdnNYxVk5BE) on YouTube
