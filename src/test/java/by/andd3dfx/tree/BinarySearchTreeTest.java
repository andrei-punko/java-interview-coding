package by.andd3dfx.tree;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

public class BinarySearchTreeTest {

  @Test
  public void contains() {
    Node n1 = new Node(1, null, null);
    Node n3 = new Node(3, null, null);
    Node n2 = new Node(2, n1, n3);

    assertThat("Contains 3", BinarySearchTree.contains(n2, 3), is(true));
    assertThat("Not contains 3", BinarySearchTree.contains(n1, 3), is(false));
  }
}
