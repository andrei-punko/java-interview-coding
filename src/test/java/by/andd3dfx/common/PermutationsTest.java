package by.andd3dfx.common;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PermutationsTest {

    @Test
    public void permute1() {
        List<List<Integer>> result = Permutations.permute(new int[]{1});
        assertThat(result)
            .hasSameElementsAs(List.of(
                    List.of(1)
                )
            );
    }

    @Test
    public void permute2() {
        assertThat(Permutations.permute(new int[]{1, 2}))
            .hasSameElementsAs(List.of(
                    List.of(1, 2),
                    List.of(2, 1)
                )
            );
    }

    @Test
    public void permute3() {
        assertThat(Permutations.permute(new int[]{1, 2, 3}))
            .hasSameElementsAs(List.of(
                    List.of(1, 2, 3),
                    List.of(1, 3, 2),
                    List.of(2, 1, 3),
                    List.of(2, 3, 1),
                    List.of(3, 1, 2),
                    List.of(3, 2, 1)
                )
            );
    }

    @Test
    public void permute4() {
        assertThat(Permutations.permute(new int[]{1, 2, 3, 4}))
            .hasSameElementsAs(List.of(
                    List.of(1, 2, 3, 4),
                    List.of(1, 2, 4, 3),
                    List.of(1, 3, 2, 4),
                    List.of(1, 3, 4, 2),
                    List.of(1, 4, 2, 3),
                    List.of(1, 4, 3, 2),

                    List.of(2, 1, 3, 4),
                    List.of(2, 1, 4, 3),
                    List.of(2, 3, 1, 4),
                    List.of(2, 3, 4, 1),
                    List.of(2, 4, 1, 3),
                    List.of(2, 4, 3, 1),

                    List.of(3, 1, 2, 4),
                    List.of(3, 1, 4, 2),
                    List.of(3, 2, 1, 4),
                    List.of(3, 2, 4, 1),
                    List.of(3, 4, 1, 2),
                    List.of(3, 4, 2, 1),

                    List.of(4, 1, 2, 3),
                    List.of(4, 1, 3, 2),
                    List.of(4, 2, 1, 3),
                    List.of(4, 2, 3, 1),
                    List.of(4, 3, 1, 2),
                    List.of(4, 3, 2, 1)
                )
            );
    }
}
