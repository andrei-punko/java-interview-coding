package by.andd3dfx.common;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * According to https://stackoverflow.com/questions/742013/how-do-i-create-a-url-shortener/742047
 *
 * - Реализовать сократитель ссылок
 * 1. берем строку из символов англ. алфавита и цифр: abc..zABC..Z01..9 (62 символа)
 * 2. сохраняем исходную ссылку в БД, кодируем полученную ID записи по основанию 62 в цифро-буквенную строку S
 * 3. сохраняем в БД (в ту же строку) цифро-буквенную строку S
 * 4. возвращаем юзеру закодированную цифро-буквенную строку S
 *
 * - Описать реализацию шардирования сократителя ссылок
 * = Кодирование длинного урла (1-й вариант):
 * 1. из исходного url отбрасываем 'http://' вначале, берем 1+ первых букв (сколько - зависит от кол-ва шард N у нас),
 * кодируем эту пару букв в число (с основанием 26), берем остаток от деления числа этого на N - это будет номер шарды
 * 2. добавляем в таблицу БД новую запись вида (ID, LONG_STRING), генерируем короткую строку SHORT_STRING по ID, дописываем SHORT_STRING в эту строку.
 * 3. возвращаем пользователю строку вида 'http://' + домен_кодировщика_урлов + '/' + (использованные первые буквы исх. урла) + SHORT_STRING
 *
 * = Декодирование короткого урла (1-й вариант):
 * 1. достаем нужное кол-во первых букв, декодируем в номер шарды
 * 2. из данной шарды достаем данные по ключу, полученного декодированием остальной строки
 * 3. возвращаем юзеру LONG_STRING
 *
 * = Кодирование url-a (2й вариант):
 * 1. выбираем случайную шарду; конвертируем номер шарды в букву (либо несколько букв, если шард много); так получим строку SHARD_STRING
 * 2. см. п.2 выше
 * 3. возвращаем пользователю строку вида 'http://' + домен_кодировщика_урлов + '/' + SHARD_STRING + SHORT_STRING
 *
 * = Декодирование короткого урла (2‑й вариант):
 * совпадает с первым вариантом
 * </pre>
 *
 * @see <a href="https://youtu.be/iUBWIZE_vo4">Video solution</a>
 */
public class UrlShortener {

    private final String ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private final int BASE = ALPHABET.length();

    private Long dbPrimaryKey = 0L;
    private final Map<Long, String> db = new HashMap<>();
    private final Map<String, String> cache = new HashMap<>();

    public String buildShortUrl(String longString) {
        if (cache.containsKey(longString)) {
            return cache.get(longString);
        }

        dbPrimaryKey++;
        db.put(dbPrimaryKey, longString);

        String shortString = encodePrimaryKeyToShortString(dbPrimaryKey);
        cache.put(longString, shortString);
        return shortString;
    }

    public String restoreLongUrl(String shortString) {
        Long primaryKey = decodeShortStringToPrimaryKey(shortString);
        return db.get(primaryKey);
    }

    String encodePrimaryKeyToShortString(Long dbPrimaryKey) {
        StringBuilder sb = new StringBuilder();
        while (dbPrimaryKey > 0) {
            Long remainder = dbPrimaryKey % BASE;
            sb.append(ALPHABET.charAt(remainder.intValue()));
            dbPrimaryKey = dbPrimaryKey / BASE;
        }
        return sb.reverse().toString();
    }

    Long decodeShortStringToPrimaryKey(String shortString) {
        Long result = 0L;
        for (char character : shortString.toCharArray()) {
            int charIndex = ALPHABET.indexOf(character);
            result = result * BASE + charIndex;
        }
        return result;
    }
}
