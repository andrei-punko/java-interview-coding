package by.andd3dfx.numeric.factorial;

public class FactorialUsingLoopTest extends AbstractFactorialTest {

    @Override
    protected IFactorial buildInstance() {
        return new UsingLoop();
    }
}
