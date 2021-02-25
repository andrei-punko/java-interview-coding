package by.andd3dfx.interview.train2021;

/**
 * We have binary search tree:
 * <pre>
 * public interface Node {
 *    Node getParent();
 *    Node getLeft();
 *    Node getRight();
 * }
 * <pre/>
 * (Binary search tree: if item.value >= node.value - it belongs to right branch, if item.value < node.value - it belongs to left branch)
 *
 * Write method to determine next node:
 * public static Node next(Node node) {
 *     ...
 * }
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
        } else {
            // Go up by parents, until some transition will be left child of some node. If so - stop.
            return findParentWithLeftTransition(node);
        }
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
