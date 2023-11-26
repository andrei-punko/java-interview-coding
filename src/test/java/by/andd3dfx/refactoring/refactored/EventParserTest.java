package by.andd3dfx.refactoring.refactored;

import by.andd3dfx.refactoring.refactored.model.Event;
import by.andd3dfx.refactoring.refactored.model.EventType;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Random;

import static by.andd3dfx.refactoring.refactored.model.EventType.ONE_MORE_EVENT;
import static by.andd3dfx.refactoring.refactored.model.EventType.SOME_EVENT;
import static by.andd3dfx.refactoring.refactored.model.EventType.SOME_OTHER_EVENT;
import static org.junit.Assert.assertThrows;

public class EventParserTest {

    private static final Random random = new Random();
    private EventParser eventParser;

    /**
     * Test is valuable because some actions made using reflection during the creation of EventParser class
     */
    @Before
    public void setUp() throws Exception {
        eventParser = new EventParser();
    }

    @Test
    public void testParse() {
        var event = buildEvent(SOME_EVENT);

        assertThrows(UnsupportedOperationException.class, () -> eventParser.parse(event));
    }

    @Test
    public void testParseForList() {
        var events = List.of(
                buildEvent(ONE_MORE_EVENT),
                buildEvent(SOME_OTHER_EVENT)
        );
        assertThrows(UnsupportedOperationException.class, () -> eventParser.parse(events));
    }

    private static Event buildEvent(EventType eventType) {
        var bytes = new byte[50];
        random.nextBytes(bytes);
        return new Event(eventType, bytes);
    }
}
