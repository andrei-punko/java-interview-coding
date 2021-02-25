package by.andd3dfx.interview.wf.exam;

enum Side {NONE, LEFT, RIGHT}

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

  public static void main(String[] args) {
    ChainLink left = new ChainLink();
    ChainLink middle = new ChainLink();
    ChainLink right = new ChainLink();
    left.append(middle);
    middle.append(right);
    System.out.println(left.longerSide());
  }
}
