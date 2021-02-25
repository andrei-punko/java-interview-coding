package by.andd3dfx.interview.wf;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class TrainCompositionTest {

  private TrainComposition trainComposition;

  @Before
  public void setup() {
    trainComposition = new TrainComposition();
  }

  @Test
  public void test() {
    trainComposition.attachWagonFromLeft(7);
    trainComposition.attachWagonFromLeft(13);
    trainComposition.attachWagonFromRight(45);
    trainComposition.attachWagonFromLeft(34);
    // Now order is next: 34 13 7 45

    assertThat("45 expected", trainComposition.detachWagonFromRight(), is(45));
    assertThat("7 expected", trainComposition.detachWagonFromRight(), is(7));
    assertThat("34 expected", trainComposition.detachWagonFromLeft(), is(34));
    assertThat("13 expected", trainComposition.detachWagonFromRight(), is(13));
  }
}
