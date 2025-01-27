package by.andd3dfx.common.atm;

import java.util.Map;

public class AtmUsingRecursionTest extends AbstractAtmTest {

    @Override
    protected IAtm buildAtm(Map<Integer, Integer> state) {
        return new AtmUsingRecursion(state);
    }
}
