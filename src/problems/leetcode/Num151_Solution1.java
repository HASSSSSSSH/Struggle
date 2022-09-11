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
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: O(n)
 */
public class Num151_Solution1 {

    public static void main(String[] args) {
        Num151_Solution1 instance = new Num151_Solution1();

        // "the sky is blue"
        // "  hello world  "
        // "a good   example"

        System.out.println(instance.reverseWords("  hello world  "));
    }

    /**
     * 首先移除首尾空格, 然后从后向前遍历字符串 s 找出单词, 再将单词放入新数组
     */
    public String reverseWords(String s) {
        int start = 0;
        int end = s.length() - 1;

        // 移除字符串首尾的空格
        // 注意到题目表明了字符串 s 中至少存在一个单词, 因此不需要考虑数组越界的情况
        for (; s.charAt(start) == ' '; start++) ;
        for (; s.charAt(end) == ' '; end--) ;

        int size = 0;
        char[] charArr = new char[end - start + 1];

        // 从后向前遍历字符串 s
        // 此时 s.charAt(end) 和 s.charAt(start) 必定是一个非空格的字符
        while (end >= start) {
            int fromIndex = end;
            int toIndex = end;

            // 找出空格
            // 注意, toIndex 必须大于 start
            while (toIndex > start && s.charAt(toIndex - 1) != ' ') {
                toIndex--;
            }

            // 字符串在区间 [toIndex, fromIndex] 组成了一个单词
            for (int i = toIndex; i <= fromIndex; i++) {
                charArr[size++] = s.charAt(i);
            }

            // 当 toIndex != start 时, 说明此时仍存在下一个单词, 直接加上一个空格
            if (toIndex != start) {
                charArr[size++] = ' ';
            }

            // 要注意的是, 此时 end 可能小于 start
            end = toIndex - 1;

            // 跳过所有空格, 保证 s.charAt(end) 必定是一个非空格的字符
            // 注意, end 必须大于 start
            // 当 end = start + 1 时, s.charAt(end - 1) 必定是一个非空格的字符
            for (; end > start && s.charAt(end) == ' '; end--) ;
        }

        // 返回由字符数组 charArr 在区间 [0, size - 1] 组成的字符串
        return new String(charArr, 0, size);
    }
}
