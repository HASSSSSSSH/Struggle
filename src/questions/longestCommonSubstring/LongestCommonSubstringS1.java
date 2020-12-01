package questions.longestCommonSubstring;

/**
 * https://www.nowcoder.com/questionTerminal/02e7cc263f8a49e8b1e1dc9c116f7602
 * 最长公共子串
 * 给定两个字符串 text1 和 text2, 返回这两个字符串的最长公共子串的长度
 * 若这两个字符串没有公共子串, 则返回 0
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * 时间复杂度: O(mn), 其中 m 为 text1 的长度, n 为 text2 的长度
 * <p>
 * 空间复杂度: O(mn), 其中 m 为 text1 的长度, n 为 text2 的长度
 * 我们需要大小为 O(mn) 的数组来记录状态值
 */
public class LongestCommonSubstringS1 {

    public static void main(String args[]) {
        LongestCommonSubstringS1 instance = new LongestCommonSubstringS1();

        // "abcaef", "abaef"
        // "", "ab"

        System.out.println(instance.longestCommonSubstring("abcaef", "abaef"));
    }

    public int longestCommonSubstring(String text1, String text2) {
        int max = 0;

        // dp[i][j] 表示字符串 text1 在区间 [0, i - 1] 与 字符串 text2 在区间 [0, j - 1] 的公共子串的长度
        // 且该公共子串满足: 公共子串 = text1.substring(i - length, i) = text2.substring(j - length, j)

        // 之所以规定 0 <= i <= text1.length(), 0 <= j <= text2.length()
        // 是为了在字符串 text1 在区间 [0, 0] 与 字符串 text2 在区间 [0, 0] 的最长公共子串的长度计算过程中
        // 避免分类讨论
        // 事实上, dp[0][j] 表示 空字符串 与 字符串 text2 在区间 [0, j - 1] 的最长公共子串的长度
        // dp[i][0] 表示字符串 text1 在区间 [0, i - 1]  与 空字符串 的最长公共子串的长度
        // 显然, dp[0][j] = 0, dp[i][0] = 0 总是成立
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        for (int i = 0; i < text1.length(); i++) {
            for (int j = 0; j < text2.length(); j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    // 当 text1.charAt(i) == text2.charAt(j) 时
                    // 如果 dp[i][j] > 0
                    // 令 1 <= a <= dp[i][j]
                    // 说明 text1.charAt(i - a) == text2.charAt(j - a) 成立
                    // 所以 dp[i + 1][j + 1] 在 dp[i][j] 的基础上加 1
                    dp[i + 1][j + 1] = 1 + dp[i][j];

                    max = Math.max(max, dp[i + 1][j + 1]);
                }

                // 当 text1.charAt(i) != text2.charAt(j) 时
                // 由于从未对 dp[i + 1][j + 1] 进行赋值
                // 所以 dp[i + 1][j + 1] = 0
                // 说明字符串 text1 在区间 [0, i] 与 字符串 text2 在区间 [0, j] 的公共子串
                // 不能满足 公共子串 = text1.substring(i - length, i) = text2.substring(j - length, j)
            }
        }
        return max;
    }
}

// int length = 0;
// int[][] array = new int[n][m];
//
// for (int i = 0; i < n; i++) {
//     for (int j = 0; j < m; j++) {
//         if (A.charAt(i) == B.charAt(j)) {
//             array[i][j] = i - 1 >= 0 && j - 1 >= 0 ? (array[i - 1][j - 1] + 1) : 1;
//         } else {
//             array[i][j] = 0;
//         }
//         if (array[i][j] > length) {
//             length = array[i][j];
//         }
//     }
// }
// return length;
