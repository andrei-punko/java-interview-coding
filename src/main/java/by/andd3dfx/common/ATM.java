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
 *
 * @see <a href="https://youtu.be/LDKZtDevRRI">Video solution</a>
 */
public class ATM {

    private Map<Integer, Integer> state;
    private List<Integer> nominals;

    public ATM(Map<Integer, Integer> state) {
        this.state = new HashMap<>(state);
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
        // Try to make withdraw using banknote of highest nominal,
        // in case of fail - try to start from next nominal
        for (int i = 0; i < nominals.size(); i++) {
            try {
                return withdraw(amount, i);
            } catch (IllegalStateException ex) {
                // do nothing
            }
        }

        throw new IllegalStateException("Could not perform withdraw!");
    }

    private Map<Integer, Integer> withdraw(int amount, int nominalIndex) {
        var result = new HashMap<Integer, Integer>();

        for (var index = nominalIndex; index < nominals.size(); index++) {
            var nominal = nominals.get(index);
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

        mutateAtm(result);
        return result;
    }

    private void mutateAtm(Map<Integer, Integer> result) {
        for (var nominal : result.keySet()) {
            state.put(nominal, state.get(nominal) - result.get(nominal));
        }
    }
}
