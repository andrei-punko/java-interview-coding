package by.andd3dfx.common.atm;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractAtm implements IAtm {

    protected Map<Integer, Integer> state;
    protected List<Integer> nominals;

    public AbstractAtm(Map<Integer, Integer> state) {
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
    @Override
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

    /**
     * Withdraw asked amount using banknotes of ATM starting from definite nominal (and its lower values)
     *
     * @param amount sum asked to withdraw
     * @return map with solution - pairs {banknote nominal->quantity}
     */
    protected abstract Map<Integer, Integer> withdraw(int amount, int nominalIndex);

    protected void mutateAtm(Map<Integer, Integer> result) {
        for (var nominal : result.keySet()) {
            state.put(nominal, state.get(nominal) - result.get(nominal));
        }
    }
}
