package problems.leetcode.lcof;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/ti-huan-kong-ge-lcof/
 * 替换空格
 * <p>
 * 请实现一个函数, 把字符串 s 中的每个空格替换成 "%20"
 * <p>
 * 示例 1:
 * 输入: s = "We are happy."
 * 输出: "We%20are%20happy."
 * <p>
 * 限制: 0 <= s 的长度 <= 10000
 * <p>
 * Tags: {@link questions.tags.String}
 * <p>
 * Solution: {@link questions.tags.Iteration}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#D}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n), 额外创建字符数组, 长度最多为 s 的长度的 3 倍
 */
public class Num5_Solution2 {

    public static void main(String[] args) {
        Num5_Solution2 instance = new Num5_Solution2();

        // "We are happy."
        // " happy "

        System.out.println(instance.replaceSpace(" happy "));
    }

    /**
     * 首先找出空格的数量, 然后从后向前替换空格
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int spaceNum = 0;
        for (char c : chars) {
            if (' ' == c) {
                spaceNum++;
            }
        }
        if (spaceNum == 0) {
            return s;
        }

        char[] newChars = Arrays.copyOf(chars, 2 * spaceNum + chars.length);

        // 指向旧字符数组的末尾
        int start = chars.length - 1;

        // 指向新字符数组的末尾
        int end = newChars.length - 1;

        // 新字符数组复制了旧字符数组
        // 从后向前遍历, 可以避免同一个字符移动多次
        while (start < end) {
            if (' ' == chars[start]) {
                newChars[end--] = '0';
                newChars[end--] = '2';
                newChars[end--] = '%';
            } else {
                newChars[end--] = chars[start];
            }
            start--;
        }
        return new String(newChars);
    }
}
