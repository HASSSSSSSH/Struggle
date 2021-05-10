package questions;

/**
 * https://leetcode-cn.com/problems/integer-break/
 * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 整数拆分
 * <p>
 * 给定一个正整数 n, 将其拆分为至少两个正整数的和, 并使这些整数的乘积最大化
 * 返回你可以获得的最大乘积
 * <p>
 * 示例 1:
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * <p>
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 说明:
 * 你可以假设 n 不小于 2 且不大于 58
 * <p>
 * Tags: {@link questions.tags.Math}, {@link questions.tags.DynamicProgramming}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}
 * <p>
 * 时间复杂度: O(n ^ 2), 其中 n 是给定的正整数
 * 对于从 2 到 n 的每一个整数都要计算对应的 dp 值, 计算一个整数对应的 dp 值需要 O(n) 的时间复杂度, 因此总时间复杂度是 O(n ^ 2)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2021M01D17_LC_Q343_S1 {

    public static void main(String args[]) {
        Y2021M01D17_LC_Q343_S1 instance = new Y2021M01D17_LC_Q343_S1();

        // 2
        // 10
        // 3
        // 4

        System.out.println(instance.integerBreak(10));
    }

    public int integerBreak(int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 2; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = Math.max(max, Math.max(dp[j - 1] * (i - j), j * (i - j)));
            }
            dp[i - 1] = max;
        }

        return dp[n - 1];
    }
}
