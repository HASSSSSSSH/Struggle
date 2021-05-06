package questions;

/**
 * https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 青蛙跳台阶问题
 * <p>
 * 一只青蛙一次可以跳上 1 级台阶, 也可以跳上 2 级台阶
 * 求该青蛙跳上一个 n 级的台阶总共有多少种跳法
 * <p>
 * 答案需要取模 1e9+7 (1000000007), 如计算初始结果为: 1000000008, 请返回 1
 * <p>
 * 示例 1:
 * 输入: n = 2
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: n = 7
 * 输出: 21
 * <p>
 * 示例 3:
 * 输入: n = 0
 * 输出: 1
 * <p>
 * Tags: {@link questions.tags.DynamicProgramming}, {@link questions.tags.Recursion}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#A}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M12D29_LCOF_Q10_2_S1 {

    public static void main(String args[]) {
        Y2020M12D29_LCOF_Q10_2_S1 instance = new Y2020M12D29_LCOF_Q10_2_S1();

        System.out.println(instance.numWays(7));
    }

    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[2];
        dp[0] = 1;
        dp[1] = 1;

        // F(n) = F(n - 1) + F(n - 2)
        // 计算 F(i) = F(i - 1) + F(i - 2)
        // 最终 dp[0] = F(i - 1), dp[1] = F(i)
        // 所以 F(i + 1) = F(i) + F(i - 1) = dp[1] + dp[0]
        for (int i = 2; i <= n; i++) {
            // 由于 1000000007 * 2 < Integer.MAX_VALUE, 因此 dp[0] + dp[1] < Integer.MAX_VALUE 总是成立
            int sum = (dp[0] + dp[1]) % 1000000007;
            dp[0] = dp[1];
            dp[1] = sum;
        }

        // 此时 dp[1] = F(n)
        return dp[1];
    }
}
