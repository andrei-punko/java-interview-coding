package by.andd3dfx.common;

/**
 * <pre>
 * <a href="https://codeforces.com/problemset/problem/1709/A">Task description</a>
 *
 * Перед вами три двери, пронумерованные от 1 до 3 слева направо. На каждой двери висит замок,
 * который может быть открытым только ключом, на котором написано то же число, что и на двери.
 *
 * Есть три ключа — по одному от каждой двери. Два из них спрятаны за дверьми так, что за каждой дверью не более
 * одного ключа. То есть за двумя дверьми лежит по одному ключу, за одной дверью ключа нет. Чтобы получить ключ,
 * спрятанный за дверью, надо сначала открыть эту дверь. Оставшийся ключ у вас в руках.
 *
 * Можете ли вы открыть все двери?
 * </pre>
 *
 * @see <a href="https://youtu.be/ix81AbCNiBE">Video solution</a>
 */
public class DoorsNKeys {

    public static boolean couldOpenAllDoors(int[] keysBehindDoors, int keyInHandNumber) {
        int doorsOpened = 0;

        var curr = keyInHandNumber;
        while (curr != 0) {
            curr = keysBehindDoors[curr - 1];
            doorsOpened++;
        }

        return keysBehindDoors.length == doorsOpened;
    }
}
