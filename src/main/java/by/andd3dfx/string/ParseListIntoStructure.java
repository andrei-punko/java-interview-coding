package by.andd3dfx.string;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * На вход приходит список строк вида:
 * [
 *     "key.subkey.subkey2=1",
 *     "key.subkey=2",
 *     "key.subkey3=3",
 *     "key2.subkey4=5"
 * ]
 *
 * Преобразовать в структуру вида (все строки заполняют одну структуру):
 *     public static class Properties {
 *         public Integer value;
 *         public Map<String, Properties> inner = new HashMap<>();
 *     }
 *
 * Сигнатура метода:
 *      public Properties parse(List<String> strings)
 *
 * Формат всегда корректный, значение есть всегда.
 *
 * Данные складываются так:
 * [
 *    "key": {
 *        "subkey": {
 *            "value": 2,
 *            "subkey2": {
 *                "value": 1
 *            }
 *        },
 *        "subkey3": {
 *            "value": 3
 *        }
 *    },
 *    "key2": {
 *        "subkey4": {
 *           "value": 5
 *        }
 *    }
 * ]
 * </pre>
 *
 * @see <a href="https://youtu.be/RW1DcmbzbQ8">Video solution</a>
 */
public class ParseListIntoStructure {

    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Properties {
        public Integer value;
        public Map<String, Properties> map = new HashMap<>();

        public Properties(Integer value) {
            this.value = value;
        }

        public Properties(Map<String, Properties> map) {
            this.map = map;
        }
    }

    public Properties parse(List<String> lines) {
        Properties result = new Properties();
        for (var line : lines) {
            var pair = line.split("=");

            var value = Integer.valueOf(pair[1]);
            var items = pair[0].split("\\.");

            populateContainer(value, items, 0, result);
        }
        return result;
    }

    private void populateContainer(Integer value, String[] items, int depth, Properties container) {
        if (items.length == depth) {
            container.value = value;
            return;
        }

        var key = items[depth];
        if (!container.map.containsKey(key)) {
            container.map.put(key, new Properties());
        }
        populateContainer(value, items, depth + 1, container.map.get(key));
    }
}
