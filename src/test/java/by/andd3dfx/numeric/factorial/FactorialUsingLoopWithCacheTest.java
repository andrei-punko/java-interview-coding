package by.andd3dfx.numeric.factorial;

public class FactorialUsingLoopWithCacheTest extends AbstractFactorialTest {

    @Override
    protected IFactorial buildInstance() {
        return new FactorialUsingLoopWithCache();
    }
}
