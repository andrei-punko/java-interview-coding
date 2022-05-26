package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class BracketsExpressionValidatorTest {

    @Test
    public void validate() {
        assertThat(BracketsExpressionValidator.validate("()")).isEqualTo(true);
        assertThat(BracketsExpressionValidator.validate("([{}])")).isEqualTo(true);
        assertThat(BracketsExpressionValidator.validate("()[]{}<>")).isEqualTo(true);
        assertThat(BracketsExpressionValidator.validate("([()<[]>]<{}(())>)")).isEqualTo(true);

        assertThat(BracketsExpressionValidator.validate("><")).isEqualTo(false);
        assertThat(BracketsExpressionValidator.validate("(][)")).isEqualTo(false);
        assertThat(BracketsExpressionValidator.validate(")")).isEqualTo(false);
        assertThat(BracketsExpressionValidator.validate("([)]")).isEqualTo(false);
        assertThat(BracketsExpressionValidator.validate("([)()<}{(){>]")).isEqualTo(false);
    }
}