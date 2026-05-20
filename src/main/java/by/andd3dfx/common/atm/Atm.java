package by.andd3dfx.common.atm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Есть банкомат (ATM), который заряжают купюрами.
 *
 * Надо реализовать метод <code>Map&lt;Integer, Integer&gt; withdraw(int amount)</code> для выдачи заданной суммы
 * <code>amount</code> имеющимися в банкомате купюрами.
 * Метод <code>withdraw</code> - мутирующий, т.е. меняет состояние банкомата после вызова (кол-во купюр может уменьшиться).
 * </pre>
 *
 * @see <a href="https://youtu.be/LDKZtDevRRI">Video solution 1</a>
 * and <a href="https://youtu.be/0-BL-NO9-B8">Video solution 2</a>
 * and <a href="https://youtu.be/1JrcFU_Wig8">Video solution 3</a>
 */
public class Atm {

    private final Map<Integer, Integer> state;
    private final List<Integer> nominals;

    public Atm(Map<Integer, Integer> state) {
        this.state = new HashMap<>(state);
        // Порядок важен для backtracking: сначала пробуем крупные номиналы.
        this.nominals = state.keySet().stream()
            .sorted(Comparator.reverseOrder()).toList();
    }

    /**
     * Withdraw asked amount using banknotes of ATM
     *
     * @param amount sum asked to withdraw
     * @return map with solution - pairs {banknote nominal->quantity}
     */
    public Map<Integer, Integer> withdraw(int amount) {
        if (amount == 0) {
            return Map.of();
        }

        // Перебор всех комбинаций (не жадный): для каждого номинала пробуем 0..max купюр.
        var result = new HashMap<Integer, Integer>();
        if (findSolution(amount, 0, result)) {
            mutateAtm(result);
            return result;
        }

        throw new IllegalStateException("Could not perform withdraw!");
    }

    /**
     * Рекурсивный поиск комбинации купюр для {@code amount}, начиная с номинала {@code index}.
     * Найденное решение накапливается в {@code result}.
     */
    private boolean findSolution(int amount, int index, Map<Integer, Integer> result) {
        if (amount == 0) {
            return true;
        }
        if (index >= nominals.size()) {
            return false; // купюры закончились, сумма не набрана
        }

        var nominal = nominals.get(index);
        // Сколько купюр этого номинала можно взять: min(есть в банкомате, amount / nominal).
        int maxCount = Math.min(state.get(nominal), amount / nominal);
        // От max к 0: сначала варианты с большим числом крупных купюр (см. тесты).
        for (int count = maxCount; count >= 0; count--) {
            if (count > 0) {
                result.put(nominal, count);
            }
            if (findSolution(amount - nominal * count, index + 1, result)) {
                return true;
            }
            if (count > 0) {
                result.remove(nominal); // backtrack
            }
        }
        return false;
    }

    private void mutateAtm(Map<Integer, Integer> result) {
        for (var nominal : result.keySet()) {
            state.put(nominal, state.get(nominal) - result.get(nominal));
        }
    }
}
