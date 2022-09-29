package problems.leetcode;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/repeated-substring-pattern/
 * 重复的子字符串
 * <p>
 * 给定一个非空的字符串 s, 检查是否可以通过由它的一个子串重复多次构成
 * <p>
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成
 * <p>
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成, 或子串 "abcabc" 重复两次构成
 * <p>
 * 提示:
 * 1 <= s.length <= 10^4
 * s 由小写英文字母组成
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.StringMatching}
 * <p>
 * Solution: {@link questions.tags.StringMatching}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(n), 其中 n 是字符串 s 的长度
 * <p>
 * 空间复杂度: O(n)
 * <p>
 * Reference: https://leetcode.cn/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
 */
public class Num459_Solution2 {

    public static void main(String[] args) {
        Num459_Solution2 instance = new Num459_Solution2();

        // "abab"
        // "aba"
        // "abcabcabcabc"

        System.out.println(instance.repeatedSubstringPattern("abab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        return kmp(s + s, s);
    }

    public boolean kmp(String query, String pattern) {
        int n = query.length();
        int m = pattern.length();

        int[] fail = new int[m];
        Arrays.fill(fail, -1);

        for (int i = 1; i < m; ++i) {
            int j = fail[i - 1];
            while (j != -1 && pattern.charAt(j + 1) != pattern.charAt(i)) {
                j = fail[j];
            }
            if (pattern.charAt(j + 1) == pattern.charAt(i)) {
                fail[i] = j + 1;
            }
        }

        int match = -1;
        for (int i = 1; i < n - 1; ++i) {
            while (match != -1 && pattern.charAt(match + 1) != query.charAt(i)) {
                match = fail[match];
            }
            if (pattern.charAt(match + 1) == query.charAt(i)) {
                ++match;
                if (match == m - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
