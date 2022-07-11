package problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/reverse-string/
 * 反转字符串
 * <p>
 * 编写一个函数, 其作用是将输入的字符串反转过来
 * 输入字符串以字符数组 s 的形式给出
 * 不要给另外的数组分配额外的空间, 你必须原地修改输入数组, 使用 O(1) 的额外空间解决这一问题
 * <p>
 * 示例 1:
 * 输入: s = ["h", "e", "l", "l", "o"]
 * 输出: ["o", "l", "l", "e", "h"]
 * <p>
 * 示例 2:
 * 输入: s = ["H", "a", "n", "n", "a", "h"]
 * 输出: ["h", "a", "n", "n", "a", "H"]
 * <p>
 * 提示:
 * 1 <= s.length <= 10^5
 * s[i] 都是 ASCII 码表中的可打印字符
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.Recursion}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#A}
 * <p>
 * 时间复杂度: O(N), 其中 N 为字符数组的长度
 * 一共执行了 N/2 次的交换
 * <p>
 * 空间复杂度: O(1), 只使用了常数空间来存放若干变量
 */
public class Num344_Solution1 {

    public static void main(String[] args) {
        Num344_Solution1 instance = new Num344_Solution1();

        char[] s = new char[]{'h', 'e', 'l', 'l', 'o'};
        // char[] s = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};

        instance.reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        if (s.length == 0) {
            return;
        }

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
