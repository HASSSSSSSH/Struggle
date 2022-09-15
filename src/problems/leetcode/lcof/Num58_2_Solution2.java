package problems.leetcode.lcof;

/**
 * https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
 * 左旋转字符串
 * <p>
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部
 * 请定义一个函数实现字符串左旋转操作的功能
 * 比如, 输入字符串 "abcdefg" 和数字 2, 该函数将返回左旋转两位得到的结果 "cdefgab"
 * <p>
 * 示例 1:
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 * <p>
 * 示例 2:
 * 输入: s = "lrloseumgh", k = 6
 * 输出: "umghlrlose"
 * <p>
 * 限制:
 * 1 <= k < s.length <= 10000
 * <p>
 * Tags: {@link questions.tags.String}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Num58_2_Solution2 {

    public static void main(String[] args) {
        Num58_2_Solution2 instance = new Num58_2_Solution2();

        // "abcdefg", 2
        // "abcdefg", 6

        System.out.println(instance.reverseLeftWords("abcdefg", 2));
    }

    /**
     * 不使用切片方法
     */
    public String reverseLeftWords(String s, int n) {
        if (n > s.length()) {
            return s;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = n; i < s.length() + n; i++) {
            builder.append(s.charAt(i % s.length()));
        }
        return builder.toString();
    }
}
