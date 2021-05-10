package questions;

/**
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 剪绳子 II
 * <p>
 * 给你一根长度为 n 的绳子, 请把绳子剪成整数长度的 m 段 (m, n都是整数, n > 1 并且 m > 1), 每段绳子的长度记为 k[0], k[1]...k[m - 1]
 * 请问 k[0] * k[1] * ... * k[m - 1] 可能的最大乘积是多少?
 * 答案需要取模 1e9 + 7 (1000000007), 如计算初始结果为: 1000000008, 请返回 1
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
 * 提示:
 * 2 <= n <= 1000
 * <p>
 * Tags: {@link questions.tags.Math}, {@link questions.tags.Greedy}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * Solution: {@link questions.tags.GreedyAlgorithm}
 * <p>
 * Reference:
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/javatan-xin-si-lu-jiang-jie-by-henrylee4/
 * https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/solution/mian-shi-ti-14-ii-jian-sheng-zi-iitan-xin-er-fen-f/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D19_LCOF_Q14_2_S1 {

    public static void main(String args[]) {
        Y2021M01D19_LCOF_Q14_2_S1 instance = new Y2021M01D19_LCOF_Q14_2_S1();

        // 2
        // 10
        // 3
        // 4

        System.out.println(instance.cuttingRope(10));
    }

    public int cuttingRope(int n) {
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int mod = (int) 1e9 + 7;

        // 注意, 此处 ans 的类型是 long
        // 由于 ((int) 1e9 + 6) * 3 会溢出, 所以在极限情况下, (ans *= 3) 可能会溢出
        long ans = 1;

        while (n > 4) {
            ans *= 3;
            ans %= mod;
            n -= 3;
        }
        return (int) (ans * n % mod);
    }
}
