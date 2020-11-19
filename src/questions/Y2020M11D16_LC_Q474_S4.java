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
 * 空间复杂度: O(mn)
 * <p>
 * Optimization of {@link Y2020M11D16_LC_Q474_S3}
 */
public class Y2020M11D16_LC_Q474_S4 {

    public static void main(String args[]) {
        Y2020M11D16_LC_Q474_S4 instance = new Y2020M11D16_LC_Q474_S4();

        // new String[]{"10", "0001", "111001", "1", "0"}, 5, 3
        // new String[]{"10", "0", "1"}, 1, 1
        // new String[]{"001", "110","0000","0000"}, 9, 2

        System.out.println(instance.findMaxForm(new String[]{"001", "110", "0000", "0000"}, 9, 2));
    }

    /**
     * 优化空间
     * <p>
     * 事实上, 在 dp[i][m][n] 的计算过程中
     * 只参考上一行 dp[i - 1][m'][n'], m' ∈ [0, m], n' ∈ [0, n] 的结果
     * 因此可以使用滚动数组, 只记录两行结果
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int length = strs.length;
        if (length == 0 || (m == 0 && n == 0)) {
            return 0;
        }
        int[][][] dp = new int[2][m + 1][n + 1];

        // 将第 0 个字符串当为一个空串, 从 i = 1 开始, 遍历字符串数组中的每一个字符串
        // 注意, i <= strs.length
        for (int i = 1; i <= strs.length; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {
                    // 不考虑字符串 strs[i - 1] 时, 能得到的最大子集的大小
                    dp[i & 1][j][k] = dp[(i - 1) & 1][j][k];

                    // 由于将第 0 个字符串当为一个空串
                    // dp[0][j][k] = 0 (0 <= j <= m,  0 <= k <= n)
                    // 所以这里应该遍历的是第 i - 1 个字符串
                    String s = strs[i - 1];
                    int[] count = countZeroesOnes(s);
                    if (count[0] <= j && count[1] <= k) {
                        dp[i & 1][j][k] = Math.max(1 + dp[(i - 1) & 1][j - count[0]][k - count[1]], dp[i & 1][j][k]);
                    }
                }
            }
        }
        return dp[length & 1][m][n];
    }

    public int[] countZeroesOnes(String s) {
        int[] count = new int[2];
        for (int i = 0; i < s.length(); i++) {
            // 在ASCII码表中, 字符'0'的十进制值为48
            // 那么, '0' - '0' = 0, '1' - '0' = 1
            count[s.charAt(i) - '0']++;
        }
        return count;
    }
}
