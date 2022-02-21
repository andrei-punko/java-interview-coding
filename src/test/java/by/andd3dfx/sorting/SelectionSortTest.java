package by.andd3dfx.sorting;

public class SelectionSortTest extends AbstractModernSortTest {

    @Override
    protected AbstractModernSort createSorterClass() {
        return new SelectionSort();
    }
}
