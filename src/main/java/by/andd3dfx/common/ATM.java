package by.andd3dfx.common;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 * Есть банкомат (ATM), который заряжают купюрами.
 * Надо реализовать метод withdraw() для выдачи заданной суммы amount имеющимися в банкомате купюрами.
 * Метод withdraw() - мутирующий, т.е. меняет состояние банкомата после вызова (кол-во купюр может уменьшиться).
 * </pre>
 */
public class ATM {

    private Map<Integer, Integer> state;
    private List<Integer> nominals;

    public ATM(Map<Integer, Integer> state) {
        this.state = new HashMap<>(state);
        this.nominals = state.keySet().stream()
                .sorted(Comparator.reverseOrder()).toList();
    }

    public Map<Integer, Integer> withdraw(int amount) {
        var result = new HashMap<Integer, Integer>();

        for (var nominal : nominals) {
            if (nominal > amount || state.get(nominal) == 0) {
                continue;
            }

            int count = amount / nominal;
            count = Math.min(count, state.get(nominal));
            result.put(nominal, count);

            amount -= nominal * count;

            if (amount == 0) {
                break;
            }
        }

        if (amount > 0) {
            throw new IllegalStateException("Could not perform withdraw!");
        }

        for (var nominal : result.keySet()) {
            state.put(nominal, state.get(nominal) - result.get(nominal));
        }

        return result;
    }
}
