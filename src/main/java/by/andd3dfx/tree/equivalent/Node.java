package by.andd3dfx.tree.equivalent;

import java.util.Objects;

public class Node {
    char value;  // [A-Z]
    Node left;
    Node right;

    public Node(char value) {
        this.value = value;
    }

    public Node(char value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" +
                value +
                ((left != null) ? (", l=" + left) : "") +
                ((right != null) ? (", r=" + right) : "") +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return value == node.value && Objects.equals(left, node.left) && Objects.equals(right, node.right);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, left, right);
    }
}
