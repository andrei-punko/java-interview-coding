package by.andd3dfx.common.atm;

import java.util.Map;

public class AtmUsingLoopTest extends AbstractAtmTest {

    @Override
    protected IAtm buildAtm(Map<Integer, Integer> state) {
        return new AtmUsingLoop(state);
    }
}
