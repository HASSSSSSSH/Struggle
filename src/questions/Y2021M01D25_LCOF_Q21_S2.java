package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 调整数组顺序使奇数位于偶数前面
 * <p>
 * 输入一个整数数组, 实现一个函数来调整该数组中数字的顺序, 使得所有奇数位于数组的前半部分, 所有偶数位于数组的后半部分
 * <p>
 * 实例 1:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: [1, 3, 2, 4]
 * 注: [3, 1, 2, 4] 也是正确的答案之一
 * <p>
 * 提示:
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D25_LCOF_Q21_S2 {

    public static void main(String args[]) {
        Y2021M01D25_LCOF_Q21_S2 instance = new Y2021M01D25_LCOF_Q21_S2();

        // new int[]{1, 2, 3, 4}

        System.out.println(Arrays.toString(instance.exchange(new int[]{1, 2, 3, 4})));
    }

    public int[] exchange(int[] nums) {
        int fast = 0;
        int slow = 0;
        while (fast < nums.length) {
            if ((nums[fast] & 1) == 1) {
                int temp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = temp;
                slow++;
            }
            fast++;
        }
        return nums;
    }
}
