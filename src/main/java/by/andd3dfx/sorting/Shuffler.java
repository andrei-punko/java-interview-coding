package by.andd3dfx.sorting;

import java.util.Random;

/**
 * Question was: "How to shuffle array?"
 */
public class Shuffler {

    private Random random = new Random();

    public int[] shuffle(int[] list) {
        for (int i = 0; i < list.length / 2; i++) {
            int index1 = random.nextInt(list.length);
            int index2 = random.nextInt(list.length);
            swap(list, index1, index2);
        }
        return list;
    }

    private void swap(int[] list, int index1, int index2) {
        int temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }
}
