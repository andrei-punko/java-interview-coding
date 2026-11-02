package by.andd3dfx.recursion;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HanoiTowersTest {

    @Test
    public void solve1() {
        HanoiTowers hanoiTowers = new HanoiTowers(1);
        hanoiTowers.solve();
        checkIsFinished(hanoiTowers);
    }

    @Test
    public void solve2() {
        HanoiTowers hanoiTowers = new HanoiTowers(2);
        hanoiTowers.solve();
        checkIsFinished(hanoiTowers);
    }

    @Test
    public void solve3() {
        HanoiTowers hanoiTowers = new HanoiTowers(3);
        hanoiTowers.solve();
        checkIsFinished(hanoiTowers);
    }

    private void checkIsFinished(HanoiTowers ht) {
        assertTrue(ht.getLeft().getStack().isEmpty(), "Left column should be empty");
        assertTrue(ht.getMiddle().getStack().isEmpty(), "Middle column should be empty");

        List<Integer> disks = ht.getRight().getStack().stream().toList();
        for (int i = 1; i < disks.size(); i++) {
            assertThat(disks.get(i - 1))
                .as("Disk " + (i - 1) + " should be less than disk " + i)
                .isLessThan(disks.get(i));
        }
    }
}
