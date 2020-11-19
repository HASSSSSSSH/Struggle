package questions;

/**
 * https://leetcode-cn.com/problems/target-sum/
 * 目标和
 * 给定一个非负整数数组, a1, a2, ..., an, 和一个目标数 S
 * 现在你有两个符号 + 和 -
 * 对于数组中的任意一个整数, 你都可以从 + 或 - 中选择一个符号添加在前面
 * 返回可以使最终数组和为目标数 S 的所有添加符号的方法数
 * <p>
 * 示例 1:
 * 输入: nums: [1, 1, 1, 1, 1], S: 3
 * 输出: 5
 * 解释:
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 一共有5种方法让最终目标和为3
 * <p>
 * 提示:
 * 数组非空, 且长度不会超过 20
 * 初始的数组的和不会超过 1000
 * 保证返回的最终结果能被 32 位整数存下
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * Reference: https://leetcode-cn.com/problems/target-sum/solution/dong-tai-gui-hua-si-kao-quan-guo-cheng-by-keepal/
 * <p>
 * 时间复杂度: O(n * sum), 其中 n 为数组长度, sum 为数组元素之和
 * <p>
 * 空间复杂度: O(n * sum), 其中 n 为数组长度, sum 为数组元素之和
 * <p>
 * Result: Wrong Answer
 */
public class Y2020M11D18_LC_Q494_S2 {

    public static void main(String args[]) {
        Y2020M11D18_LC_Q494_S2 instance = new Y2020M11D18_LC_Q494_S2();

        // new int[]{1, 1, 1, 1, 1}, 3
        // new int[]{1, 1, 2, 1, 1}, 3
        // new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1

        System.out.println(instance.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int findTargetSumWays(int[] nums, int S) {
        int length = nums.length;
        if (length == 0) {
            if (S == 0) {
                return 1;
            }
            return 0;
        }

        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (Math.abs(S) > sum) {
            // 当 S 的绝对值大于 sum 时, 不可能满足: 数组元素之和 = S
            return 0;
        }

        int[][] positiveDp = new int[length][sum + 1];
        int[][] negativeDp = new int[length][sum + 1];

        // 初始化数组的第一行, 此时只需要考虑候选数组 nums 的第一个元素
        if (nums[0] == 0) {
            positiveDp[0][0] = 2;
        } else {
            positiveDp[0][nums[0]] = 1;
            negativeDp[0][nums[0]] = 1;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                // 计算目标值 j
                int plusSign = j - nums[i];
                int minusSign = j + nums[i];

                if (Math.abs(plusSign) <= sum) {
                    positiveDp[i][j] += plusSign >= 0 ? positiveDp[i - 1][plusSign] : negativeDp[i - 1][-plusSign];
                }
                if (Math.abs(minusSign) <= sum) {
                    positiveDp[i][j] += minusSign >= 0 ? positiveDp[i - 1][minusSign] : negativeDp[i - 1][-minusSign];
                }

                // 计算目标值 -j
                plusSign = -j - nums[i];
                minusSign = -j + nums[i];
                if (Math.abs(plusSign) <= sum) {
                    negativeDp[i][j] += plusSign >= 0 ? positiveDp[i - 1][plusSign] : negativeDp[i - 1][-plusSign];
                }
                if (Math.abs(minusSign) <= sum) {
                    negativeDp[i][j] += minusSign >= 0 ? positiveDp[i - 1][minusSign] : negativeDp[i - 1][-minusSign];
                }
            }
        }
        return S >= 0 ? positiveDp[length - 1][S] : negativeDp[length - 1][-S];
    }
}
