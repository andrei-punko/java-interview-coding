package by.andd3dfx.numeric.factorial;

public class FactorialUsingRecursionWithCacheTest extends AbstractFactorialTest {

    @Override
    protected IFactorial buildInstance() {
        return new FactorialUsingRecursionWithCache();
    }
}
