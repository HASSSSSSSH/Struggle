package questions;

/**
 * https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * 斐波那契数列
 * <p>
 * 写一个函数, 输入 n, 求斐波那契 (Fibonacci) 数列的第 n 项
 * <p>
 * 斐波那契数列的定义如下:
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1
 * 斐波那契数列由 0 和 1 开始, 之后的斐波那契数就是由之前的两数相加而得出
 * 答案需要取模 1e9+7 (1000000007), 如计算初始结果为: 1000000008, 请返回 1
 * <p>
 * 示例 1:
 * 输入: n = 2
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: n = 5
 * 输出: 5
 * <p>
 * Tags: {@link questions.tags.DynamicProgramming}, {@link questions.tags.Recursion}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#A}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}, {@link questions.tags.Recursive}
 * <p>
 * 时间复杂度: O(n), ??
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M12D29_LCOF_Q10_1_S1 {

    public static void main(String args[]) {
        Y2020M12D29_LCOF_Q10_1_S1 instance = new Y2020M12D29_LCOF_Q10_1_S1();

        System.out.println(instance.fib(5));
    }

    public int fib(int n) {
        if (n <= 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        return (int) fib(dp, n);
    }

    public long fib(int[] dp, int n) {
        if (n <= 1 || dp[n] != 0) {
            return dp[n];
        }
        dp[n] = (int) ((fib(dp, n - 1) + fib(dp, n - 2)) % 1000000007);
        return dp[n];
    }
}
