package by.andd3dfx.numeric;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class ProductOfArrayExceptSelfTest {

    @Test
    public void productExceptSelf() {
        assertThat(ProductOfArrayExceptSelf.productExceptSelf(new int[]{0, 0, 0}))
            .isEqualTo(new int[]{0, 0, 0});
        assertThat(ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 1, 1, 1}))
            .isEqualTo(new int[]{1, 1, 1, 1});

        assertThat(ProductOfArrayExceptSelf.productExceptSelf(new int[]{1, 2, 3, 4}))
            .isEqualTo(new int[]{24, 12, 8, 6});
        assertThat(ProductOfArrayExceptSelf.productExceptSelf(new int[]{-1, 1, 0, -3, 3}))
            .isEqualTo(new int[]{0, 0, 9, 0, 0});
    }
}
