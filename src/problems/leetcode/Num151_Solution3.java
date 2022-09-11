package problems.leetcode;

/**
 * https://leetcode.cn/problems/reverse-words-in-a-string/
 * 颠倒字符串中的单词
 * <p>
 * 给你一个字符串 s, 颠倒字符串中 单词 的顺序
 * 单词是由非空格字符组成的字符串, s 中使用至少一个空格将字符串中的 单词 分隔开
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串
 * <p>
 * 注意:
 * 输入字符串 s 中可能会存在前导空格, 尾随空格或者单词间的多个空格
 * 返回的结果字符串中, 单词间应当仅用单个空格分隔, 且不包含任何额外的空格
 * <p>
 * 示例 1:
 * 输入: s = "the sky is blue"
 * 输出: "blue is sky the"
 * <p>
 * 示例 2:
 * 输入: s = "  hello world  "
 * 输出: "world hello"
 * 解释: 颠倒后的字符串中不能存在前导空格和尾随空格
 * <p>
 * 示例 3:
 * 输入: s = "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格, 颠倒后的字符串需要将单词间的空格减少到仅有一个
 * <p>
 * 提示:
 * 1 <= s.length <= 104
 * s 包含英文大小写字母, 数字和空格 ' '
 * s 中 至少存在一个 单词
 * <p>
 * 进阶: 如果字符串在你使用的编程语言中是一种可变数据类型, 尝试使用 O(1) 额外空间复杂度的 原地 解法
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.Simulation}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n), 其中 n 为输入字符串的长度
 * <p>
 * 空间复杂度: O(n), 用来存储字符串
 * <p>
 * Reference: https://leetcode.cn/problems/reverse-words-in-a-string/solution/fan-zhuan-zi-fu-chuan-li-de-dan-ci-by-leetcode-sol/
 */
public class Num151_Solution3 {

    public static void main(String[] args) {
        Num151_Solution3 instance = new Num151_Solution3();

        // "the sky is blue"
        // "  hello world  "
        // "a good   example"

        System.out.println(instance.reverseWords("  hello world  "));
    }

    public String reverseWords(String s) {
        StringBuilder builder = trimSpaces(s);

        // 翻转字符串
        reverse(builder, 0, builder.length() - 1);

        // 翻转每个单词
        reverseEachWord(builder);

        return builder.toString();
    }

    public StringBuilder trimSpaces(String s) {
        int left = 0;
        int right = s.length() - 1;

        // 移除字符串首尾的空格
        while (left <= right && s.charAt(left) == ' ') {
            left++;
        }
        while (left <= right && s.charAt(right) == ' ') {
            right--;
        }

        // 将字符串间多余的空格去除
        StringBuilder builder = new StringBuilder();
        while (left <= right) {
            char c = s.charAt(left);

            if (c != ' ') {
                builder.append(c);
            } else if (builder.charAt(builder.length() - 1) != ' ') {
                // 此时 c == ' ', 需要考虑是否添加空格
                // 如果字符串之间的还没有空格, 那么加上空格
                builder.append(c);
            }

            left++;
        }
        return builder;
    }

    public void reverse(StringBuilder builder, int left, int right) {
        while (left < right) {
            char tmp = builder.charAt(left);
            builder.setCharAt(left++, builder.charAt(right));
            builder.setCharAt(right--, tmp);
        }
    }

    public void reverseEachWord(StringBuilder builder) {
        int n = builder.length();
        int start = 0;
        int end = 0;

        while (start < n) {
            // 找到单词的末尾
            while (end < n && builder.charAt(end) != ' ') {
                end++;
            }

            // 翻转单词, 此时区间 [start, end - 1] 组成了一个单词
            reverse(builder, start, end - 1);

            // 更新 start, 去找下一个单词
            start = end + 1;
            end++;
        }
    }
}
