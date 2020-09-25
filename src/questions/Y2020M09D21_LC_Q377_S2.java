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
 * Solution: Dynamic Programming & Depth First Search
 * Reference: https://leetcode-cn.com/problems/combination-sum-iv/solution/377-zu-he-zong-he-iv-javascript-san-chong-jie-ti-s/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Result: Timeout
 */
public class Y2020M09D21_LC_Q377_S2 {

    public static void main(String args[]) {
        Y2020M09D21_LC_Q377_S2 instance = new Y2020M09D21_LC_Q377_S2();
        // (new int[]{1, 2, 3}, 4)
        // (new int[]{1, 2, 3}, 6)
        // (new int[]{2, 1, 3}, 35)
        // (new int[]{3, 33, 333}, 10000)
        System.out.println(instance.combinationSum4(new int[]{3, 33, 333}, 10000));
    }

    public int combinationSum4(int[] nums, int target) {
        Arrays.sort(nums);
        return dfs(new int[target + 1], nums, target);
    }

    /**
     * Can not pass test case: (new int[]{3, 33, 333}, 10000)
     * <p>
     * 动态规划 + 深度优先遍历 的解法, 效率低下
     */
    public int dfs(int[] dp, int[] nums, int target) {
        if (target == 0) {
            return 1;
        }
        if (dp[target] == 0) {
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > target) {
                    break;
                }
                sum += dfs(dp, nums, target - nums[i]);
            }
            dp[target] = sum;
        }
        return dp[target];
    }
}
