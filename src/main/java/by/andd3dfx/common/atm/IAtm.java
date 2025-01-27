package by.andd3dfx.common.atm;

import java.util.Map;

public interface IAtm {

    /**
     * Withdraw asked amount using banknotes of ATM
     *
     * @param amount sum asked to withdraw
     * @return map with solution - pairs {banknote nominal->quantity}
     */
    Map<Integer, Integer> withdraw(int amount);
}
