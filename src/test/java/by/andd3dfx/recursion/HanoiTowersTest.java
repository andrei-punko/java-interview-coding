package by.andd3dfx.recursion;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertTrue;

public class HanoiTowersTest {

    @Test
    public void solve() {
        for (int height = 3; height <= 3; height++) {
            HanoiTowers hanoiTowers = new HanoiTowers(height);
            hanoiTowers.solve();
            checkIsFinished(hanoiTowers);
        }
    }

    private void checkIsFinished(HanoiTowers ht) {
        assertTrue("Left column should be empty", ht.left.stack.isEmpty());
        assertTrue("Middle column should be empty", ht.middle.stack.isEmpty());

        List<Integer> disks = ht.right.stack.stream().collect(Collectors.toList());
        for (int i = 1; i < disks.size(); i++) {
            assertThat(String.format("Disk %d should be greater than disk %d", i, i - 1),
                    disks.get(i - 1), greaterThan(disks.get(i)));
        }
    }
}
