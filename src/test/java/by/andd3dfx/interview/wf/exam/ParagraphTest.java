package by.andd3dfx.interview.wf.exam;

import static by.andd3dfx.interview.wf.exam.Paragraph.changeFormat;
import static by.andd3dfx.interview.wf.exam.Paragraph.changeFormatAnotherWay;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ParagraphTest {

  @Test
  public void changeFormatNothingChanged() {
    assertThat("Unexpected string", changeFormat("Please quote your policy number."),
        is("Please quote your policy number."));
  }

  @Test
  public void changeFormatSimple() {
    assertThat("Unexpected string", changeFormat("Please quote your policy number: 112-39-8552."),
        is("Please quote your policy number: 112/8552/39."));
  }

  @Test
  public void changeFormatMultipleParagraphs() {
    assertThat("Unexpected string", changeFormat("Please quote your policy numbers: 112-39-8552 and 134-39-9552."),
        is("Please quote your policy numbers: 112/8552/39 and 134/9552/39."));
  }

  @Test
  public void changeFormatWithNewStringDelimeter() {
    assertThat("Unexpected string", changeFormat("Please quote your policy number: 112-39-\n8552."),
        is("Please quote your policy number: 112/\n8552/39."));
  }

  @Test
  public void changeFormatAnotherWayNothingChanged() {
    assertThat("Unexpected string", changeFormatAnotherWay("Please quote your policy number."),
        is("Please quote your policy number."));
  }

  @Test
  public void changeFormatAnotherWaySimple() {
    assertThat("Unexpected string", changeFormatAnotherWay("Please quote your policy number: 112-39-8552."),
        is("Please quote your policy number: 112/8552/39."));
  }

  @Test
  public void changeFormatAnotherWayMultipleParagraphs() {
    assertThat("Unexpected string", changeFormatAnotherWay("Please quote your policy numbers: 112-39-8552 and 134-39-9552."),
        is("Please quote your policy numbers: 112/8552/39 and 134/9552/39."));
  }

  @Test
  public void changeFormatAnotherWayWithNewStringDelimeter() {
    assertThat("Unexpected string", changeFormatAnotherWay("Please quote your policy number: 112-39-\n8552."),
        is("Please quote your policy number: 112/\n8552/39."));
  }
}
