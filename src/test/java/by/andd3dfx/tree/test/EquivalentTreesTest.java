package by.andd3dfx.tree.test;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class EquivalentTreesTest {

    private EquivalentTrees equivalentTrees;

    @Before
    public void setUp() throws Exception {
        equivalentTrees = new EquivalentTrees();
    }

    @Test
    public void findEquivalentSubtreesForNull() {
        assertThat(equivalentTrees.findEquivalentSubtrees(null), is(nullValue()));
    }

    @Test
    public void findEquivalentSubtreesForOneNode() {
        EquivalentTrees.Node node = new EquivalentTrees.Node('A');
        assertThat(equivalentTrees.findEquivalentSubtrees(node), is(nullValue()));
    }

    @Test
    public void findEquivalentSubtreesWhenNoCandidates() {
        EquivalentTrees.Node node = new EquivalentTrees.Node('A');
        node.left = new EquivalentTrees.Node('B');
        assertThat(equivalentTrees.findEquivalentSubtrees(node), is(nullValue()));
    }

    @Test
    public void findEquivalentSubtreesWhenOneCandidate() {
        EquivalentTrees.Node node = new EquivalentTrees.Node('A');
        node.left = new EquivalentTrees.Node('B');
        node.right = new EquivalentTrees.Node('B');

        List<EquivalentTrees.Node> result = equivalentTrees.findEquivalentSubtrees(node);

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(node.left, node.right));
    }

    @Test
    public void findEquivalentSubtreesWhenTwoCandidate() {
        EquivalentTrees.Node node = new EquivalentTrees.Node('A');
        node.left = new EquivalentTrees.Node('B');
        node.left.left = new EquivalentTrees.Node('X');
        node.right = new EquivalentTrees.Node('B');
        node.right.right = new EquivalentTrees.Node('X');

        List<EquivalentTrees.Node> result = equivalentTrees.findEquivalentSubtrees(node);

        assertThat(result.size(), is(2));
        assertThat(result, hasItems(node.left, node.right));
    }

    @Test
    public void findEquivalentSubtreesComplexCase() {
        EquivalentTrees.Node root = new EquivalentTrees.Node('A');
        root.left = new EquivalentTrees.Node('B');
        root.right = new EquivalentTrees.Node('C');

        root.left.left = new EquivalentTrees.Node('E');
        root.left.left.left = new EquivalentTrees.Node('D');

        root.right.left = new EquivalentTrees.Node('D');
        root.right.right = new EquivalentTrees.Node('E');
        root.right.right.left = new EquivalentTrees.Node('E');
        root.right.right.right = new EquivalentTrees.Node('D');

        List<EquivalentTrees.Node> result = equivalentTrees.findEquivalentSubtrees(root);

        assertThat("Two nodes expected", result.size(), is(2));
        assertThat("Left node is absent", result, hasItem(root.left));
        assertThat("Right node is absent", result, hasItem(root.right));
    }

}
