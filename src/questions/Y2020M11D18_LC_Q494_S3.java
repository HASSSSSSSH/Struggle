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
 */
public class Y2020M11D18_LC_Q494_S3 {

    public static void main(String args[]) {
        Y2020M11D18_LC_Q494_S3 instance = new Y2020M11D18_LC_Q494_S3();

        // new int[]{1, 1, 1, 1, 1}, 3
        // new int[]{1, 1, 2, 1, 1}, 3
        // new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 1

        System.out.println(instance.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

    /**
     * 分析:
     * 1.为什么此问题类似于 0-1背包问题
     * 数组中的每个元素只能使用一次
     * 在 0-1背包问题 当中, 每个元素是在选与不选之间取舍, 而且要求 元素值的总和 <= 目标值
     * 在 这个问题 当中, 每个元素都是必选的, 在符号 + 与 - 之间取舍, 而且要求 元素值的总和 = 目标值
     * <p>
     * 动态规划
     * <p>
     * 1.定义状态
     * 根据 背包问题 的处理经验, 不难得出状态的定义
     * dp[i][j]: 在候选数组的前缀子区间 [0, i] 满足 数组元素之和 等于 目标值 j 的所有添加符号的方法数
     * <p>
     * 2.状态转移方程
     * 遍历数组, 对遍历到的数字添加符号 + 或者 -
     * <p>
     * 如果对遍历到的数字添加符号 +, 那么此时 满足 数组元素之和 等于 目标值 j 的所有添加符号的方法数 = dp[i - 1][j - nums[i]]
     * <p>
     * 如果对遍历到的数字添加符号 -, 那么此时 满足 数组元素之和 等于 目标值 j 的所有添加符号的方法数 = dp[i - 1][j + nums[i]]
     * <p>
     * 那么, dp[i][j] = 对遍历到的数字添加符号 + 和 - 时, 所有满足 数组元素之和 等于 目标值 j 的所有添加符号的方法数 的和
     * <p>
     * 综上所述, 可以得出状态转移方程:
     * dp[i][j] = dp[i - 1][j - nums[i]] + dp[i - 1][j + nums[i]]
     * <p>
     * 3.思考目标值的范围
     * 在经典背包问题中, 目标值的区间为 [0, S]
     * <p>
     * 然而本题中, 设 j 为目标值, 由于负数的存在, j - 负数 > S
     * 同时, 当 nums[i] > j 时, 有 j - nums[i] < 0
     * 此时, dp[i - 1[j - nums[i]] 和 dp[i - 1[j - (-nums[i])] 都会导致数组越界
     * <p>
     * 首先思考目标值 j 的最大值, 由于给定的是一个非负整数数组, 所以 j <= (a1 + a2 + ... + an) 必定成立
     * 当数组中每个数字都添加符号 - 时, 可以得出 j 的最大值, 所以 j >= -(a1 + a2 + ... + an)
     * <p>
     * 综上所述, 可以目标值 j 的范围:
     * -sum <= j <= sum, sum 为数组元素都添加符号 + 时的总和
     * <p>
     * 然而, 在数组 dp[i][j] 中, j 必须大于等于 0
     * 因此在数组中, 应当使用 dp[i][j + sum] 表示 候选数组的前缀子区间 [0, i] 满足 数组元素之和 等于 目标值 j 的所有添加符号的方法数
     * 其中 0 <= j + sum <= 2 * sum 总是成立
     * <p>
     * 当 j - nums[i] + sum < 0 或者 j - (-nums[i]) + sum > 2 * sum 时, 即当 j - nums[i] < -sum 或者 j - (-nums[i]) > sum 时
     * (注意到: j - nums[i] + sum <= 2 * sum 以及 j - (-nums[i]) + sum >= 0 总是成立)
     * dp[i - 1[j - nums[i]] 和 dp[i - 1[j - (-nums[i])] 都应当等于 0
     * 此时, 在候选数组的前缀子区间 [0, i - 1] 不可能使得 数组元素之和 等于 该目标值
     * <p>
     * 4.思考初始化
     * 当目标值 j = 0 时, a1 + (-a2) 可能会满足 数组元素之和 等于 j, a1 + a2 + (-a3) 也可能会满足 数组元素之和 等于 j
     * 因此 j = 0 的情况无法直接得出结果, 只能通过计算得出结果
     * <p>
     * 然而, 在只需要考虑第一个元素 nums[0] 时, 可以直接初始化第一行的数值:
     * dp[0][nums[0] + sum] = 1 且 dp[0][-nums[0] + sum] = 1
     * <p>
     * 特别地, 如果第一个元素 nums[0] = 0 时, 由于 +0 和 -0 被视为 两种不同的添加符号的方法, 使得 数值元素之和 = 目标值j = 0
     * 所以, dp[0][0 + sum] = dp[0][sum] = 2
     * <p>
     * 4.思考输出
     * 输出的结果应该是: 在候选数组的区间 [0, length - 1] 满足 数组元素之和 等于 目标值 S 的所有添加符号的方法数
     * 因此输出应当为: dp[length - 1][S + sum]
     */
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

        int[][] dp = new int[length][2 * sum + 1];

        // 初始化数组的第一行, 此时只需要考虑候选数组 nums 的第一个元素
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum + nums[0]] = 1;
            dp[0][-nums[0] + sum] = 1;
        }

        for (int i = 1; i < length; i++) {
            // j 从 -sum 开始 或者从 sum 开始都可以
            // 因为此时 上一行的值 已经准备就绪
            for (int j = -sum; j <= sum; j++) {
                if (j - nums[i] + sum >= 0) {
                    dp[i][j + sum] += dp[i - 1][j - nums[i] + sum];
                }
                if (j + nums[i] - sum <= 0) {
                    dp[i][j + sum] += dp[i - 1][j - (-nums[i]) + sum];
                }

                // 事实上, 如果此时 i = length - 1, j = S, 已经可以直接输出结果
                if (i == length - 1 && j == S) {
                    break;
                }
            }

            // efficient
            // for (int j = 0; j <= 2 * sum; j++) {
            //     if (j - nums[i] >= 0) {
            //         dp[i][j] += dp[i - 1][j - nums[i]];
            //     }
            //     if (j + nums[i] - 2 * sum <= 0) {
            //         dp[i][j] += dp[i - 1][j - (-nums[i])];
            //     }
            // }
        }
        return dp[length - 1][S + sum];
    }
}
