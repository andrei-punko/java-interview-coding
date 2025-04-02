package by.andd3dfx.tree.equivalent;

import java.util.HashSet;
import java.util.Set;

public class Node {
    char value;  // [A-Z]
    Node left;
    Node right;

    Set<Character> vocabulary = new HashSet<>();
    int subtreeSize;

    public Node(char value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "{" +
                value +
                ((left != null) ? (", l=" + left) : "") +
                ((right != null) ? (", r=" + right) : "") +
                '}';
    }
}
