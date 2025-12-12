package by.andd3dfx.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftShopTest {

    @Test
    public void determine() {
        assertThat(GiftShop.determine("11-22")).isEqualTo(11 + 22);
        assertThat(GiftShop.determine("95-115")).isEqualTo(99);
        assertThat(GiftShop.determine("1188511880-1188511890")).isEqualTo(1188511885);
        assertThat(GiftShop.determine("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
                "1698522-1698528,446443-446449,38593856-38593862")).isEqualTo(1227775554);
    }
}
