package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class TrainCompositionTest {

    private TrainComposition trainComposition;

    @Before
    public void setUp() throws Exception {
        trainComposition = new TrainComposition();
    }

    @Test
    public void testAttachDetach() {
        trainComposition.attachWagonFromLeft(7);
        trainComposition.attachWagonFromLeft(13);
        trainComposition.attachWagonFromRight(45);
        trainComposition.attachWagonFromLeft(34);
        // Now order is next: 34 13 7 45

        assertThat(trainComposition.detachWagonFromRight(), is(45));
        assertThat(trainComposition.detachWagonFromRight(), is(7));
        assertThat(trainComposition.detachWagonFromLeft(), is(34));
        assertThat(trainComposition.detachWagonFromLeft(), is(13));
    }
}
