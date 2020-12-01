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
 * 空间复杂度: O(1)
 * <p>
 * Optimization of {@link LongestCommonSubstringS1}
 */
public class LongestCommonSubstringS2 {

    public static void main(String args[]) {
        LongestCommonSubstringS2 instance = new LongestCommonSubstringS2();

        // "abcaef", "abaef"
        // "", "ab"

        System.out.println(instance.longestCommonSubstring("abcaef", "abaef"));
    }

    /**
     * 优化空间
     * <p>
     * 事实上, 在 dp[i][j] 的计算过程中
     * 只参考对角线上 dp[i - 1][j - 1] 的值
     * 因此, 在数组 dp[i][j] 的计算过程中
     * 完全可以从对角线开始计算, 只使用一个 int 变量记录 dp[i - 1][j - 1] 的值
     * <p>
     * 注意, 此时 dp[i][j] 表示字符串 text1 在区间 [0, i] 与 字符串 text2 在区间 [0, j] 的公共子串的长度
     * 且该公共子串满足: 公共子串 = text1.substring(i + 1 - length, i + 1) = text2.substring(j + 1 - length, j + 1)
     * 其中 0 <= i < text1.length, 0 <= j < text2.length
     */
    public int longestCommonSubstring(String text1, String text2) {
        int max = 0, dp;

        // 首先计算数组 dp[i][j] 左侧的值
        for (int i = 0; i < text1.length(); i++) {
            // 从新的一条对角线开始计算
            // 必须将 dp 的值置为 0
            dp = 0;

            // 必须满足: 0 <= j + i < text1.length, 0 <= j < text2.length
            for (int j = 0; j < text1.length() - i && j < text2.length(); j++) {
                if (text1.charAt(i + j) == text2.charAt(j)) {
                    dp += 1;
                    max = Math.max(max, dp);
                } else {
                    // 令 i' = i + j
                    // 当 text1.charAt(i') != text2.charAt(j) 时
                    // 说明字符串 text1 在区间 [0, i'] 与 字符串 text2 在区间 [0, j] 的公共子串
                    // 不能满足 公共子串 = text1.substring(i' + 1 - length, i' + 1) = text2.substring(j + 1 - length, j + 1)
                    // 所以 dp[i][j] = 0
                    // 这里必须将 dp 置为 0
                    dp = 0;
                }
            }
        }

        // 计算数组 dp[i][j] 右侧的值
        for (int i = 1; i < text2.length(); i++) {
            dp = 0;

            // 必须满足: 0 <= j + i < text2.length, 0 <= j < text1.length
            for (int j = 0; j < text2.length() - i && j < text1.length(); j++) {
                if (text2.charAt(i + j) == text1.charAt(j)) {
                    dp += 1;
                    max = Math.max(max, dp);
                } else {
                    dp = 0;
                }
            }
        }
        return max;
    }
}
