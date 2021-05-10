package questions;

/**
 * https://leetcode-cn.com/problems/powx-n/
 * https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * Pow(x, n)
 * <p>
 * 实现 pow(x, n), 即计算 x 的 n 次幂函数
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * <p>
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * <p>
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^(-2) = 1/2^(2) = 1/4 = 0.25
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数, 其数值范围是 [−2^(31), 2^(31) − 1]
 * <p>
 * Tags: {@link questions.tags.Math}, {@link questions.tags.BinarySearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#B}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Result: Time Limit Exceeded
 */
public class Y2021M01D21_LC_Q50_S1 {

    public static void main(String args[]) {
        Y2021M01D21_LC_Q50_S1 instance = new Y2021M01D21_LC_Q50_S1();

        // 2.00000, 10
        // 2.10000, 3
        // 2.00000, -2
        // 1.00000, 2147483647
        // 2.00000, -2147483648

        System.out.println(instance.myPow(2.00000, -2));
    }

    public double myPow(double x, int n) {
        double res = 1;
        double abs = (n < 0) ? -n : n;
        for (int i = 0; i < abs; i++) {
            res *= x;
        }
        return n >= 0 ? res : 1 / res;
    }
}
