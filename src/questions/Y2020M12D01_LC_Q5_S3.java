package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s, 找到 s 中最长的回文子串
 * 你可以假设 s 的最大长度为 1000
 * <p>
 * 实例1:
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 * <p>
 * 实例2:
 * 输入: "babad"
 * 输出: "bb"
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.DynamicProgramming}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}
 * <p>
 * 时间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * 空间复杂度: O(N^2), N 为字符串的长度
 */
public class Y2020M12D01_LC_Q5_S3 {

    public static void main(String args[]) {
        Y2020M12D01_LC_Q5_S3 instance = new Y2020M12D01_LC_Q5_S3();

        // babad
        // fffffffffffffffffffggggggggggggggggggggg
        // abzdba
        // cccbbccd
        // cbabxdaad
        // cbabxdaadz
        // abcdxddcba

        System.out.println(instance.longestPalindrome("cccbbccd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        // 必须将 ans 初始化为字符串的第一个字符
        // 如果将 ans 初始化为 null 或者 空字符串
        // 当最长的回文子串的长度为 1 时, 会得出错误的结果
        String ans = s.substring(0, 1);

        // dp[i][j] > 0 表示字符串 s 在区间 [i, j] 组成的子串是一个回文字符串
        // dp[i][j] 表示该回文子串的长度
        int[][] dp = new int[s.length()][s.length()];

        // 由于 dp[i][j] 的计算过程中依赖左下角 dp[i + 1][j - 1]的值
        // 所以必须要 1 <= i < length, 0 <= j < length - i 的顺序初始化 dp[j][j + i]
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }

        // 遍历字符串 s 中每一个长度为 i + 1 的子串
        for (int i = 1; i < s.length(); i++) {

            // 遍历每一个字符串 s 在区间 [j, j + i] 组成的子串
            for (int j = 0; j + i < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i == 1) {
                        // 特殊情况, 由于 j + i - j = i = 1, 说明目前选取的子串只有 2 个字符
                        // 所以, 当 s.charAt(j) == s.charAt(j + i) 时, dp[j][j + i] = 2
                        dp[j][j + i] = 2;
                    } else if (dp[j + 1][j + i - 1] > 0) {
                        // 由于 j + i - j = i > 1, 说明目前选取的子串超过 2 个字符
                        // 当 dp[j + 1][j + i - 1] > 0 时, 说明子串 s.subString(j + 1, j + i) 也是一个回文字符串
                        // 由于 s.charAt(j) == s.charAt(j + i)
                        // 所以 dp[j][j + i] = 2 + dp[j + 1][j + i - 1]
                        dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                    }

                    if (dp[j][j + i] > ans.length()) {
                        // 更新最长的回文子串
                        ans = s.substring(j, j + i + 1);
                    }
                }

                // 当 s.charAt(j) != s.charAt(j + i) 时, 说明字符串 s 在区间 [j, j + i] 组成的子串不可能是一个回文字符串
                // dp[j][j + i] = 0
            }
        }
        return ans;
    }
}
