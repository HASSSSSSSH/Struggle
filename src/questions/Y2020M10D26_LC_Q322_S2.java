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
 * <p>
 * Optimization of {@link Y2020M10D23_LC_Q322_S1}
 */
public class Y2020M10D26_LC_Q322_S2 {

    public static void main(String args[]) {
        Y2020M10D26_LC_Q322_S2 instance = new Y2020M10D26_LC_Q322_S2();
        // (new int[]{}, 0)
        // (new int[]{1, 2}, 0)
        // (new int[]{1, 2, 5}, 11)
        // (new int[]{1, 7, 77}, 999)
        System.out.println(instance.coinChange(new int[]{1, 7, 77}, 999));
    }

    /**
     * 优化空间
     * 事实上, 在 dp[i][value] 的计算过程中
     * 只参考上一行 dp[i - 1][value'], value' ∈ [0, value] 的结果
     * 因此可以使用滚动数组, 只记录两行结果
     */
    public int coinChange(int[] coins, int amount) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 0;
            }
            return -1;
        }
        int[][] dp = new int[2][amount + 1];

        Arrays.fill(dp[0], -1);

        for (int i = 0; i * coins[0] <= amount; i++) {
            dp[0][i * coins[0]] = i;
        }
        for (int i = 1; i < length; i++) {
            for (int value = 0; value <= amount; value++) {
                int k = 0;
                int min = -1;
                while (k * coins[i] <= value) {
                    int count = k;
                    if (dp[(i - 1) & 1][value - k * coins[i]] >= 0) {
                        count += dp[(i - 1) & 1][value - k * coins[i]];

                        if (min < 0) {
                            min = count;
                        } else if (count < min) {
                            min = count;
                        }
                    }
                    k++;
                }
                dp[i & 1][value] = min;
            }
        }
        return dp[(length - 1) & 1][amount];
    }
}
