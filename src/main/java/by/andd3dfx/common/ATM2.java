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
public class ATM2 {

    private Map<Integer, Integer> state;
    private List<Integer> nominals;

    public ATM2(Map<Integer, Integer> state) {
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
        if (nominalIndex >= nominals.size()) {
            throw new IllegalStateException("Could not perform withdraw!");
        }

        var nominal = nominals.get(nominalIndex);
        if (nominal > amount || state.get(nominal) == 0) {
            return withdraw(amount, nominalIndex + 1);
        }

        var result = new HashMap<Integer, Integer>();
        int count = amount / nominal;
        count = Math.min(count, state.get(nominal));
        result.put(nominal, count);
        amount -= nominal * count;

        if (amount == 0) {
            mutateAtm(result);
            return result;
        }

        result.putAll(withdraw(amount, nominalIndex + 1));
        return result;
    }

    private void mutateAtm(Map<Integer, Integer> result) {
        for (var nominal : result.keySet()) {
            state.put(nominal, state.get(nominal) - result.get(nominal));
        }
    }
}
