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
 * 分析:
 * 1.为什么是 完全背包 问题
 * 每个硬币可以使用无限次
 * 硬币总额有限制
 * 具体组合是顺序无关的, 比如: 面值总额为 11, 方案 [1, 5, 5] 和方案 [5, 1, 5] 视为同一种方案
 * <p>
 * 2.与「完全」背包问题的区别
 * 要求 恰好 填满容积为 amount 的背包, 重点在于 恰好, 而最原始的 完全背包问题 只是要求 不超过 背包容量
 * 题目要求得到所需的最少的硬币个数, 而原始的 完全背包 问题让我们求的是总价值最多
 * <p>
 * 这一点可以认为是: 每一个硬币有一个 占用空间 属性, 并且 "价值" 是固定的, 固定值为 1
 * 作为 占用空间 而言, 考虑的最小化是有意义的, 等价于把 完全背包 问题的「体积」和「价值」属性调换了一下
 * 因此, 这个问题的背景是 完全背包 问题, 可以使用 完全背包问题 解题思路
 * <p>
 * Optimization of {@link Y2020M10D30_LC_Q322_S6}
 */
public class Y2020M10D30_LC_Q322_S7 {

    public static void main(String args[]) {
        Y2020M10D30_LC_Q322_S7 instance = new Y2020M10D30_LC_Q322_S7();
        // (new int[]{}, 0)
        // (new int[]{1, 2}, 0)
        // (new int[]{1, 2, 5}, 11)
        // (new int[]{1, 7, 77}, 999)
        System.out.println(instance.coinChange(new int[]{2}, 4));
    }

    /**
     * 将数组的初始值设置为一个无效的值 amount + 1, 标记数组该位置尚未被初始化
     * 可以在循环中减少一次 if语句 的判断
     * 因为对于数值为整数的硬币, 凑成总金额 amount, 最多需要 amount 枚硬币
     */
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 0) {
            if (amount == 0) {
                return 0;
            }
            return -1;
        }

        int[] dp = new int[amount + 1];

        // 没必要将数值的初始值设为 Integer.MAX_VALUE
        // 只要在范围 [amount + 1, Integer.MAX_VALUE - 1] 中选取一个数值
        // 标记数组该位置尚未被初始化
        Arrays.fill(dp, amount + 1);

        // 对于候选硬币数组在区间 [0, i] 凑成目标金额 0 的情况, dp[i][0] 总是等于 0
        // 使得状态转移方程正确
        dp[0] = 0;

        for (int coin : coins) {
            for (int value = coin; value <= amount; value++) {
                // 此时没必要再有 if语句 判断数值有否有效
                // 当 dp[value - coin] 无效时, 必定有 dp[value - coin] + 1 > dp[value]
                dp[value] = Math.min(dp[value], dp[value - coin] + 1);
            }
        }
        if (dp[amount] == amount + 1) {
            // dp[amount] 仍是无效值, 说明硬币数组在区间 [0, i] 无法凑成总金额 amount
            dp[amount] = -1;
        }
        return dp[amount];
    }
}
