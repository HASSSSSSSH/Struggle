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
 * Solution: Knuth–Morris–Pratt algorithm
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(m + n), 其中 n 是字符串 haystack 的长度, m 是字符串 needle 的长度, 我们至多需要遍历两字符串一次
 * <p>
 * 空间复杂度: O(m), 其中 m 是字符串 needle 的长度, 我们只需要保存字符串 needle 的前缀函数
 * <p>
 * Reference:
 * https://github.com/youngyangyang04/leetcode-master/blob/master/problems/0028.%E5%AE%9E%E7%8E%B0strStr.md
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/solution/shi-xian-strstr-by-leetcode-solution-ds6y/
 */
public class Num28_Solution2 {

    public static void main(String[] args) {
        Num28_Solution2 instance = new Num28_Solution2();

        // "sadbutsad", "ad"
        // "leetcode", "leeto"

        System.out.println(instance.strStr("sadbutsad", "ad"));
    }

    /**
     * KMP 算法
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length();
        int m = needle.length();
        int[] pi = new int[m];

        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                pi[i] = j + 1;
                j += 1;
            }
        }

        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j += 1;
            }
            if (j == m) {
                return i - j + 1;
            }
        }

        return -1;
    }
}
