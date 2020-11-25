package questions;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 编辑距离
 * 给你两个单词 word1 和 word2, 请你计算出将 word1 转换成 word2 所使用的最少操作数
 * 你可以对一个单词进行如下三种操作:
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 示例 1:
 * 输入: word1 = "horse", word2 = "ros"
 * 输出: 3
 * 解释:
 * horse -> rorse (将 'h' 替换为 'r')
 * rorse -> rose (删除 'r')
 * rose -> ros (删除 'e')
 * <p>
 * 示例 2:
 * 输入: word1 = "intention", word2 = "execution"
 * 输出: 5
 * 解释:
 * intention -> inention (删除 't')
 * inention -> enention (将 'i' 替换为 'e')
 * enention -> exention (将 'n' 替换为 'x')
 * exention -> exection (将 'n' 替换为 'c')
 * exection -> execution (插入 'u')
 * <p>
 * 提示:
 * 0 <= word1.length, word2.length <= 500
 * word1 和 word2 由小写英文字母组成
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * Reference: https://labuladong.github.io/ebook/%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92%E7%B3%BB%E5%88%97/%E7%BC%96%E8%BE%91%E8%B7%9D%E7%A6%BB.html
 * <p>
 * 时间复杂度: O(mn), 其中 m 为 word1 的长度, n 为 word2 的长度
 * <p>
 * 空间复杂度: O(mn), 其中 m 为 word1 的长度, n 为 word2 的长度
 * 我们需要大小为 O(mn) 的数组来记录状态值
 */
public class Y2020M11D24_LC_Q72_S3 {

    public static void main(String args[]) {
        Y2020M11D24_LC_Q72_S3 instance = new Y2020M11D24_LC_Q72_S3();

        // "horse", "ros"
        // "intention", "execution"
        // "rad", "apple"
        // "dinitrophenylhydrazine", "benzalphenylhydrazone"
        // "abc", ""

        System.out.println(instance.minDistance("rad", "apple"));
    }

    /**
     * 动态规划-自底向上
     * <p>
     * 1.定义状态
     * dp[i][j] (0 <= i <= word1.length, 0 <= j <= word2.length)
     * 之所以这样定义 i & j 的取值范围, 是为了满足 dp[i][0] = i, dp[j][0] = j, 使得状态方程总是成立
     * 由此在计算 dp[i][1], dp[1][j] 时, 可以避免分类讨论
     * <p>
     * 事实上, 将 word1, word2 在区间 [0, -1] 当成是 空字符串
     * dp[i][0] 表示将 word1 在区间 [0, i - 1] 转换成 空字符串 所使用的最少操作数
     * dp[0][j] 表示将 空字符串 转换成 word2 在区间 [0, j - 1] 所使用的最少操作数
     * <p>
     * 因此, dp[i][j] 表示将 word1 在区间 [0, i - 1] 转换成 word2 在区间 [0, j - 1] 所使用的最少操作数
     * <p>
     * 2.状态转移方程
     * 经过之前的讨论, 可得出结论:
     * <p>
     * 令 i' = i - 1, j' = j - 1 因此 -1 <= i' <= word1.length - 1, -1 <= j' <= word2.length - 1
     * <p>
     * 当 word1[i'] == word2[j'] 时, dp[i][j] = dp[i - 1][j - 1]
     * <p>
     * 当 word1[i'] != word2[j'] 时, dp[i][j] = 1 + min(dp(i, j - 1), dp(i - 1, j), dp(i - 1, j - 1))
     * <p>
     * 3.思考初始化
     * 为了在计算 dp[i][1], dp[1][j] (0 <= i <= word1.length, 0 <= j <= word2.length) 时, 可以避免分类讨论
     * 同时使得状态方程总是成立, 应当初始化 dp[i][0], dp[j][0]
     * 使得 dp[i][0] = i, 其中 0 <= i <= word1.length
     * 使得 dp[0][j] = j, 其中 0 <= j <= word2.length
     * <p>
     * 4.思考输出
     * 输出的结果是: 将 word1 在区间 [0, word1.length - 1] 转换成 word2 在区间 [0, word2.length - 1] 所使用的最少操作数
     * 因此输出 dp[word1.length][word2.length]
     */
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];

        // 初始化 dp[i][0], dp[j][0], 使得状态方程成立
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // dp[i][j] 表示将 word1 在区间 [0, i - 1] 转换成 word2 在区间 [0, j - 1] 所使用的最少操作数
                    // 因此这里比较的两个字符分别是: word1[i - 1] 和 word2[j - 1]
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int min = dp[i - 1][j];
                    min = Math.min(dp[i][j - 1], min);
                    min = Math.min(dp[i - 1][j - 1], min);
                    dp[i][j] = min + 1;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
