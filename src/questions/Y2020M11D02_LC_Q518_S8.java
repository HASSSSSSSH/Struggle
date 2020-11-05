package questions;

/**
 * https://leetcode-cn.com/problems/coin-change-2/
 * 零钱兑换 II
 * 给定不同面额的硬币和一个总金额
 * 写出函数来计算可以凑成总金额的硬币组合数, 假设每一种面额的硬币有无限个
 * <p>
 * 事例:
 * 输入: amount = 5, coins = [1, 2, 5]
 * 输出: 4
 * 解释:
 * 有四种方式可以凑成总金额
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * <p>
 * Solution: Dynamic Programming
 * Reference: https://leetcode-cn.com/problems/coin-change-2/solution/dong-tai-gui-hua-wan-quan-bei-bao-wen-ti-by-liweiw/
 * <p>
 * 时间复杂度: O(N * M)
 * 这里金额为 M, 硬币数为 N
 * 与 {@link Y2020M09D27_LC_Q518_S2} 相比缩减了最内层的循环, 时间复杂度降低了一级
 * <p>
 * 空间复杂度: O(M), 数组有 M 列
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 组合可以存在重复元素
 * 解集不包含重复组合
 * 顺序不同的序列被视作相同的组合
 * 只需要输出组合数, 不需要输出具体解集
 * 候选数组元素都是正整数
 * 目标数target不一定是正整数
 * <p>
 * Result: Wrong answer
 */
public class Y2020M11D02_LC_Q518_S8 {

    public static void main(String args[]) {
        Y2020M11D02_LC_Q518_S8 instance = new Y2020M11D02_LC_Q518_S8();
        // (0, new int[]{})
        // (0, new int[]{1, 2})
        // (5, new int[]{1, 2, 5})
        System.out.println(instance.change(5, new int[]{1, 2, 5}));
    }

    /**
     * 这种解法相较于 {@link Y2020M10D23_LC_Q518_S7}
     * 事实上是两个 for循环 中语句的对调, 但是这种解法不能得出正确结果(存在重复组合的计算)
     * <p>
     * 在计算组合的最大值(最小值)时 {@link questions.knapsack.UnboundedKnapsackProblemS4} {@link Y2020M10D26_LC_Q322_S4}
     * 这种解法得出的结果是正确的
     * 因为结果要求的是组合的最大值(最小值), 只要计算过程正确遍历所有组合, 即使有对重复组合进行计算, 也能得出正确的最大值(最小值)
     * <p>
     * 但是在计算组合总数时, 由于存在重复组合的计算, 所以无法得出正确结果
     */
    public int change(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int value = 1; value <= amount; value++) {
            int count = 0;
            for (int coin : coins) {
                if (value >= coin) {
                    // wrong
                    // 存在重复组合
                    count += dp[value - coin];
                }
            }
            dp[value] = count;
        }
        return dp[amount];
    }
}
