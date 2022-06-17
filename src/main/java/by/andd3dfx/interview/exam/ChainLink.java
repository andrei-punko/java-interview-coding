package by.andd3dfx.interview.exam;

enum Side {NONE, LEFT, RIGHT}

/**
 * You are holding one link of a chain in your hand. Implement method longerSide() to find which side of the
 * chain, relative to the link you are holding, has more links.
 * <p>
 * If the left side has more links return Side.LEFT, if the right side has more links return Side.RIGHT,
 * and if both sides have an equal number of links or if the chain is a closed loop, return Side.NONE.
 * <p>
 * For example, for the code below, the output should be Side.RIGHT:
 * <pre>
 *  ChainLink left = new ChainLink();
 *  ChainLink middle = new ChainLink();
 *  ChainLink right = new ChainLink();
 *  left.append(middle);
 *  middle.append(right);
 *  System.out.println(left.longerSide());
 * </pre>
 */
public class ChainLink {

  private ChainLink left, right;

  public void append(ChainLink rightPart) {
    if (this.right != null) {
      throw new IllegalStateException("Link is already connected.");
    }

    this.right = rightPart;
    rightPart.left = this;
  }

  public Side longerSide() {
    ChainLink startLeft = this.left;
    ChainLink startRight = this.right;

    while (true) {
      if (startLeft == this || startRight == this) {
        return Side.NONE;
      }
      if (startLeft == null && startRight == null) {
        return Side.NONE;
      }
      if (startLeft == null) {
        return Side.RIGHT;
      }
      if (startRight == null) {
        return Side.LEFT;
      }
      startLeft = startLeft.left;
      startRight = startRight.right;
    }
  }
}
