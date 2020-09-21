package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-element/
 * 移除元素
 * 给你一个数组 nums 和一个值 val, 你需要 原地 移除所有数值等于 val 的元素, 并返回移除后数组的新长度
 * <p>
 * 不要使用额外的数组空间, 你必须仅使用 O(1) 额外空间并 原地 修改输入数组
 * 元素的顺序可以改变, 你不需要考虑数组中超出新长度后面的元素
 * <p>
 * Solution: Iterative
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M09D02_LC_Q27_S1 {

    public static void main(String args[]) {
        Y2020M09D02_LC_Q27_S1 instance = new Y2020M09D02_LC_Q27_S1();
        // int[] nums = new int[]{1, 2, 2, 2, 3, 3};
        int[] nums = new int[]{1, 2};
        // int[] nums = new int[]{1};
        System.out.println(instance.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            for (; start < end; start++) {
                if (nums[start] == val) {
                    break;
                }
            }
            if (start >= end) {
                break;
            }
            for (; end > start; end--) {
                if (nums[end] != val) {
                    break;
                }
            }
            if (end > start) {
                nums[start] = nums[end];
                end--;

                // can not pass while nums = [1, 2], val = 1
                // start++;
            }
        }
        return nums[start] == val ? start : start + 1;
    }
}
