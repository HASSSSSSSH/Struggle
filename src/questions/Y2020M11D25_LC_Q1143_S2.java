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
 * Optimization of {@link Y2020M11D25_LC_Q1143_S1}
 */
public class Y2020M11D25_LC_Q1143_S2 {

    public static void main(String args[]) {
        Y2020M11D25_LC_Q1143_S2 instance = new Y2020M11D25_LC_Q1143_S2();

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
     * 通过分析, 可以发现 {@link Y2020M11D25_LC_Q1143_S1} 这种解法存在重叠子问题
     * <p>
     * 在计算 longestCommonSubsequence(4, 3) 时, 可能会有这样的一个过程:
     * <p>
     * 1.计算 longestCommonSubsequence(3, 3)  longestCommonSubsequence(4, 2)  longestCommonSubsequence(3, 2)
     * <p>
     * 2.
     * 计算 longestCommonSubsequence(2, 3)  longestCommonSubsequence(3, 2)  longestCommonSubsequence(2, 2)
     * 计算 longestCommonSubsequence(3, 2)  longestCommonSubsequence(4, 1)  longestCommonSubsequence(3, 1)
     * 计算 longestCommonSubsequence(2, 2)  longestCommonSubsequence(3, 1)  longestCommonSubsequence(2, 1)
     * <p>
     * 显而易见, 这种解法会对同一子问题进行重复的计算
     * 使用动态规划(记忆化递归), 可以优化这一过程
     * <p>
     * 动态规划-自顶向下
     * <p>
     * 1.定义状态
     * dp[i][j] (0 <= i < text1.length, 0 <= j < text2.length)
     * 之所以这样定义 i & j 的取值范围, 是因为当 i < 0 或者 j < 0 时, 空字符串 与 任意字符串 的 最长公共子序列的长度 必定为 0
     * 因此可以直接返回 0
     * <p>
     * 因此, dp[i][j] 表示 text1 在区间 [0, i] 和 text2 在区间 [0, j] 的最长公共子序列的长度
     * <p>
     * 2.状态转移方程
     * 经过之前的讨论, 可得出结论:
     * <p>
     * 当 text1[i] == text2[j] 时, dp[i][j] = 1 + dp[i - 1][j - 1]
     * <p>
     * 当 text1[i] != text2[j] 时, dp[i][j] = max(dp(i - 1, j), dp(i, j - 1), dp(i - 1, j - 1))
     * <p>
     * 同时, 定义函数 longestCommonSubsequence(i, j, text1, text2), 其中 -1 <= i < text1.length, -1 <= j < text2.length
     * 返回 text1 在区间 [0, i] 和 text2 在区间 [0, j] 的最长公共子序列的长度
     * 在这种情况下, 函数 longestCommonSubsequence(i, j, text1, text2) 的值 = dp[i][j]
     * <p>
     * 3.思考输出
     * 输出的结果是: 将 text1 在区间 [0, text1.length - 1] 和 text2 在区间 [0, text2.length - 1] 的最长公共子序列的长度
     * 因此输出 dp[text1.length - 1][text2.length - 1]
     */
    public int longestCommonSubsequence(int[][] dp, int i, int j, String text1, String text2) {
        if (i >= 0 && j >= 0) {
            if (dp[i][j] != -1) {
                return dp[i][j];
            }
            if (text1.charAt(i) == text2.charAt(j)) {
                dp[i][j] = 1 + longestCommonSubsequence(dp, i - 1, j - 1, text1, text2);
            } else {
                int max = 0;
                max = Math.max(max, longestCommonSubsequence(dp, i - 1, j, text1, text2));
                max = Math.max(max, longestCommonSubsequence(dp, i, j - 1, text1, text2));
                max = Math.max(max, longestCommonSubsequence(dp, i - 1, j - 1, text1, text2));
                dp[i][j] = max;
            }
            return dp[i][j];
        }
        return 0;
    }
}
