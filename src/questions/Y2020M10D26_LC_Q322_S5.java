package questions;

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
 * Solution: Dynamic Programming (down-top)
 * <p>
 * Reference: https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(S * n), 其中 S 是金额, n 是面额数
 * 我们一共需要计算 S 个状态的答案
 * 对于每个状态, 每次需要枚举 n 个面额来转移状态, 所以一共需要 O(S * n) 的时间复杂度
 * <p>
 * 空间复杂度: O(S), 我们需要额外开一个长为 S 的数组来存储计算出来的答案 F(S)
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 候选数组元素都是正整数
 * 组合可以存在重复元素
 */
public class Y2020M10D26_LC_Q322_S5 {

    public static void main(String args[]) {
        Y2020M10D26_LC_Q322_S5 instance = new Y2020M10D26_LC_Q322_S5();
        // (new int[]{}, 0)
        // (new int[]{1, 2}, 0)
        // (new int[]{1, 2, 5}, 11)
        // (new int[]{1, 7, 77}, 999)
        System.out.println(instance.coinChange(new int[]{1, 7, 77}, 999));
    }

    /**
     * 动态规划-自下而上
     * <p>
     * 1.定义状态
     * dp[i] 表示凑齐金额 i 所需的最少的硬币个数
     * <p>
     * 2.状态转移方程
     * dp[value] = min(1 + dp[value - coins[i]), for value in [1, amount]
     * for i in [0, len - 1], if coins[i] <= amount
     * <p>
     * 3.输出
     * dp[amount] 就是凑齐金额 amount 所需的最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        // 自下而上的计算方式, 想要计算 dp[amount], 首先计算 dp[i], 1 <= i < amount
        for (int value = 1; value <= amount; value++) {

            // 记下在硬币区间[0, length - 1] 中选取硬币, 凑成金额 value 所需的最少的硬币个数
            int min = Integer.MAX_VALUE;

            for (int coin : coins) {

                // dp[value - coin] >= 0 表明在硬币区间 [0, length - 1] 中选取硬币, 能够凑成金额 value - coin
                // 其中 dp[0] = 0, 表明 1 枚硬币 coins[i] 恰好能够凑成金额 value
                if (value - coin >= 0 && dp[value - coin] >= 0 && min > dp[value - coin]) {
                    min = dp[value - coin] + 1;
                }
            }
            dp[value] = min < Integer.MAX_VALUE ? min : -1;
        }
        return dp[amount];
    }
}
