package by.andd3dfx.common;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;

public class PasswordBruteforceTest {

    private PasswordBruteforce passwordBruteforce;
    private char[] alphabet;
    private Function<String, String> hashFunction;

    private static Random random = new Random();

    @Before
    public void setUp() throws Exception {
        alphabet = new char[]{'P', 'u', 'n', 'k', 'o'};
        var alphabetStr = new String(alphabet);

        hashFunction = s -> {
            char[] chars = s.toCharArray();
            var result = 0;
            for (int i = 0; i < chars.length; i++) {
                int index = alphabetStr.indexOf(chars[i]) + 1;
                result = 17 * result + index;
            }
            return String.valueOf(result);
        };

        passwordBruteforce = new PasswordBruteforce(alphabet, hashFunction);
    }

    @Test
    public void encode() {                                                 // ☺Punko -> 012345
        assertThat(passwordBruteforce.encode(1)).isEqualTo("P");      // 1 = 1*6^0 = 1 = P
        assertThat(passwordBruteforce.encode(2)).isEqualTo("u");      // 2 = 2*6^0 = 2 = u
        assertThat(passwordBruteforce.encode(31)).isEqualTo("oP");    // 31 = 5*6^1 + 1*6^0 = 30 + 1 = oP
        assertThat(passwordBruteforce.encode(59)).isEqualTo("Pno");   // 59 = 1*6^2 + 3*6^1 + 5*6^0 = 36 + 18 + 5 = Pno
    }

    @Test
    public void decodeSimple() {
        decodeUsingDefinitePassword("P");
        decodeUsingDefinitePassword("PuPu");
        decodeUsingDefinitePassword("Punk");
        decodeUsingDefinitePassword("nuk");
    }

    @Test
    public void decodeRandomized() {
        int times = 10;

        for (var iteration = 0; iteration < times; iteration++) {
            String password = generatePassword();
            decodeUsingDefinitePassword(password);
        }
    }

    @Test
    public void decodeWhenHashContainsWrongCharacters() {
        assertNull(passwordBruteforce.decode("1a", 4));
    }

    private String generatePassword() {
        var passwordLength = 3 + random.nextInt(3);
        char[] chars = new char[passwordLength];

        for (int i = 0; i < passwordLength; i++) {
            chars[i] = alphabet[random.nextInt(alphabet.length)];
        }
        return new String(chars);
    }

    private void decodeUsingDefinitePassword(String password) {
        String hash = hashFunction.apply(password);
        System.out.println("password=" + password + ", hash=" + hash);
        assertThat(passwordBruteforce.decode(hash, password.length())).isEqualTo(password);
    }
}
