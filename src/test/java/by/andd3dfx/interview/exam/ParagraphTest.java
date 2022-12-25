package by.andd3dfx.interview.exam;

import static by.andd3dfx.interview.exam.Paragraph.changeFormat;
import static by.andd3dfx.interview.exam.Paragraph.changeFormat2;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class ParagraphTest {

  @Test
  public void changeFormatNothingChanged() {
    assertThat(changeFormat("Please quote your policy number."),
        is("Please quote your policy number."));
  }

  @Test
  public void changeFormatSimple() {
    assertThat(changeFormat("Please quote your policy number: 112-39-8552."),
        is("Please quote your policy number: 112/8552/39."));
  }

  @Test
  public void changeFormatMultipleParagraphs() {
    assertThat(changeFormat("Please quote your policy numbers: 112-39-8552 and 134-39-9552."),
        is("Please quote your policy numbers: 112/8552/39 and 134/9552/39."));
  }

  @Test
  public void changeFormatWithNewStringDelimiter() {
    assertThat(changeFormat("Please quote your policy number: 112-39-\n8552."),
        is("Please quote your policy number: 112/\n8552/39."));
  }

  @Test
  public void changeFormat2NothingChanged() {
    assertThat(changeFormat2("Please quote your policy number."),
        is("Please quote your policy number."));
  }

  @Test
  public void changeFormat2Simple() {
    assertThat(changeFormat2("Please quote your policy number: 112-39-8552."),
        is("Please quote your policy number: 112/8552/39."));
  }

  @Test
  public void changeFormat2MultipleParagraphs() {
    assertThat(changeFormat2("Please quote your policy numbers: 112-39-8552 and 134-39-9552."),
        is("Please quote your policy numbers: 112/8552/39 and 134/9552/39."));
  }

  @Test
  public void changeFormat2WithNewStringDelimiter() {
    assertThat(changeFormat2("Please quote your policy number: 112-39-\n8552."),
        is("Please quote your policy number: 112/\n8552/39."));
  }
}
