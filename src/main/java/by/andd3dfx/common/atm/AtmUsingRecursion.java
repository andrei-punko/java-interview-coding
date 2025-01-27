package by.andd3dfx.common.atm;

import java.util.HashMap;
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
public class AtmUsingRecursion extends AbstractAtm {

    public AtmUsingRecursion(Map<Integer, Integer> state) {
        super(state);
    }

    @Override
    protected Map<Integer, Integer> withdraw(int amount, int nominalIndex) {
        if (amount == 0) {
            return Map.of();
        }
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

        if (amount > 0) {
            result.putAll(withdraw(amount, nominalIndex + 1));
            return result;
        }

        mutateAtm(result);
        return result;
    }
}
