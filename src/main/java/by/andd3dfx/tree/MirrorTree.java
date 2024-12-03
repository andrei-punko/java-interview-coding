package by.andd3dfx.tree;

import lombok.AllArgsConstructor;

/**
 * Mirror binary tree: for each node left & right sub nodes should be swapped
 *
 * @see <a href="https://youtu.be/H2BBCUcVXDM">Video solution</a>
 */
public class MirrorTree {

    public static Node mirror(Node node) {
        if (node == null) {
            return null;
        }

        var oldLeft = node.left;
        node.left = mirror(node.right);
        node.right = mirror(oldLeft);
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
