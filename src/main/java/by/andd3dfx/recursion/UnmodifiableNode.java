package by.andd3dfx.recursion;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. Modify given class Node to make it immutable:
 *
 * <pre>
 * public final class Node {
 *     private final List&lt;Node&gt; children;
 *     private final Integer value;
 * }
 * </pre>
 * <p>
 * 2. Provide name of this data structure
 * <p>
 * 3. Add sum() method to sum values of all items in this structure
 * <ul>
 *     <li>recursive way
 *     <li>non-recursive way
 * </ul>
 *
 * @see <a href="https://youtu.be/UaeleszV00w">Video solution</a>
 */
public final class UnmodifiableNode {

    private final List<UnmodifiableNode> children = new ArrayList<>();
    private final Integer value;

    public UnmodifiableNode(Integer value) {
        this.value = value;
    }

    public UnmodifiableNode(List<UnmodifiableNode> children, Integer value) {
        if (children != null) {
            this.children.addAll(children);
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public List<UnmodifiableNode> getChildren() {
        return new ArrayList<>(children);
    }

    public int sumRecursive() {
        return sumRecursive(this);
    }

    private int sumRecursive(UnmodifiableNode node) {
        var result = node.value;
        for (UnmodifiableNode child : node.getChildren()) {
            result += sumRecursive(child);
        }
        return result;
    }

    public int sumRecursive2() {
        return flattennedStream()
                .map(UnmodifiableNode::getValue)
                .reduce(0, (a, b) -> a + b);
    }

    private Stream<UnmodifiableNode> flattennedStream() {
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(UnmodifiableNode::flattennedStream)
        );
    }

    public int sumNonRecursive() {
        var result = value;
        var stack = new ArrayDeque<List<UnmodifiableNode>>();
        stack.add(children);

        while (!stack.isEmpty()) {
            for (var node : stack.pop()) {
                result += node.value;
                stack.add(node.children);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        if (children.isEmpty()) {
            return "{%d}".formatted(value);
        }
        return "{%d, %s}".formatted(value, children);
    }
}
