package problems.leetcode.lcof;

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
public class Num5_Solution1 {

    public static void main(String[] args) {
        Num5_Solution1 instance = new Num5_Solution1();

        // "We are happy."
        // " happy "

        System.out.println(instance.replaceSpace(" happy "));
    }

    /**
     * 首先找出空格的数量, 然后从前向后替换空格
     */
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        char[] chars = s.toCharArray();
        int spaceNum = 0;
        for (char c : chars) {
            if (c == ' ') {
                spaceNum++;
            }
        }
        if (spaceNum == 0) {
            return s;
        }

        char[] newChars = new char[chars.length + spaceNum * 2];
        int index = 0;
        for (char c : chars) {
            if (c == ' ') {
                newChars[index++] = '%';
                newChars[index++] = '2';
                newChars[index++] = '0';
            } else {
                newChars[index++] = c;
            }
        }

        return new String(newChars);
    }
}
