package by.andd3dfx.tree;

/**
 * <pre>
 * We have binary search tree:
 *
 * public interface Node {
 *    Node getParent();
 *    Node getLeft();
 *    Node getRight();
 * }
 *
 * If item.value >= node.value - it belongs to right branch,
 * If item.value < node.value - it belongs to left branch
 *
 * Write method next() to determine next node:
 * public Node next(Node node) {
 *     ...
 * }
 * <pre/>
 */
public class NextNodeForBinarySearchTree {

    public interface Node {
        Node getParent();

        Node getLeft();

        Node getRight();
    }

    public static Node next(Node node) {
        if (node.getRight() != null) {
            // Find left-most node of right child of 'node'
            return findLeftMostNode(node.getRight());
        }
        // Go up by parents, until some transition will be left child of some node. If so - stop.
        return findParentWithLeftTransition(node);
    }

    private static Node findLeftMostNode(Node node) {
        if (node.getLeft() == null) {
            return node;
        }
        return findLeftMostNode(node.getLeft());
    }

    private static Node findParentWithLeftTransition(Node node) {
        if (node.getParent() == null) {
            return node;
        }
        if (node.getParent().getLeft() == node) {
            return node.getParent();
        }
        return findParentWithLeftTransition(node.getParent());
    }
}
