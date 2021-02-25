package by.andd3dfx.recursion;

import java.util.Stack;

public class HanoiTowers {

    public class Column {
        String name;
        Stack<Integer> stack = new Stack<>();

        public Column(String name) {
            this.name = name;
        }
    }

    final int height;
    Column left;
    Column middle;
    Column right;

    public HanoiTowers(int height) {
        this.height = height;
        this.left = new Column("Left");
        for (int i = 0; i < height; i++) {
            left.stack.push(height - i);
        }
        this.middle = new Column("Middle");
        this.right = new Column("Right");
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
