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
 * Solution: ???
 * <p>
 * Reference: https://leetcode-cn.com/problems/powx-n/solution/powx-n-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(logn), 即为对 n 进行二进制拆分的时间复杂度
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Optimization of {@link Y2021M01D21_LC_Q50_S2}
 */
public class Y2021M01D21_LC_Q50_S3 {

    public static void main(String args[]) {
        Y2021M01D21_LC_Q50_S3 instance = new Y2021M01D21_LC_Q50_S3();

        // 2.00000, 10
        // 2.10000, 3
        // 2.00000, -2
        // 1.00000, 2147483647
        // 2.00000, -2147483648

        System.out.println(instance.myPow(2.00000, -2));
    }

    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
}
