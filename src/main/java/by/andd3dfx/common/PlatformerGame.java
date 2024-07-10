package by.andd3dfx.common;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A character in a platformer game is standing on a single row of floor tiles numbered 0 to N, at position X.
 * <p>
 * When the character moves, the tile at the previous position disappears. The character can only move left and right,
 * and always jump over one tile, and any holes. The character will not move if there are no tiles left to move to
 * (you do not need to implement this in the code).
 * <p>
 * Implement a class that models this behavior and can report the character's position.
 * <p>
 * For example, new Platformer(6, 3) creates a row of 6 tiles (numbered 0 to 5) and a character positioned
 * on the 3 {0 1 2 [3] 4 5}. A call to jumpLeft() moves the character two tiles to the left and the tile at position 3
 * disappears {0 [1] 2 4 5}. A subsequent call to jumpRight() moves the character two tiles to the right and the tile
 * at position 1 disappears, skipping tiles that have disappeared {0 2 [4] 5}.
 * <pre>
 * public class Platformer {
 *
 *   public Platformer(int n, int position) {
 *     throw new UnsupportedOperationException("Waiting to be implemented");
 *   }
 *
 *   public void jumpLeft() {
 *     throw new UnsupportedOperationException("Waiting to be implemented");
 *   }
 *
 *   public void jumpRight() {
 *     throw new UnsupportedOperationException("Waiting to be implemented");
 *   }
 *
 *   public int position() {
 *     throw new UnsupportedOperationException("Waiting to be implemented");
 *   }
 * }
 * </pre>
 *
 * @see <a href="https://youtu.be/okH8weUwc8k">Video solution</a>
 */
public class PlatformerGame {

    private Deque<Integer> left = new ArrayDeque<>();
    private Deque<Integer> right = new ArrayDeque<>();
    private Integer position;

    public PlatformerGame(int n, Integer position) {
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
}
