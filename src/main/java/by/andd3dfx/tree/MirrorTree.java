package by.andd3dfx.tree;

import lombok.AllArgsConstructor;

/**
 * Mirror binary tree: for each node left & right sub nodes should be swapped
 */
public class MirrorTree {

    public static Node mirror(Node node) {
        if (node == null) {
            return null;
        }

        var oldLeft = mirror(node.left);
        node.left = mirror(node.right);
        node.right = oldLeft;
        return node;
    }

    @AllArgsConstructor
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }
}
