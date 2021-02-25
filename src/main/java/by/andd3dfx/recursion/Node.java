package by.andd3dfx.recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1. Modify given class Node to make it immutable:
 *
 * <pre>
 * public final class Node {
 *     private final List<Node> children;
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
 */
public class Node {

    private final List<Node> children = new ArrayList<>();
    private final Integer value;

    public Node(Integer value) {
        this.value = value;
    }

    public Node(List<Node> children, Integer value) {
        if (children != null) {
            this.children.addAll(children);
        }
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public List<Node> getChildren() {
        List<Node> result = new ArrayList();
        result.addAll(children);
        return result;
    }

    public int sumRecursive() {
        return sum(this);
    }

    private int sum(Node node) {
        Integer result = node.value;
        for (Node child : node.getChildren()) {
            result += sum(child);
        }
        return result;
    }

    public int sumNonRecursive() {
        return flattened().map(Node::getValue).reduce(0, (a, b) -> a + b);
    }

    private Stream<Node> flattened() {
        return Stream.concat(
            Stream.of(this),
            children.stream().flatMap(Node::flattened)
        );
    }

    @Override
    public String toString() {
        return "Node{" +
            "children=" + children +
            ", value=" + value +
            '}';
    }
}
