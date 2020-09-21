package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 删除排序数组中的重复项
 * 给定一个排序数组, 你需要在 原地 删除重复出现的元素
 * 使得每个元素只出现一次, 返回移除后数组的新长度
 * <p>
 * 不要使用额外的数组空间, 你必须在 原地 修改输入数组, 并在使用 O(1) 额外空间的条件下完成
 * <p>
 * Solution: Iterative
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M09D02_LC_Q26_S1 {

    public static void main(String args[]) {
        Y2020M09D02_LC_Q26_S1 instance = new Y2020M09D02_LC_Q26_S1();
        int[] nums = new int[]{1, 2, 2, 2, 3, 4, 5, 5};
        // int[] nums = new int[]{1, 2, 3};
        System.out.println(instance.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length < 1) {
            return 0;
        }
        int cur = 0;
        int next = 1;
        for (; next < nums.length; next++) {
            if (nums[next] != nums[cur]) {
                nums[++cur] = nums[next];
            }
        }
        return cur + 1;
    }
}
