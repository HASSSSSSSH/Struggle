package questions;

/**
 * https://leetcode-cn.com/problems/number-of-1-bits/
 * https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 位 1 的个数
 * <p>
 * 编写一个函数, 输入是一个无符号整数 (以二进制串的形式), 返回其二进制表达式中数字位数为 '1' 的个数 (也被称为汉明重量)
 * <p>
 * 提示:
 * 输入必须是长度为 32 的 二进制串
 * <p>
 * 进阶:
 * 如果多次调用这个函数, 你将如何优化你的算法?
 * <p>
 * Tags: {@link questions.tags.BitManipulation}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * Solution: {@link questions.tags.BitManipulation}
 * <p>
 * 时间复杂度: O(1), 运行时间依赖于数字 n 的位数, 由于这题中 n 是一个 32 位数, 所以运行时间是 O(1)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D19_LC_Q191_S1 {

    public static void main(String args[]) {
        Y2021M01D19_LC_Q191_S1 instance = new Y2021M01D19_LC_Q191_S1();

        // 0x0000000b (00000000000000000000000000001011)
        // 0x8000000b (10000000000000000000000000001011)

        System.out.println(instance.hammingWeight(0x8000000b));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                ans++;
            }

            // 将 n 当为无符号整数进行操作, 如果使用操作符有符号右移 '>>', 会出现死循环
            n = n >>> 1;
        }
        return ans;
    }
}
