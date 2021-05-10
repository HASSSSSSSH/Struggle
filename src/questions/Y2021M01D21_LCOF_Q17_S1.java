package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 打印从 1 到最大的 n 位数
 * <p>
 * 输入数字 n, 按顺序打印出从 1 到最大的 n 位十进制数
 * 比如输入 3, 则打印出 1, 2, 3 一直到最大的 3 位数 999
 * <p>
 * 实例 1:
 * 输入: n = 1
 * 输出: [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * <p>
 * 说明:
 * 用返回一个整数列表来代替打印
 * n 为正整数
 * <p>
 * Tags: {@link questions.tags.Math}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#A}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(10^(n)), 生成长度为 10^(n) 的列表需使用 O(10^(n)) 时间
 * <p>
 * 空间复杂度: O(10^(n))
 */
public class Y2021M01D21_LCOF_Q17_S1 {

    public static void main(String args[]) {
        Y2021M01D21_LCOF_Q17_S1 instance = new Y2021M01D21_LCOF_Q17_S1();

        // 1
        // 3

        System.out.println(Arrays.toString(instance.printNumbers(3)));
    }

    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] ans = new int[end];
        for (int i = 0; i < end; i++) {
            ans[i] = i + 1;
        }
        return ans;
    }
}
