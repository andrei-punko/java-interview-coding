package by.andd3dfx.recursion;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Test;

public class NodeTest {

    @Test
    public void sumRecursiveForPlainStructure() {
        Node node = new Node(12);
        assertEquals(12, node.sumRecursive());
    }

    @Test
    public void sumRecursiveForComplexStructure() {
        Node node = prepareComplexNode();
        assertEquals(49, node.sumRecursive());
    }

    @Test
    public void sumNonRecursiveForPlainStructure() {
        Node node = new Node(12);
        assertEquals(12, node.sumNonRecursive());
    }

    @Test
    public void sumNonRecursiveForComplexStructure() {
        Node node = prepareComplexNode();
        assertEquals(49, node.sumNonRecursive());
    }

    private Node prepareComplexNode() {
        return new Node(Arrays.asList(
            new Node(2),
            new Node(Arrays.asList(new Node(32)), 3)
        ), 12);
    }
}
