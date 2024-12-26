package by.andd3dfx.string;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * <pre>
 * Расшифровка методом Цезаря
 *
 * Вы разрабатываете программу для расшифровки текстовых сообщений, зашифрованных методом Цезаря.
 * Этот метод подразумевает сдвиг каждой буквы текста на фиксированное количество позиций в алфавите.
 * Например, при сдвиге на 3 позиции буква А становится Г, а Я становится В. Соответственно, при расшифровке
 * нужно двигаться в обратном порядке.
 * Ваша задача — написать функцию, которая принимает на вход зашифрованную по методу Цезаря строку текста и
 * целое число (сдвиг), и возвращает расшифрованную версию. Алфавит уже задан в прекоде.
 *
 * Формат ввода:
 * Входные данные состоят из двух строк: первая строка содержит произвольный зашифрованный текст
 * (только строчные буквы русского алфавита и пробелы), вторая строка содержит целое число — величину сдвига (1 ≤ x ≤ 32).
 * Формат вывода
 * Выходные данные должны состоять из одной строки, содержащей расшифрованный текст. Пробел расшифровывать не нужно.
 *
 * Пример 1:
 * Входные данные:
 * бвгдеё
 * 1
 *
 * Выходные данные:
 * абвгде
 *
 * Пример 2:
 * Входные данные:
 * дщх ёзтхсх счжшфхл
 * 7
 *
 * Выходные данные:
 * это яблоко красное
 * </pre>
 */
public class CaesarCipher {

    // Русский алфавит
    private static final String ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";

    public String encode(String text, int shift) {
        var words = text.split(" ");
        return Arrays.stream(words)
                .map(word -> encodeWord(word, shift))
                .collect(Collectors.joining(" "));
    }

    private String encodeWord(String text, int shift) {
        var chars = text.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var targetIndex = ALPHABET.indexOf(chars[i]) + shift;
            targetIndex %= ALPHABET.length();
            chars[i] = ALPHABET.charAt(targetIndex);
        }
        return new String(chars);
    }

    public String decode(String encryptedText, int shift) {
        var words = encryptedText.split(" ");
        return Arrays.stream(words)
                .map(word -> decodeWord(word, shift))
                .collect(Collectors.joining(" "));
    }

    private String decodeWord(String encryptedText, int shift) {
        var chars = encryptedText.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var targetIndex = ALPHABET.indexOf(chars[i]) - shift + ALPHABET.length();
            targetIndex %= ALPHABET.length();
            chars[i] = ALPHABET.charAt(targetIndex);
        }
        return new String(chars);
    }
}
