package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();

        int[] arr = {3, 5, 12, -4, 45, 982, 11, 0};
        mergeSort.mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public int[] mergeSort(int[] arr) {
        int[] temp;
        int[] currentSrc = arr;
        int[] currentDest = new int[arr.length];

        int size = 1;

        while (size < arr.length) {

            for (int i = 0; i < arr.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            temp = currentSrc;
            currentSrc = currentDest;
            currentDest = temp;

            size = size * 2;
        }
        return currentSrc;
    }
    private void merge(int[] src1, int src1Start, int[] src2, int src2Start,
                       int[] dest, int destStart, int size) {

        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {

            if(index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }
}
