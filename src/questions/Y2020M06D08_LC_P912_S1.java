package questions;

import sort.QuickSort;

import java.util.Arrays;

public class Y2020M06D08_LC_P912_S1 {

    public static void main(String args[]) {
        Y2020M06D08_LC_P912_S1 instance = new Y2020M06D08_LC_P912_S1();
        System.out.println(Arrays.toString(instance.sortArray(new int[]{49, 38, 65, 97, 76, 13, 27, 49})));
    }

    public int[] sortArray(int[] nums) {
        return QuickSort.quickSort(nums, 0, nums.length - 1);
    }
}
