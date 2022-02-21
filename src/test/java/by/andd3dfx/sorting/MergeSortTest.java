package by.andd3dfx.sorting;

public class MergeSortTest extends AbstractSortTest {

    @Override
    protected AbstractSort createSorterClass() {
        return new MergeSort();
    }
}
