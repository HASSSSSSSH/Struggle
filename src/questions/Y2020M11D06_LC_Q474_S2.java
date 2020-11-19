package questions;

/**
 * https://leetcode-cn.com/problems/ones-and-zeroes/
 * 一和零
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n
 * 请你找出并返回 strs 的最大子集的大小, 该子集中 最多 有 m 个 0 和 n 个 1
 * 如果 x 的所有元素也是 y 的元素, 集合 x 是集合 y 的 子集
 * <p>
 * 示例 1:
 * 输入: strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
 * 输出: 4
 * 解释:
 * 最多有 5 个 0 和 3 个 1 的最大子集是 {"10", "0001", "1", "0"} , 因此答案是 4
 * 其他满足题意但较小的子集包括 {"0001", "1"} 和 {"10", "1", "0"}
 * {"111001"} 不满足题意, 因为它含 4 个 1 , 大于 n 的值 3
 * <p>
 * 示例 2:
 * 输入: strs = ["10", "0", "1"], m = 1, n = 1
 * 输出: 2
 * 解释: 最大的子集是 {"0", "1"} , 所以答案是 2
 * <p>
 * 提示:
 * 1 <= strs.length <= 600
 * 1 <= strs[i].length <= 100
 * strs[i] 仅由 '0' 和 '1' 组成
 * 1 <= m, n <= 100
 * <p>
 * Solution: Dynamic Programming
 * <p>
 * 时间复杂度: O(mnl), l 为字符串的个数
 * <p>
 * 空间复杂度: O(mnl), l 为字符串的个数
 */
public class Y2020M11D06_LC_Q474_S2 {

    public static void main(String args[]) {
        Y2020M11D06_LC_Q474_S2 instance = new Y2020M11D06_LC_Q474_S2();

        // new String[]{"10", "0001", "111001", "1", "0"}, 5, 3
        // new String[]{"10", "0", "1"}, 1, 1
        // new String[]{"001", "110","0000","0000"}, 9, 2

        System.out.println(instance.findMaxForm(new String[]{"001", "110", "0000", "0000"}, 9, 2));
    }

    /**
     * 动态规划
     * <p>
     * 1.定义状态
     * dp[i][j][k]: 候选字符串数组的前缀子区间 [0, i] 能够满足最多有 j 个 0 和 k 个 1 的最大子集的大小
     * <p>
     * 2.状态转移方程
     * 对于遍历到的字符串 strs[i], 考虑将其 加入 或者 不加入 子集中
     * <p>
     * 如果考虑将字符串 strs[i] 加入到子集, 此时子集的大小 = dp[i - 1][j - costZero][k - costOne] + 1
     * 其中 costZero 为 字符串 strs[i] 中 0 的数量, costOne 为 字符串 strs[i] 中 1 的数量
     * 且 costZero <= j, costOne <= k
     * <p>
     * 如果不考虑将字符串 strs[i] 加入到子集, 此时子集的大小 = dp[i - 1][j][k]
     * <p>
     * 可以得出状态转移方程:
     * dp[i][j][k] = max(dp[i - 1][j][k], dp[i - 1][j - costZero][k - costOne] + 1)
     * <p>
     * 3.思考初始化
     * 状态 dp[i][j][k] 的计算过程依赖于 dp[i - 1][j'][k'] (0 <= j' <= j, 0 <= k' <= k) 的值
     * 因此, 首先需要初始化 dp[0][j][k] (0 <= j <= m,  0 <= k <= n)
     * 假设字符串 strs[0] 有 j 个 0 和 k 个 1
     * 当满足 j <= m, k <= n 时, 有 dp[0][j'][k'] = 1, 其中 j <= j' <= m,  k <= k' <= n
     * <p>
     * 4.思考输出
     * 输出的结果是: 字符串数组在区间 [0, length - 1] 能够满足最多有 m 个 0 和 n 个 1 的最大子集的大小
     * 因此输出应为: dp[length - 1][m][n]
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        if (length == 0 || (m == 0 && n == 0)) {
            return 0;
        }
        int[][][] dp = new int[length][m + 1][n + 1];
        int costZero = 0;
        int costOne = 0;
        for (char c : strs[0].toCharArray()) {
            if (c == '0') {
                costZero++;
            } else {
                costOne++;
            }
        }
        for (int j = costZero; j <= m; j++) {
            for (int k = costOne; k <= n; k++) {
                dp[0][j][k] = 1;
            }
        }

        for (int i = 1; i < strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    costZero = 0;
                    costOne = 0;
                    dp[i][j][k] = dp[i - 1][j][k];
                    for (char c : strs[i].toCharArray()) {
                        if (c == '0') {
                            costZero++;
                        } else {
                            costOne++;
                        }
                    }
                    if (costZero <= j && costOne <= k) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - costZero][k - costOne] + 1);
                    }
                }
            }
        }
        return dp[length - 1][m][n];
    }
}
