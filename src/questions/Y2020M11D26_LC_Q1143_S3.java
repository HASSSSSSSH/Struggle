package questions;

/**
 * https://leetcode-cn.com/problems/longest-common-subsequence/
 * 最长公共子序列
 * 给定两个字符串 text1 和 text2, 返回这两个字符串的最长公共子序列的长度
 * 一个字符串的 子序列 是指这样一个新的字符串:
 * 它是由原字符串在不改变字符的相对顺序的情况下删除某些字符 (也可以不删除任何字符) 后组成的新字符串
 * 例如, "ace" 是 "abcde" 的子序列, 但 "aec" 不是 "abcde" 的子序列
 * 两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列
 * 若这两个字符串没有公共子序列, 则返回 0
 * <p>
 * 示例 1:
 * 输入: text1 = "abcde", text2 = "ace"
 * 输出: 3
 * 解释: 最长公共子序列是 "ace", 它的长度为 3
 * <p>
 * 示例 2:
 * 输入: text1 = "abc", text2 = "abc"
 * 输出: 3
 * 解释: 最长公共子序列是 "abc", 它的长度为 3
 * <p>
 * 示例 3:
 * 输入: text1 = "abc", text2 = "def"
 * 输出: 0
 * 解释: 两个字符串没有公共子序列, 返回 0
 * <p>
 * 提示:
 * 1 <= text1.length <= 1000
 * 1 <= text2.length <= 1000
 * 输入的字符串只含有小写英文字符
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * Reference: https://leetcode-cn.com/problems/longest-common-subsequence/solution/dong-tai-gui-hua-zhi-zui-chang-gong-gong-zi-xu-lie/
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Optimization of {@link Y2020M11D25_LC_Q1143_S2}
 */
public class Y2020M11D26_LC_Q1143_S3 {

    public static void main(String args[]) {
        Y2020M11D26_LC_Q1143_S3 instance = new Y2020M11D26_LC_Q1143_S3();

        // "horse", "ros"
        // "abcde", "ace"
        // "abc", "abc"
        // "abc", "def"
        // "qaqcde", "aced"
        // "aqafgh", "ahfph"

        System.out.println(instance.longestCommonSubsequence("horse", "ros"));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        return longestCommonSubsequence(dp, text1.length() - 1, text2.length() - 1, text1, text2);
    }

    /**
     * 优化状态转移方程
     * <p>
     * 当 text1[i] != text2[j] 时, 事实上没有必要考虑字符 text1[i] 和 字符 text2[j] 都不在 最长公共子序列 当中这种情况
     * <p>
     * 因此字符串 text1 在区间 [0, i - 1] 和 text2 在区间 [0, j] 的最长公共子序列的长度
     * 以及字符串 text1 在区间 [0, i] 和 text2 在区间 [0, j - 1] 的最长公共子序列的长度
     * 这两种情况得出的 最长公共子序列的长度 总是 大于等于
     * 字符串 text1 在区间 [0, i - 1] 和 text2 在区间 [0, j - 1] 的最长公共子序列的长度
     * <p>
     * 例如:
     * text1 = "acb", text2 = "abd"
     * 字符串 text1 在区间 [0, 1] 和 text2 在区间 [0, 2] 的最长公共子序列的长度 = 1
     * 字符串 text1 在区间 [0, 2] 和 text2 在区间 [0, 1] 的最长公共子序列的长度 = 2
     * 字符串 text1 在区间 [0, 1] 和 text2 在区间 [0, 1] 的最长公共子序列的长度 = 1
     * <p>
     * 所以 dp(i - 1, j - 1) <= dp(i - 1, j), dp(i - 1, j - 1) <= dp(i, j - 1) 总是成立
     * <p>
     * 因此, 当 text1[i] != text2[j] 时, dp[i][j] = max(dp(i - 1, j), dp(i, j - 1))
     */
    public int longestCommonSubsequence(int[][] dp, int i, int j, String text1, String text2) {
        if (i >= 0 && j >= 0) {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i][j] = 1 + longestCommonSubsequence(dp, i - 1, j - 1, text1, text2);
            } else {
                dp[i][j] = Math.max(longestCommonSubsequence(dp, i - 1, j, text1, text2),
                        longestCommonSubsequence(dp, i, j - 1, text1, text2));
            }
            return dp[i][j];
        }
        return 0;
    }
}
