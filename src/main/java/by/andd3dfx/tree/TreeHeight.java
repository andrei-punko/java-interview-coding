package by.andd3dfx.tree;

import lombok.AllArgsConstructor;

/**
 * Determine height/depth of binary tree
 *
 * @see <a href="https://youtu.be/xTftgqH0WVI">Video solution</a>
 */
public class TreeHeight {

    public static int calcHeight(Node node) {
        if (node == null) {
            return 0;
        }

        var leftHeight = calcHeight(node.left);
        var rightHeight = calcHeight(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
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
