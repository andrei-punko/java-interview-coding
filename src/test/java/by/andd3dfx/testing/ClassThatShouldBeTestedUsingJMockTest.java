package by.andd3dfx.testing;

import org.jmock.Expectations;
import org.jmock.Mockery;
import org.jmock.imposters.ByteBuddyClassImposteriser;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClassThatShouldBeTestedUsingJMockTest {

    /**
     * To mock real class, not interface, we need to set imposteriser into mockery
     */
    private Mockery mockery = new Mockery() {{
        setImposteriser(ByteBuddyClassImposteriser.INSTANCE);
    }};
    private ClassThatShouldBeTested classThatShouldBeTested;

    @Before
    public void setup() {
        classThatShouldBeTested = new ClassThatShouldBeTested();
        classThatShouldBeTested.realClass = mockery.mock(RealClass.class);
    }

    @Test
    public void someMethod() {
        mockery.checking(new Expectations() {
            {
                oneOf(classThatShouldBeTested.realClass).someMethod(2, 5);
                will(returnValue(3));
            }
        });
        int result = classThatShouldBeTested.someMethod(2, 5);

        assertThat("Wrong result", result, is(3));
    }
}
