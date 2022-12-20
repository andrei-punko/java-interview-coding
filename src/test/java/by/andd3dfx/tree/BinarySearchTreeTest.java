package by.andd3dfx.tree;

import by.andd3dfx.tree.BinarySearchTree.Node;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BinarySearchTreeTest {

    /**
     * <pre>
     *      5
     *     / \
     *    2   7
     *   /   / \
     *  1   6   8
     * </pre>
     */
    @Test
    public void testContains() {
        var n1 = new Node(1, null, null);
        var n6 = new Node(6, null, null);
        var n8 = new Node(8, null, null);
        var n2 = new Node(2, n1, null);
        var n7 = new Node(7, n6, n8);
        var n5 = new Node(5, n2, n7);

        assertTrue(Node.contains(n5, 1));
        assertTrue(Node.contains(n5, 2));
        assertTrue(Node.contains(n5, 5));
        assertTrue(Node.contains(n5, 6));
        assertTrue(Node.contains(n5, 7));
        assertTrue(Node.contains(n5, 8));
        assertFalse(Node.contains(n5, 4));
        assertTrue(n5.contains(1));
        assertTrue(n5.contains(2));
        assertTrue(n5.contains(5));
        assertTrue(n5.contains(6));
        assertTrue(n5.contains(7));
        assertTrue(n5.contains(8));
        assertFalse(n5.contains(4));

        assertTrue(Node.contains(n2, 1));
        assertTrue(Node.contains(n2, 2));
        assertFalse(Node.contains(n2, 7));
        assertTrue(n2.contains(1));
        assertTrue(n2.contains(2));
        assertFalse(n2.contains(7));

        assertTrue(Node.contains(n7, 6));
        assertTrue(Node.contains(n7, 7));
        assertTrue(Node.contains(n7, 8));
        assertFalse(Node.contains(n7, 2));
        assertTrue(n7.contains(6));
        assertTrue(n7.contains(7));
        assertTrue(n7.contains(8));
        assertFalse(n7.contains(2));
    }
}