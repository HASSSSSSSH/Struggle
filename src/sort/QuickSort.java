package sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class QuickSort {

    public static void main(String args[]) {
        int[] array = new int[]{49, 38, 65, 97, 76, 13, 27, 49};
        // int[] array = new int[]{49, 38};
        // int[] array = new int[]{0};

        // System.out.println(Arrays.toString(quickSort(array, 0, array.length - 1)));

        // Arrays.sort(array);
        // System.out.println(Arrays.toString(array));

        ArrayList<Integer> list = new ArrayList<>(array.length);
        for (int a : array) {
            list.add(a);
        }
        System.out.println(Arrays.toString(list.toArray()));
        Collections.sort(list);
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static int[] quickSort(int arr[], int start, int end) {
        int pivot = arr[start];
        int i = start;
        int j = end;
        outer:
        while (true) {
            while (arr[j] >= pivot) {
                j--;
                if (i >= j) {
                    break outer;
                }
            }
            while (arr[i] <= pivot) {
                i++;
                if (i >= j) {
                    break outer;
                }
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[j];
        arr[j] = pivot;
        if (i - 1 > start) {
            arr = quickSort(arr, start, i - 1);
        }
        if (j + 1 < end) {
            arr = quickSort(arr, j + 1, end);
        }
        return arr;
    }
}
