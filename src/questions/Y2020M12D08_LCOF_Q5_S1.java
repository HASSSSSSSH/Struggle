package questions;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 替换空格
 * <p>
 * 请实现一个函数, 把字符串 s 中的每个空格替换成 "%20"
 * <p>
 * 示例 1:
 * 输入: s = "We are happy."
 * 输出: "We%20are%20happy."
 * <p>
 * Tags: {@link questions.tags.String}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.Iterative}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M12D08_LCOF_Q5_S1 {

    public static void main(String args[]) {
        Y2020M12D08_LCOF_Q5_S1 instance = new Y2020M12D08_LCOF_Q5_S1();

        // "We are happy."
        // " happy "

        System.out.println(instance.replaceSpace(" happy "));
    }

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

        // 在下次遇到字符 ' ' 时, 标记最后一个需要移动的字符
        int end = chars.length - 1;

        // 从后往前遍历, 可以避免同一个字符移动多次
        // 从后往前遍历, 每个字符最多移动一次
        for (int i = chars.length - 1; i >= 0; i--) {
            if (' ' == newChars[i]) {
                replace(newChars, i + 1, end, 2 * spaceNum);
                end = i - 1;
                spaceNum--;
            }
        }
        return new String(newChars);
    }

    public void replace(char[] chars, int start, int end, int shift) {
        while (end >= start) {
            chars[end + shift] = chars[end];
            end--;
        }

        // 此时, end 总是指向字符 ' '
        chars[shift + end--] = '0';
        chars[shift + end--] = '2';
        chars[shift + end] = '%';
    }
}
