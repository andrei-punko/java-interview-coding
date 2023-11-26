package by.andd3dfx.numeric.factorial;

public class FactorialUsingRecursionTest extends AbstractFactorialTest {

    @Override
    protected IFactorial buildInstance() {
        return new FactorialUsingRecursion();
    }
}
