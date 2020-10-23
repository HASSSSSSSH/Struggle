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
 * 时间复杂度: O(N * M ^ 2)
 * 这里金额为 M, 硬币数为 N
 * 第 1 层循环与硬币总数的规模 N 相同
 * 第 2 层循环与要求的总金额的规模 M 相同
 * 第 3 层循环在 最坏情况 下, 硬币的面值为 1 时, 与要求的总金额的规模 M 相同
 * <p>
 * 空间复杂度: O(M), 表格有 2 行, M 列
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
 * 分析:
 * 1.本题与 LeetCodeQ377{@link Y2020M09D21_LC_Q377_S3} 相似, 区别在于 顺序不同的序列是否被视作不同的组合
 * 本题要求, 一个组合的不同排列在结果集中只出现一次, 这一点是「背包问题」的特征, 拿东西的顺序不重要
 * <p>
 * 2.本题与 LeetCodeQ39{@link Y2020M09D09_LC_Q39_S2} 相似
 * 区别在于 Q39 需要输出具体组合列表, 需要通过 回溯算法 求解
 * 而本题只需要输出组合数, 使用 回溯算法 会导致超时, 应该使用 动态规划 求解
 * <p>
 * 3.本题可以归类为 完全背包问题
 * 「完全背包」问题的特点是: 背包里的物品可以无限次选取
 * 本题特殊的地方在于: 从背包里选取的物品 必须刚好装满 , 而不是小于等于, 注意这点细微的区别
 * <p>
 * 4. 完全背包问题 与 0-1背包问题 的区别
 * 「0-1」背包问题: 当前考虑的物品拿或者不拿
 * 「完全」背包问题: 当前考虑的物品拿或者不拿, 如果拿, 只要背包能装下, 就可以一直拿, 直到背包装不下为止
 * 但求解思路依然是: 一个一个物品考虑, 容量一点一点扩大, 整个过程是一个 尝试 和 比较 的过程
 * <p>
 * Optimization of {@link Y2020M09D27_LC_Q518_S2}
 */
public class Y2020M09D29_LC_Q518_S4 {

    public static void main(String args[]) {
        Y2020M09D29_LC_Q518_S4 instance = new Y2020M09D29_LC_Q518_S4();
        // (0, new int[]{})
        // (0, new int[]{1, 2})
        // (5, new int[]{1, 2, 5})
        System.out.println(instance.change(5, new int[]{1, 2, 5}));
    }

    /**
     * 优化空间
     * 事实上, 在 dp[i][value] 的计算过程中
     * 只参考上一行 dp[i - 1][value'], value' ∈ [0, value] 的结果
     * 因此可以使用滚动数组, 只记录两行结果
     */
    public int change(int amount, int[] coins) {
        int length = coins.length;
        if (length == 0) {
            if (amount == 0) {
                return 1;
            }
            return 0;
        }

        // 事实上, 在 dp[i][value] 的计算过程中
        // 只参考上一行 dp[i - 1][value'], value' ∈ [0, value] 的结果
        // 因此可以使用滚动数组, 只记录两行结果
        int row = 2;
        int[][] dp = new int[row][amount + 1];

        // 使得状态转移方程成立
        // 当 k 枚硬币 coin[i] 满足条件 value - k * coin[i] = 0 时, 应当将其作为一种可能的组合
        dp[0][0] = 1;

        // 初始化数组第一行, 此时只需考虑候选硬币数组的第一个元素 coin[0]
        for (int k = 1; k * coins[0] <= amount; k++) {
            dp[0][k * coins[0]] = 1;
        }

        for (int i = 1; i < length; i++) {
            // value的范围是: [0, amount]
            // 且 dp[i][0] = 1 总是成立, 其中 0 <= i <= n
            for (int value = 0; value <= amount; value++) {
                int sum = 0;
                int k = 0;

                // 依次选取 0, 1, ..., k枚硬币 coin[i]
                while (k * coins[i] <= value) {
                    sum += dp[(i - 1) % 2][value - (k * coins[i])];
                    k++;
                }

                // dp[i % 2][0] 总是等于 1
                dp[i % 2][value] = sum;
            }
        }
        return dp[(length - 1) % 2][amount];
    }
}
