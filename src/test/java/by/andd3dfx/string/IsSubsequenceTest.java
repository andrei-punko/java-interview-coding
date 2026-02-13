package by.andd3dfx.string;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class IsSubsequenceTest {

    @Test
    public void isSubsequence() {
        assertThat(IsSubsequence.isSubsequence("abc", "ahbgdc")).isTrue();
        assertThat(IsSubsequence.isSubsequence("axc", "ahbgdc")).isFalse();

        assertThat(IsSubsequence.isSubsequence("abc", "aaccbb")).isFalse();
        assertThat(IsSubsequence.isSubsequence("andrei", "rtaanghtdretyia")).isTrue();
    }
}
