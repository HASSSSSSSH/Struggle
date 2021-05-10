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
 * Refercen: https://leetcode-cn.com/problems/number-of-1-bits/solution/wei-1de-ge-shu-by-leetcode/
 * <p>
 * 时间复杂度: O(1), 运行时间依赖于数字 n 的位数, 由于这题中 n 是一个 32 位数, 所以运行时间是 O(1)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2021M01D20_LC_Q191_S2 {

    public static void main(String args[]) {
        Y2021M01D20_LC_Q191_S2 instance = new Y2021M01D20_LC_Q191_S2();

        // 0x0000000b (00000000000000000000000000001011)
        // 0x8000000b (10000000000000000000000000001011)

        System.out.println(instance.hammingWeight(0x8000000b));
    }

    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int sum = 0;

        while (n != 0) {
            // 当 n != 0 时, 说明数字 n 的二进制表达式中仍存在 '1' 的数字位
            sum++;

            // (n & (n - 1)) 使得数字 n 中最低位的 1 变成 0
            n = n & (n - 1);
        }
        return sum;
    }
}
