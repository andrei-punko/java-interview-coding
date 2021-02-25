package by.andd3dfx.string.parsing;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
На вход приходит список строк вида:
[
    "key.subkey.subkey2=1",
    "key.subkey=2",
    "key.subkey3=3",
    "key2.subkey4=5"
]

Преобразовать в структуру вида (все строки заполняют одну структуру):
    public static class Properties {
        public Integer value;
        public Map<String, Properties> inner = new HashMap<>();
    }

Сигнатура метода:
     public Properties parse(List<String> strings)

Формат всегда корректный, значение есть всегда.
Данные складываются вот так:
[
   "key": {
       "subkey": {
           "value": 2,
           "subkey2": {
               "value": 1
           }
       },
       "subkey3": {
           "value": 3
       }
   },
   "key2": {
       "subkey4": {
          "value": 5
       }
   }
]
*/
public class ParseListIntoStructure {
    public static class Properties {
        public Integer value;
        public Map<String, Properties> inner = new HashMap<>();
    }

    public Properties parse(List<String> strings) {
        Properties result = new Properties();
        for (String string : strings) {
            String[] pair = string.split("=");
            String key = pair[0];
            int value = Integer.parseInt(pair[1]);

            String[] items = key.split("\\.");
            populateContainer(value, items, 0, result);
        }
        return result;
    }

    private void populateContainer(int value, String[] items, int position, Properties container) {
        if (items.length == position) {
            container.value = value;
            return;
        }

        Properties newContainer = container.inner.get(items[position]);
        if (newContainer == null) {
            newContainer = new Properties();
            container.inner.put(items[position], newContainer);
        }
        populateContainer(value, items, position + 1, newContainer);
    }
}
