package problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-element/
 * 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val, 你需要 原地 移除所有数值等于 val 的元素, 并返回移除后数组的新长度
 * 不要使用额外的数组空间, 你必须仅使用 O(1) 额外空间并 原地 修改输入数组
 * 元素的顺序可以改变, 你不需要考虑数组中超出新长度后面的元素
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * 时间复杂度: O(n), 其中 n 为序列的长度, 我们只需要遍历该序列至多一次
 * <p>
 * 空间复杂度: O(1), 我们只需要常数的空间保存若干变量
 */
public class Num27_Solution3 {

    public static void main(String[] args) {
        Num27_Solution3 instance = new Num27_Solution3();

        // int[] nums = new int[]{1, 2, 2, 2, 3, 3};
        int[] nums = new int[]{1, 2};
        // int[] nums = new int[]{1};

        System.out.println(instance.removeElement(nums, 1));
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 可能改变元素的顺序
     * 类似于 {@link Num27_Solution2} 的解法
     */
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (val == nums[left]) {
                nums[left] = nums[right];
                right--;
            } else {
                left++;
            }
        }

        // left 必定指向新数组最后一个元素的下一个位置
        // 此时 nums[left] 满足: nums[left] == val 又或者 nums[left] 已经越出数组边界
        return left;
    }
}
