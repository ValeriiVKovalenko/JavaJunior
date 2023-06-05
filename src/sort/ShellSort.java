package sort;

import java.util.Arrays;

public class ShellSort {

    public void shellSort(int[] arr) {
        int gap = 1;

        while (gap < arr.length / 3) {
            gap = 3 * gap + 1;

        }

        while(gap >= 1) {

            for (int i = gap; i < arr.length; i++) {

                for (int j = i; j >= gap && arr[j] < arr[j - gap]; j -= gap) {
                    swap(arr, j, j - gap);
                }
            }
            gap /= 3;
        }

    }

    private void swap(int[] arr, int a, int b) {
        if(a == b) {
            return;
        }
            int temp = arr[a];
            arr[a] = arr[b];
            arr[b] = temp;
    }

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();

        int[] arr = {2, 5, 1, 22, 33, -2, 55, 31, 44, 21, 8, 0, -44, 223, 11};
        shellSort.shellSort(arr);
    }
}
