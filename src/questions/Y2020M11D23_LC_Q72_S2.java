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
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Optimization of {@link Y2020M11D20_LC_Q72_S1}
 */
public class Y2020M11D23_LC_Q72_S2 {

    public static void main(String args[]) {
        Y2020M11D23_LC_Q72_S2 instance = new Y2020M11D23_LC_Q72_S2();

        // "horse", "ros"
        // "intention", "execution"
        // "rad", "apple"
        // "dinitrophenylhydrazine", "benzalphenylhydrazone"
        // "abc", ""

        System.out.println(instance.minDistance("horse", "ros"));
    }

    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                // 首先将
                dp[i][j] = -1;
            }
        }
        dp[0][0] = 0;
        return minDistance(dp, word1.length() - 1, word2.length() - 1, word1, word2);
    }

    /**
     * 通过分析, 可以发现 {@link Y2020M11D20_LC_Q72_S1} 这种解法存在重叠子问题
     * 例如:
     * 在计算 minDistance(4, 3) 时, 可能会有这样的一个过程:
     * <p>
     * 1.计算 minDistance(3, 3)  minDistance(4, 2)  minDistance(3, 2)
     * <p>
     * 2.
     * 计算 minDistance(2, 3)  minDistance(3, 2)  minDistance(2, 2)
     * 计算 minDistance(3, 2)  minDistance(4, 1)  minDistance(3, 1)
     * 计算 minDistance(2, 2)  minDistance(3, 1)  minDistance(2, 1)
     * <p>
     * 显而易见, 这种解法会对同一子问题进行重复的计算
     * 使用动态规划(记忆化递归), 可以优化这一过程
     * <p>
     * 动态规划-自顶向下
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
     * 同时, 定义函数 minDistance(i, j, word1, word2), 其中 -1 <= i <= word1.length - 1, -1 <= j <= word2.length - 1
     * 返回 word1 在区间 [0, i] 和 word2 在区间 [0, j] 的最小编辑距离
     * 在这种情况下, 函数 minDistance(i, j, word1, word2) 的值 = dp[i + 1][j + 1]
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
    public int minDistance(int[][] dp, int index1, int index2, String word1, String word2) {
        if (dp[index1 + 1][index2 + 1] != -1) {
            // 当 dp[index1 + 1][index2 + 1] != -1 时, 说明其值有意义
            // minDistance(index1, index2, word1, word2) 的值 = dp[index1 + 1][index2 + 1]
            // 其中 -1 <= index1 <= word1.length - 1, -1 <= index2 <= word2.length - 1
            return dp[index1 + 1][index2 + 1];
        }
        while (index2 >= 0) {
            if (index1 >= 0 && word1.charAt(index1) == word2.charAt(index2)) {
                index1--;
                index2--;
            } else {
                int min = Integer.MAX_VALUE;
                // insert
                min = Math.min(min, minDistance(dp, index1, index2 - 1, word1, word2));

                if (index1 >= 0) {
                    // replace
                    min = Math.min(min, minDistance(dp, index1 - 1, index2 - 1, word1, word2));
                    // delete
                    min = Math.min(min, minDistance(dp, index1 - 1, index2, word1, word2));
                }

                // 将 minDistance(index1, index2, word1, word2) 的结果赋值给 dp[index1 + 1][index2 + 1]
                dp[index1 + 1][index2 + 1] = min + 1;
                return min + 1;
            }
        }

        // 将 minDistance(index1, index2, word1, word2) 的结果赋值给 dp[index1 + 1][index2 + 1]
        dp[index1 + 1][index2 + 1] = index1 >= 0 ? index1 + 1 : 0;

        return dp[index1 + 1][index2 + 1];
    }
}
