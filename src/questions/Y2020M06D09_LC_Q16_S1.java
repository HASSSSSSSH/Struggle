package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/3sum-closest/
 * 最接近的三数之和
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 * 提示:
 * 3 <= nums.length <= 10^3
 * -10^3 <= nums[i] <= 10^3
 * -10^4 <= target <= 10^4
 * <p>
 * Review:
 * 20200624
 */
public class Y2020M06D09_LC_Q16_S1 {

    public static void main(String args[]) {
        Y2020M06D09_LC_Q16_S1 instance = new Y2020M06D09_LC_Q16_S1();
        // int[] arr = new int[]{-1, 2, 1, -4};
        int[] arr = new int[]{-1, 2, 1};
        System.out.println(instance.threeSumClosest(arr, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        // no need
        // if (nums == null || nums.length < 3) {
        //     return 0;
        // }
        Arrays.sort(nums);

        // NOTE: 不能用0作为初始值
        int result = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int difference = sum - target;
                if (difference == 0) {
                    return sum;
                } else if (difference > 0) {
                    end--;
                } else {
                    start++;
                }
                if (Math.abs(difference) < Math.abs(result - target)) {
                    result = sum;
                }
            }
        }
        return result;
    }
}
