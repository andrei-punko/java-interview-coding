package by.andd3dfx.recursion;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
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
        assertTrue("Left column should be empty", ht.getLeft().getStack().isEmpty());
        assertTrue("Middle column should be empty", ht.getMiddle().getStack().isEmpty());

        List<Integer> disks = ht.getRight().getStack().stream().collect(Collectors.toList());
        for (int i = 1; i < disks.size(); i++) {
            assertThat("Disk " + (i - 1) + " should be less than disk " + i,
                    disks.get(i - 1),
                    lessThan(disks.get(i))
            );
        }
    }
}
