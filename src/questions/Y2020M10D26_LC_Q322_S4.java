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
 * Solution: Dynamic Programming (top-down)
 * <p>
 * Reference:
 * https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * https://leetcode-cn.com/problems/coin-change/solution/dong-tai-gui-hua-shi-yong-wan-quan-bei-bao-wen-ti-/
 * <p>
 * 时间复杂度: O(S * n), 其中 S 是金额, n 是面额数
 * 我们一共需要计算 S 个状态的答案, 且每个状态 F(S) 由于上面的记忆化的措施只计算了一次
 * 而计算一个状态的答案需要枚举 n 个面额值, 所以一共需要 O(S * n) 的时间复杂度
 * <p>
 * 空间复杂度: O(S), 我们需要额外开一个长为 S 的数组来存储计算出来的答案 F(S)
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 候选数组元素都是正整数
 * 组合可以存在重复元素
 * <p>
 * Optimization of {@link Y2020M10D26_LC_Q322_S3}
 */
public class Y2020M10D26_LC_Q322_S4 {

    public static void main(String args[]) {
        Y2020M10D26_LC_Q322_S4 instance = new Y2020M10D26_LC_Q322_S4();
        // (new int[]{}, 0)
        // (new int[]{1, 2}, 0)
        // (new int[]{1, 2, 5}, 11)
        // (new int[]{1, 7, 77}, 999)
        System.out.println(instance.coinChange(new int[]{1, 7, 77}, 999));
    }

    public int coinChange(int[] coins, int amount) {
        return coinChange(amount, new int[amount + 1], coins);
    }

    /**
     * 动态规划-自上而下
     * <p>
     * 1.定义状态
     * dp[i] 表示凑齐金额 i 所需的最少的硬币个数
     * <p>
     * 2.状态转移方程
     * dp[amount] = min(1 + dp[amount - coins[i]]), for i in [0, len - 1], if coins[i] <= amount
     * <p>
     * 3.输出
     * dp[amount] 就是凑齐金额 amount 所需的最少的硬币个数
     * <p>
     * 在硬币区间[0, length - 1] 中选取硬币, 凑成金额 remaining
     * 返回所需的最少的硬币个数
     */
    private int coinChange(int remaining, int[] dp, int[] coins) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }

        // 如果 dp[remaining] 有意义 (dp[remaining] != 0)
        // 说明子问题(在硬币区间[0, length - 1] 中选取硬币, 凑成金额 remaining, 所需的最少的硬币个数)已经被计算过
        // 此时只需要直接返回子问题的结果
        if (dp[remaining] != 0) {
            // 只要 dp[remaining] 被赋值了, 就绝不会等于 0
            return dp[remaining];
        }

        // 记下在硬币区间[0, length - 1] 中选取硬币, 凑成金额 remaining 所需的最少的硬币个数
        int min = Integer.MAX_VALUE;

        for (int coin : coins) {
            // 选取一个硬币 coins[i], 接下来获取凑成金额 remaining - coins[i] 所需的最少的硬币个数
            int res = coinChange(remaining - coin, dp, coins);

            // 如果 res = -1, 说明在硬币区间 [0, length - 1] 中选取硬币, 无法凑成金额 remaining - coins[i]
            if (res >= 0 && min > res + 1) {
                // min >= 1 总是成立
                min = res + 1;
            }
        }

        // 先赋值, 再返回结果
        // 由于 min >= 1 总是成立, 所以 dp[remaining] 在赋值后, 总是等于 -1 或者 大于 0
        return min < Integer.MAX_VALUE ? (dp[remaining] = min) : (dp[remaining] = -1);
    }
}
