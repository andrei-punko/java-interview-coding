package by.andd3dfx.refactoring.initial;

import java.util.ArrayList;
import java.util.List;

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
