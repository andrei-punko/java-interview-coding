package by.andd3dfx.common;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GenerateParenthesesTest {

    @Test
    public void generate1() {
        assertThat(GenerateParentheses.generate(1))
            .containsExactlyInAnyOrder("()");
    }

    @Test
    public void generate2() {
        assertThat(GenerateParentheses.generate(2))
            .containsExactlyInAnyOrder("()()", "(())");
    }

    @Test
    public void generate3() {
        assertThat(GenerateParentheses.generate(3))
            .containsExactlyInAnyOrder("((()))", "(()())", "(())()", "()(())", "()()()");
    }

    @Test
    public void generate4() {
        assertThat(GenerateParentheses.generate(4))
            .containsExactlyInAnyOrder("(((())))", "((()()))", "((())())", "((()))()", "(()(()))",
                "(()()())", "(()())()", "(())(())", "(())()()", "()((()))", "()(()())", "()(())()",
                "()()(())", "()()()()");
    }
}
