package by.andd3dfx.interview.wf.exam;

import java.util.ArrayDeque;
import java.util.Deque;

public class Platformer {

  private Deque<Integer> left = new ArrayDeque<>();
  private Deque<Integer> right = new ArrayDeque<>();
  private Integer position;

  public Platformer(int n, int position) {
    for (int i = 0; i < position; i++) {
      left.add(i);
    }
    for (int i = position + 1; i < n; i++) {
      right.add(i);
    }
    this.position = position;
  }

  public void jumpLeft() {
    if (left.size() < 2) {
      return;
    }
    right.addFirst(left.pollLast());
    position = left.pollLast();
  }

  public void jumpRight() {
    if (right.size() < 2) {
      return;
    }
    left.addLast(right.pollFirst());
    position = right.pollFirst();
  }

  public int position() {
    return position;
  }

  public static void main(String[] args) {
    Platformer platformer = new Platformer(6, 3);
    System.out.println(platformer.position());

    platformer.jumpLeft();
    System.out.println(platformer.position());

    platformer.jumpRight();
    System.out.println(platformer.position());
  }
}
