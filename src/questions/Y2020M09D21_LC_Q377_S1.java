package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * 组合总和 Ⅳ
 * 给定一个由正整数组成且不存在重复数字的数组, 找出和为给定目标正整数的组合的个数
 * <p>
 * 示例:
 * nums = [1, 2, 3]
 * target = 4
 * <p>
 * 所有可能的组合为:
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * <p>
 * 请注意, 顺序不同的序列被视作不同的组合
 * 因此输出为 7
 * <p>
 * 进阶:
 * 如果给定的数组中含有负数会怎么样?
 * 问题会产生什么变化?
 * 我们需要在题目中添加什么限制来允许负数的出现?
 * <p>
 * Solution: Depth First Search & Backtrace
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Result: Timeout
 */
public class Y2020M09D21_LC_Q377_S1 {

    public static void main(String args[]) {
        Y2020M09D21_LC_Q377_S1 instance = new Y2020M09D21_LC_Q377_S1();
        // (new int[]{1, 2, 3}, 4)
        // (new int[]{1, 2, 3}, 6)
        // (new int[]{2, 1, 3}, 35)
        System.out.println(instance.combinationSum4(new int[]{1, 2, 3}, 4));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        int[] answer = new int[]{0};
        dfs(answer, 0, nums, target);
        return answer[0];
    }

    public void dfs(int[] ans, int sum, int[] nums, int target) {
        if (sum == target) {
            ans[0]++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum + nums[i] > target) {
                break;
            }
            dfs(ans, sum + nums[i], nums, target);
        }
    }

    // Incorrect
    //
    // public int combinationSum4(int[] nums, int target) {
    //     Arrays.sort(nums);
    //     int[] answer = new int[]{0};
    //     dfs(answer, 0, 0, -1, 0, 0, nums, target);
    //     return answer[0];
    // }
    //
    // public void dfs(int[] ans, int sum, int length, int preIndex, int dif, int begin, int[] nums, int target) {
    //     if (sum == target) {
    //         int increment = 1;
    //         for (int i = 0; i < dif; i++) {
    //             increment *= length - i;
    //         }
    //         ans[0] += increment;
    //         return;
    //     }
    //     for (int i = begin; i < nums.length; i++) {
    //         if (sum + nums[i] > target) {
    //             break;
    //         }
    //         if (preIndex >= 0 && nums[i] != nums[preIndex]) {
    //             dfs(ans, sum + nums[i], length + 1,
    //                     i, dif + 1, i, nums, target);
    //         } else {
    //             dfs(ans, sum + nums[i], length + 1,
    //                     i, dif, i, nums, target);
    //         }
    //     }
    // }
}
