package by.andd3dfx.common;

import org.junit.Test;

import static by.andd3dfx.common.InsuranceNumber.changeFormat;
import static by.andd3dfx.common.InsuranceNumber.changeFormatUsingRegExGroups;
import static org.assertj.core.api.Assertions.assertThat;

public class InsuranceNumberTest {

    @Test
    public void changeFormatNothingChanged() {
        assertThat(changeFormat("Please quote your policy number."))
                .isEqualTo("Please quote your policy number.");
    }

    @Test
    public void changeFormatSimple() {
        assertThat(changeFormat("Please quote your policy number: 112-39-8552."))
                .isEqualTo("Please quote your policy number: 112/8552/39.");
    }

    @Test
    public void changeFormatMultipleParagraphs() {
        assertThat(changeFormat("Please quote your policy numbers: 112-39-8552 and 134-39-9552."))
                .isEqualTo("Please quote your policy numbers: 112/8552/39 and 134/9552/39.");
    }

    @Test
    public void changeFormatWithNewStringDelimiter() {
        assertThat(changeFormat("Please quote your policy number: 112-39-\n8552."))
                .isEqualTo("Please quote your policy number: 112/\n8552/39.");
    }

    @Test
    public void changeFormatUsingRegExGroupsNothingChanged() {
        assertThat(changeFormatUsingRegExGroups("Please quote your policy number."))
                .isEqualTo("Please quote your policy number.");
    }

    @Test
    public void changeFormatUsingRegExGroupsSimple() {
        assertThat(changeFormatUsingRegExGroups("Please quote your policy number: 112-39-8552."))
                .isEqualTo("Please quote your policy number: 112/8552/39.");
    }

    @Test
    public void changeFormatUsingRegExGroupsMultipleParagraphs() {
        assertThat(changeFormatUsingRegExGroups("Please quote your policy numbers: 112-39-8552 and 134-39-9552."))
                .isEqualTo("Please quote your policy numbers: 112/8552/39 and 134/9552/39.");
    }

    @Test
    public void changeFormatUsingRegExGroupsWithNewStringDelimiter() {
        assertThat(changeFormatUsingRegExGroups("Please quote your policy number: 112-39-\n8552."))
                .isEqualTo("Please quote your policy number: 112/\n8552/39.");
    }
}
