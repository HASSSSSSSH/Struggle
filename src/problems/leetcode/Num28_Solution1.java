package problems.leetcode;

/**
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * 找出字符串中第一个匹配项的下标
 * <p>
 * 给你两个字符串 haystack 和 needle, 请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标 (下标从 0 开始)
 * 如果 needle 不是 haystack 的一部分, 则返回 -1
 * <p>
 * 示例 1:
 * 输入: haystack = "sadbutsad", needle = "sad"
 * 输出: 0
 * 解释: "sad" 在下标 0 和 6 处匹配, 第一个匹配项的下标是 0, 所以返回 0
 * <p>
 * 示例 2:
 * 输入: haystack = "leetcode", needle = "leeto"
 * 输出: -1
 * 解释: "leeto" 没有在 "leetcode" 中出现, 所以返回 -1
 * <p>
 * 提示:
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.StringMatching}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.BruteForce}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(nm), 其中 n 是字符串 haystack 的长度, m 是字符串 needle 的长度
 * 最坏情况下我们需要将字符串 needle 与字符串 haystack 的所有长度为 m 的子串均匹配一次
 * <p>
 * 空间复杂度: O(1)
 */
public class Num28_Solution1 {

    public static void main(String[] args) {
        Num28_Solution1 instance = new Num28_Solution1();

        // "sadbutsad", "ad"
        // "leetcode", "leeto"

        System.out.println(instance.strStr("sadbutsad", "ad"));
    }

    public int strStr(String haystack, String needle) {
        outer:
        for (int i = 0; i < haystack.length() - needle.length() + 1; i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    continue outer;
                }
            }
            return i;
        }

        return -1;
    }
}
