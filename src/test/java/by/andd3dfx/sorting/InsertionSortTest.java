package by.andd3dfx.sorting;

public class InsertionSortTest extends AbstractModernSortTest {

    @Override
    protected AbstractModernSort createSorterClass() {
        return new InsertionSort();
    }
}
