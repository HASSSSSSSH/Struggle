package problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/squares-of-a-sorted-array/
 * 有序数组的平方
 * <p>
 * 给你一个按 非递减顺序 排序的整数数组 nums, 返回 每个数字的平方 组成的新数组, 要求也按 非递减顺序 排序
 * <p>
 * 示例 1:
 * 输入: nums = [-4, -1, 0, 3, 10]
 * 输出: [0, 1, 9, 16, 100]
 * 解释: 平方后, 数组变为 [16, 1, 0, 9, 100]
 * 排序后, 数组变为 [0, 1, 9, 16, 100]
 * <p>
 * 示例 2:
 * 输入: nums = [-7, -3, 2, 3, 11]
 * 输出: [4, 9, 9, 49, 121]
 * <p>
 * 提示:
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 已按 非递减顺序 排序
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}, {@link questions.tags.Sorting}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1), 除了存储答案的数组以外, 我们只需要维护常量空间
 * <p>
 * Reference: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0977.%E6%9C%89%E5%BA%8F%E6%95%B0%E7%BB%84%E7%9A%84%E5%B9%B3%E6%96%B9.md
 */
public class Num977_Solution1 {

    public static void main(String[] args) {
        Num977_Solution1 instance = new Num977_Solution1();

        // int[] nums = new int[]{-4, -1, 0, 3, 10};
        int[] nums = new int[]{-7, -3, 2, 3, 11};

        System.out.println(Arrays.toString(instance.sortedSquares(nums)));
    }

    /**
     * 对于一个按 非递减顺序 排序的整数数组 nums, 数组的区间为 [left, right]
     * 那么当数组平方后, 要么是最左边的元素平方后得到数组的最大值, 要么是最右边的元素平方后得到数组的最大值
     * 因此, 只需要比较 nums[left] 的绝对值和 nums[right] 的绝对值, 将较大者平方后得到的结果赋值给新数组的最后一个元素
     * 如此进行操作, 新数组会按 非递减顺序 排序
     */
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        // 指向新数组的最后一个元素
        int i = nums.length - 1;

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (abs(nums[left]) > abs(nums[right])) {
                ans[i] = nums[left] * nums[left];
                left++;
            } else {
                ans[i] = nums[right] * nums[right];
                right--;
            }
            i--;
        }

        return ans;
    }

    public int abs(int a) {
        return a < 0 ? -a : a;
    }
}
