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
 * Solution: Search & Backtracking & Recursive
 * <p>
 * Reference: https://leetcode-cn.com/problems/coin-change/solution/322-ling-qian-dui-huan-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(S ^ n)
 * 在最坏的情况下, 复杂性是硬币数量的指数
 * 是因为每个硬币面值 Ci 最多可以有 S/Ci 个
 * 因此, 可能的组合数为 S/C1 * S/C2 * S/C3 ... * S/Cn = S ^ n / C1 * C2 * C3 ... * Cn
 * <p>
 * 空间复杂度: O(n)
 * 在最坏的情况下, 递归的最大深度是 n
 * 因此, 我们需要系统递归堆栈使用 O(n) 的空间
 * <p>
 * TAG:
 * 候选数组不存在重复元素
 * 候选数组元素可以重复选取
 * 候选数组元素都是正整数
 * 组合可以存在重复元素
 * <p>
 * Result: Time Limit Exceeded
 */
public class Y2020M10D26_LC_Q322_S3 {

    public static void main(String args[]) {
        Y2020M10D26_LC_Q322_S3 instance = new Y2020M10D26_LC_Q322_S3();
        // (new int[]{}, 0)
        // (new int[]{1, 2}, 0)
        // (new int[]{1, 2, 5}, 11)
        // (new int[]{1, 7, 77}, 999)
        System.out.println(instance.coinChange(new int[]{1, 7, 77}, 999));
    }

    public int coinChange(int[] coins, int amount) {
        return coinChange(amount, 0, coins);
    }

    /**
     * 在硬币区间[idxCoin, length - 1] 中选取硬币, 凑成金额 remaining
     * 返回所需的最少的硬币个数
     */
    private int coinChange(int remaining, int idxCoin, int[] coins) {
        if (remaining < 0) {
            return -1;
        }
        if (remaining == 0) {
            return 0;
        }

        if (idxCoin < coins.length) {
            int maxVal = remaining / coins[idxCoin];

            // 记下硬币数组在区间 [idxCoin, length - 1] 凑成金额 remaining 所需的最少的硬币个数
            int min = Integer.MAX_VALUE;

            for (int x = 0; x <= maxVal; x++) {
                // 选取 x 枚硬币 coins[idxCoin]

                if (remaining >= x * coins[idxCoin]) {
                    // 接下来在区间 [idxCoin + 1, length - 1] 中选取硬币, 凑成金额 remaining - x * coins[idxCoin]
                    // 得到其所需的最少的硬币个数
                    int res = coinChange(remaining - x * coins[idxCoin], idxCoin + 1, coins);

                    if (res != -1) {
                        // -1 意味着无法凑成金额 remaining - x * coins[idxCoin]
                        min = Math.min(min, res + x);
                    }
                }
            }

            // 如果硬币数组在区间 [idxCoin, length - 1] 不能凑成金额 remaining
            // 返回 -1
            return (min == Integer.MAX_VALUE) ? -1 : min;
        }
        return -1;
    }
}
