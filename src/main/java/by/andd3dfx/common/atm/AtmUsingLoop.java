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
public class AtmUsingLoop extends AbstractAtm {

    public AtmUsingLoop(Map<Integer, Integer> state) {
        super(state);
    }

    @Override
    protected Map<Integer, Integer> withdraw(int amount, int nominalIndex) {
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
}
