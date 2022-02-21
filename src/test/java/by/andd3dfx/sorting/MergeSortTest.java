package by.andd3dfx.sorting;

public class MergeSortTest extends AbstractModernSortTest {

    @Override
    protected AbstractModernSort createSorterClass() {
        return new MergeSort();
    }
}
