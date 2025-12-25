package by.andd3dfx.game;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GiftShopTest {

    @Test
    public void determinePart1() {
        assertThat(GiftShop.determinePart1("11-22")).isEqualTo(11 + 22);
        assertThat(GiftShop.determinePart1("95-115")).isEqualTo(99);
        assertThat(GiftShop.determinePart1("1188511880-1188511890")).isEqualTo(1188511885);
        assertThat(GiftShop.determinePart1("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862")).isEqualTo(1227775554L);
    }

    @Test
    public void determinePart2() {
        assertThat(GiftShop.determinePart2("11-22")).isEqualTo(11 + 22);
        assertThat(GiftShop.determinePart2("95-115")).isEqualTo(99 + 111);
        assertThat(GiftShop.determinePart2("998-1012")).isEqualTo(999 + 1010);
        assertThat(GiftShop.determinePart2("1188511880-1188511890")).isEqualTo(1188511885);
        assertThat(GiftShop.determinePart2("222220-222224")).isEqualTo(222222);
        assertThat(GiftShop.determinePart2("1698522-1698528")).isEqualTo(0);
        assertThat(GiftShop.determinePart2("446443-446449")).isEqualTo(446446);
        assertThat(GiftShop.determinePart2("38593856-38593862")).isEqualTo(38593859);
        assertThat(GiftShop.determinePart2("565653-565659")).isEqualTo(565656);
        assertThat(GiftShop.determinePart2("2121212118-2121212124")).isEqualTo(2121212121);
        assertThat(GiftShop.determinePart2("11-22,95-115,998-1012,1188511880-1188511890,222220-222224," +
            "1698522-1698528,446443-446449,38593856-38593862,565653-565659,824824821-824824827,2121212118-2121212124")).isEqualTo(4174379265L);
    }

    @Test
    public void isInvalid2() {
        assertThat(GiftShop.isInvalid2(1L)).isEqualTo(false);
        assertThat(GiftShop.isInvalid2(11L)).isEqualTo(true);
        assertThat(GiftShop.isInvalid2(111L)).isEqualTo(true);
        assertThat(GiftShop.isInvalid2(1111111L)).isEqualTo(true);
        assertThat(GiftShop.isInvalid2(11111117L)).isEqualTo(false);
        assertThat(GiftShop.isInvalid2(123L)).isEqualTo(false);
        assertThat(GiftShop.isInvalid2(123123L)).isEqualTo(true);
        assertThat(GiftShop.isInvalid2(123123123L)).isEqualTo(true);
        assertThat(GiftShop.isInvalid2(1231231234L)).isEqualTo(false);
        assertThat(GiftShop.isInvalid2(1212121212L)).isEqualTo(true);
    }
}
