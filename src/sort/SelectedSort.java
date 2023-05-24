package sort;

import java.util.Arrays;

public class SelectedSort {
    public static void main(String[] args) {
        SelectedSort selectedSort = new SelectedSort();
        int[] arr = {2, 66, 33, -1, 22, 0};
        System.out.println(Arrays.toString(selectedSort.selectedSort(arr)));

    }

    public int[] selectedSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            int largestIndex = 0;
            for (int j = 0; j <= i; j++) {
                if(arr[j] > arr[largestIndex]) {
                    largestIndex = j;
                }
            }
            swap(arr, i, largestIndex);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        if(arr[i] == arr[j]) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
