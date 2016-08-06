package com.computinglife.leetcode.utils;

/**
 * Created by yliu on 7/21/16.
 */
public class QuickSort {

    public static void quickSort(int[] arrays) {
        if (arrays != null) {
            quickSort(arrays, 0, arrays.length - 1);
        }
    }

    private static void quickSort(int[] arrays, int start, int end) {
        if (start > end || arrays == null) {
            return;
        }

        int p = partition(arrays, start, end);
        quickSort(arrays, start, p - 1);
        quickSort(arrays, p + 1, end);
    }

    private static int partition(int[] arrays, int start, int end) {
        int begin = arrays[start];
        int i = start, j = end;
        while (i < j) {
            while (arrays[i] <= begin && i < end) {
                i++;
            }
            while (arrays[j] > begin && j > start) {
                j--;
            }
            if (i < j) {
                //swap
                arrays[i] = arrays[i] ^ arrays[j];
                arrays[j] = arrays[i] ^ arrays[j];
                arrays[i] = arrays[i] ^ arrays[j];
            }
        }
        if (j != start) {
            arrays[j] = arrays[j] ^ arrays[start];
            arrays[start] = arrays[j] ^ arrays[start];
            arrays[j] = arrays[j] ^ arrays[start];
        }
        return j;
    }

    public static void main(String[] args) {
        int[] arrays = {8, 6, 2, 4};
        quickSort(arrays);
        for (int tmp : arrays) {
            System.out.println(tmp);
        }

    }

}
