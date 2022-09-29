package problems.leetcode;

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
 * Solution: {@link questions.tags.BruteForce}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * 时间复杂度: O(n^2), 其中 n 是字符串 s 的长度
 * 枚举 i 的时间复杂度为 O(n), 遍历 s 的时间复杂度为 O(n), 相乘即为总时间复杂度
 * <p>
 * 空间复杂度: O(1)
 * <p>
 * Reference: https://leetcode.cn/problems/repeated-substring-pattern/solution/zhong-fu-de-zi-zi-fu-chuan-by-leetcode-solution/
 */
public class Num459_Solution1 {

    public static void main(String[] args) {
        Num459_Solution1 instance = new Num459_Solution1();

        // "abab"
        // "aba"
        // "abcabcabcabc"
        // "babbabbabbabbab"

        System.out.println(instance.repeatedSubstringPattern("abab"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; i++) {
            // 如果 n % i != 0, 说明字符串 s 必定不能通过长度为 i 的子串重复多次构成
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; j++) {
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
