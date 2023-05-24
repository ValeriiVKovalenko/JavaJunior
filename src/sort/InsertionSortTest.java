package sort;

import java.util.Arrays;

public class InsertionSortTest {
    public void insertionSort(int[] arr) {
        for (int partIndex = 1; partIndex < arr.length; partIndex++) {
            int curUnsorted = arr[partIndex];
            int i = 0;
            for (i = partIndex; i > 0 && arr[i - 1] > curUnsorted; i--) {
                arr[i] = arr[i - 1];
            }
            arr[i] = curUnsorted;
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        InsertionSortTest insertionSortTest = new InsertionSortTest();
        int[] arr = {4, -2, 33, 11, 5, 21};

        insertionSortTest.insertionSort(arr);
    }
}
