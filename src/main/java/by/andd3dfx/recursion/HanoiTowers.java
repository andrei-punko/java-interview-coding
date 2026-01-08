package by.andd3dfx.recursion;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @see <a href="https://youtu.be/8fkHg9JKKmg">Video solution</a>
 */
@Getter
public class HanoiTowers {

    @RequiredArgsConstructor
    public static class Column {
        private final String name;
        @Getter
        private final Deque<Integer> stack = new ArrayDeque<>();
    }

    private final int height;
    private final Column left;
    private final Column middle;
    private final Column right;

    public HanoiTowers(int height) {
        this.height = height;
        left = new Column("Left");
        for (int i = 0; i < height; i++) {
            left.stack.push(height - i);
        }
        middle = new Column("Middle");
        right = new Column("Right");
    }

    public void solve() {
        moveUpperNDisksFromColumnIToColumnJUsingColumnKIfNeeded(height, left, right, middle);
    }

    private void moveUpperNDisksFromColumnIToColumnJUsingColumnKIfNeeded(int n, Column from, Column to, Column tmp) {
        if (n > 1) {
            moveUpperNDisksFromColumnIToColumnJUsingColumnKIfNeeded(n - 1, from, tmp, to);
        }
        moveDisk(from, to);
        if (n > 1) {
            moveUpperNDisksFromColumnIToColumnJUsingColumnKIfNeeded(n - 1, tmp, to, from);
        }
    }

    private void moveDisk(Column from, Column to) {
        Integer disk = from.stack.pop();

        System.out.println("Moved disk " + disk + " from " + from.name + " to " + to.name);

        validate(disk, to);
        to.stack.push(disk);
    }

    private void validate(Integer disk, Column to) {
        if (to.stack.isEmpty()) {
            return;
        }
        if (disk < to.stack.peek()) {
            return;
        }
        throw new IllegalStateException("Placement of this disk is forbidden!");
    }
}
