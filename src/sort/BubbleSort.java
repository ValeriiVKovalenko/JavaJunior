package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {66,22,-4, 33, 55, 13};
        System.out.println(Arrays.toString(bubbleSort(arr)));
    }
    public static int[] bubbleSort(int[] arr) {
        for (int partIndex = arr.length - 1; partIndex > 0; partIndex--) {
            for (int i = 0; i < partIndex; i++) {
                if(arr[i] > arr[i + 1]) {
                    swap(arr, i, i +1);
                }
            }
        }
        return arr;
    }
    private static void swap(int[] arr, int i, int j) {
        if(i == j) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
        }
