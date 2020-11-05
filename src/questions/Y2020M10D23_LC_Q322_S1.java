package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/
 * 零钱兑换
 * 给定不同面额的硬币 coins 和一个总金额 amount
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数
 * 如果没有任何一种硬币组合能组成总金额, 返回 -1
 * <p>
 * 示例 1:
 * 输入: coins = [1, 2, 5], amount = 11
 * 输出: 3
 * 解释: 11 = 5 + 5 + 1
 * <p>
 * 示例 2:
 * 输入: coins = [2], amount = 3
 * 输出: -1
 * <p>
 * 示例 3:
 * 输入: coins = [1], amount = 0
 * 输出: 0
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 候选数组元素都是正整数
 * 组合可以存在重复元素
 * <p>
 * Result: Not so efficient
 */
public class Y2020M10D23_LC_Q322_S1 {

    public static void main(String args[]) {
        Y2020M10D23_LC_Q322_S1 instance = new Y2020M10D23_LC_Q322_S1();
        // (new int[]{}, 0)
        // (new int[]{1, 2}, 0)
        // (new int[]{1, 2, 5}, 11)
        // (new int[]{1, 7, 77}, 999)
        System.out.println(instance.coinChange(new int[]{1, 7, 77}, 999));
    }

    /**
     * 动态规划
     * <p>
     * Step 1.定义状态
     * dp[i][j]: 候选硬币数组的前缀子区间 [0, i] 能够凑成目标金额为 j 所需的最少的硬币个数
     * 背包问题有一个特点: 顺序无关, 因此可以一个一个硬币去考虑
     * <p>
     * Step 2.状态转移方程
     * 对于遍历到的每一种面值的硬币, 逐个考虑添加到 「总金额」 中
     * 由于硬币的个数可以无限选取, 因此对于一种新的面值的硬币 coins[i]
     * 依次考虑选取 0 枚, 1 枚, 2 枚, ..., k 枚, 直到选取这种面值的硬币的总金额超过目标金额 j 为止
     * 但是, 需要满足: j - k * coins[i] >= 0
     * 当选取了 k 枚硬币 coins[i] 时, 为了满足剩余金额 j - k * coins[i]
     * 需要从候选硬币数组的 [0, i - 1] 区间选取硬币
     * 所以在选取了 k 枚硬币 coins[i] 时, 最少的硬币个数 = dp[i - 1][j - k * coins[i]] + k
     * <p>
     * 可得状态转移方程:
     * dp[i][j] = min(dp[i - 1][j - k * coins[i]] + k), 其中 j - k * coins[i] >= 0, k >= 0
     * <p>
     * 特别地, 对于候选硬币数组在区间 [0, i] 无法凑成目标金额 j 的情况, dp[i][j] 总是等于 -1
     * <p>
     * Step 3.思考初始化
     * dp[0][0] 的值应当设置为 0, 它作为被参考的值, 可以使得后续的状态转移方程正确
     * 原因是: 在选取了 k 枚硬币 coins[i] 时, 如果 k * coins[i] 恰好等于目标金额 j
     * 此时, 最少的硬币个数 = k (在已经选取了 k 枚硬币 coins[i] 的前提下)
     * 那么 dp[i - 1][j - k * coins[i]] = dp[i - 1][0] = 0 总是成立
     * <p>
     * 所以, 对于候选硬币数组在区间 [0, i] 凑成目标金额 0 的情况, dp[i][0] 总是等于 0
     * <p>
     * Step 4.思考输出
     * 输出的结果应该是: 候选硬币数组在区间 [0, length - 1] 能够凑成总金额为 amount 所需的最少的硬币个数
     * 输出就是表格的最后一格的数值, 即 dp[length - 1][amount]
     */
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 0;
            }
            return -1;
        }
        int[][] dp = new int[length][amount + 1];

        // 初始化二维数组第一行, 最开始默认 coins[0] 无法凑成任意一个金额
        // dp[i][j] (i > 0) 的计算过程, 会依赖上一行的结果
        Arrays.fill(dp[0], -1);

        // 对于候选硬币数组在区间 [0, i] 凑成目标金额 0 的情况, dp[i][0] 总是等于 0
        // 使得状态转移方程正确
        dp[0][0] = 0;

        // 初始化二维数组第一行
        for (int i = 1; i * coins[0] <= amount; i++) {
            dp[0][i * coins[0]] = i;
        }

        for (int i = 1; i < length; i++) {
            for (int value = 0; value <= amount; value++) {
                // k 需要从 0 开始
                // 因为候选硬币数组在区间 [0, i] 凑成目标金额 value
                // 有可能在不选取 coin[i] 的情况下, 以最少的硬币个数凑成目标金额 value
                int k = 0;

                // 记下凑成金额 value 所需的最少的硬币个数
                // 如果硬币数组在区间 [0, i] 不能凑成目标金额 value, 那么 dp[i][value] = -1
                int min = -1;

                while (k * coins[i] <= value) {
                    int count = k;
                    if (dp[i - 1][value - k * coins[i]] >= 0) {
                        count += dp[i - 1][value - k * coins[i]];

                        if (min < 0) {
                            // min < 0 表明 min 未被初始化, 此前未能成功凑成目标金额 value
                            min = count;
                        } else if (count < min) {
                            min = count;
                        }
                    }
                    k++;
                }
                dp[i][value] = min;
            }
        }
        return dp[length - 1][amount];
    }
}
