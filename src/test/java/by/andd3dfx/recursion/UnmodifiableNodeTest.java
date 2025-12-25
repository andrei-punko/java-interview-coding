package by.andd3dfx.recursion;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class UnmodifiableNodeTest {

    @Test
    public void sumRecursiveForPlainNode() {
        UnmodifiableNode node = new UnmodifiableNode(12);
        assertThat(node.sumRecursive()).isEqualTo(12);
    }

    @Test
    public void sumRecursiveForComplexNode() {
        UnmodifiableNode node = prepareComplexNode();
        assertThat(node.sumRecursive()).isEqualTo(60);
    }

    @Test
    public void sumRecursive2ForPlainNode() {
        UnmodifiableNode node = new UnmodifiableNode(12);
        assertThat(node.sumRecursive2()).isEqualTo(12);
    }

    @Test
    public void sumRecursive2ForComplexNode() {
        UnmodifiableNode node = prepareComplexNode();
        assertThat(node.sumRecursive2()).isEqualTo(60);
    }

    @Test
    public void sumNonRecursiveForPlainNode() {
        UnmodifiableNode node = new UnmodifiableNode(12);
        assertThat(node.sumNonRecursive()).isEqualTo(12);
    }

    @Test
    public void sumNonRecursiveForComplexNode() {
        UnmodifiableNode node = prepareComplexNode();
        assertThat(node.sumNonRecursive()).isEqualTo(60);
    }

    @Test
    public void checkImmutability() {
        var node = new UnmodifiableNode(
            List.of(new UnmodifiableNode(2), new UnmodifiableNode(3)),
            12
        );
        var oldValue = node.getChildren().get(0);
        var newValue = new UnmodifiableNode(333);
        node.getChildren().set(0, newValue);

        assertThat(node.getChildren().get(0)).isEqualTo(oldValue);
    }

    @Test
    public void testToString() {
        UnmodifiableNode node = prepareComplexNode();
        assertThat(node.toString()).isEqualTo("{12, [{2}, {3, [{32}, {11}]}]}");
    }

    private UnmodifiableNode prepareComplexNode() {
        return new UnmodifiableNode(Arrays.asList(
            new UnmodifiableNode(2),
            new UnmodifiableNode(List.of(new UnmodifiableNode(32), new UnmodifiableNode(11)), 3)
        ), 12);
    }
}
