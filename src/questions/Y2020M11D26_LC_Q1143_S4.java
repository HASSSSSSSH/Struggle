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
 * 时间复杂度: O(mn), 其中 m 为 text1 的长度, n 为 text2 的长度
 * <p>
 * 空间复杂度:  O(mn), 其中 m 为 text1 的长度, n 为 text2 的长度
 * 我们需要大小为 O(mn) 的数组来记录状态值
 */
public class Y2020M11D26_LC_Q1143_S4 {

    public static void main(String args[]) {
        Y2020M11D26_LC_Q1143_S4 instance = new Y2020M11D26_LC_Q1143_S4();

        // "horse", "ros"
        // "abcde", "ace"
        // "abc", "abc"
        // "abc", "def"
        // "qaqcde", "aced"
        // "aqafgh", "ahfph"

        System.out.println(instance.longestCommonSubsequence("horse", "ros"));
    }

    /**
     * 动态规划-自底向上
     * <p>
     * 1.定义状态
     * dp[i][j] (0 <= i <= text1.length, 0 <= j <= text2.length)
     * 之所以这样定义 i & j 的取值范围, 是为了满足 dp[i][0] = 0, dp[j][0] = 0, 使得状态方程总是成立
     * 当 i == 1 或者 j == 1 时, 在计算 dp[1][j], dp[i][1] 的过程中, 可以避免分类讨论, 简化计算过程
     * <p>
     * 事实上, 可以将 text1, text2 在区间 [0, -1] 当成是 空字符串
     * dp[i][0] 表示将 text1 在区间 [0, i] 和 空字符串 的最长公共子序列的长度
     * dp[0][j] 表示将 空字符串 和 text2 在区间 [0, j] 的最长公共子序列的长度
     * <p>
     * 因此, dp[i][j] 表示 text1 在区间 [0, i - 1] 和 text2 在区间 [0, j - 1] 的最长公共子序列的长度
     * <p>
     * 2.状态转移方程
     * 经过之前的讨论, 可得出结论:
     * 令 i' = i - 1, j' = j - 1, 因此 -1 <= i' <= word1.length - 1, -1 <= j' <= word2.length - 1
     * <p>
     * 当 text1[i'] == text2[j'] 时, dp[i][j] = 1 + dp[i - 1][j - 1]
     * <p>
     * 当 text1[i'] != text2[j'] 时, dp[i][j] = max(dp(i - 1, j), dp(i, j - 1))
     * <p>
     * 3.思考初始化
     * 为了在计算 dp[1][j], dp[i][1] (0 <= i <= word1.length, 0 <= j <= word2.length) 时, 避免分类讨论
     * 同时使得状态方程总是成立, 应当初始化 dp[i][0], dp[j][0]
     * 使得 dp[i][0] = 0, 其中 0 <= i <= word1.length
     * 使得 dp[0][j] = 0, 其中 0 <= j <= word2.length
     * <p>
     * 4.思考输出
     * 输出的结果是: 将 text1 在区间 [0, text1.length - 1] 和 text2 在区间 [0, text2.length - 1] 的最长公共子序列的长度
     * 因此输出 dp[text1.length][text2.length]
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}
