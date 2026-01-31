package by.andd3dfx.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ReverseWordsInAStringIIITest {

    @Test
    public void reverseWords() {
        assertThat(ReverseWordsInAStringIII.reverseWords("World"))
            .isEqualTo("dlroW");
        assertThat(ReverseWordsInAStringIII.reverseWords("a b c"))
            .isEqualTo("a b c");

        assertThat(ReverseWordsInAStringIII.reverseWords("Let's take LeetCode contest"))
            .isEqualTo("s'teL ekat edoCteeL tsetnoc");
        assertThat(ReverseWordsInAStringIII.reverseWords("Mr Ding"))
            .isEqualTo("rM gniD");
    }
}
