package by.andd3dfx.string;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CaesarCipherTest {

    private CaesarCipher caesarCipher;

    @Before
    public void setUp() throws Exception {
        caesarCipher = new CaesarCipher();
    }

    @Test
    public void encode() {
        assertThat(caesarCipher.encode("андрей", 0)).isEqualTo("андрей");
        assertThat(caesarCipher.encode("абвгде", 1)).isEqualTo("бвгдеё");
        assertThat(caesarCipher.encode("это яблоко красное", 7)).isEqualTo("дщх ёзтхсх счжшфхл");
    }

    @Test
    public void decode() {
        assertThat(caesarCipher.decode("андрей", 0)).isEqualTo("андрей");
        assertThat(caesarCipher.decode("бвгдеё", 1)).isEqualTo("абвгде");
        assertThat(caesarCipher.decode("дщх ёзтхсх счжшфхл", 7)).isEqualTo("это яблоко красное");
    }
}
