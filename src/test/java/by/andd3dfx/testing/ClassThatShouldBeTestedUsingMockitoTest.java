package by.andd3dfx.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ClassThatShouldBeTestedUsingMockitoTest {

    @InjectMocks
    ClassThatShouldBeTested classThatShouldBeTested;
    @Mock
    RealClass realClassMock;

    @Test
    public void someMethod() {
        when(realClassMock.someMethod(2, 5)).thenReturn(3);

        int result = classThatShouldBeTested.someMethod(2, 5);

        assertThat("Wrong result", result, is(3));
    }
}
