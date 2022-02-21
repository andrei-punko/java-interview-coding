package by.andd3dfx.sorting;

public class ShellSortTest extends AbstractModernSortTest {

    @Override
    protected AbstractModernSort createSorterClass() {
        return new ShellSort();
    }
}
