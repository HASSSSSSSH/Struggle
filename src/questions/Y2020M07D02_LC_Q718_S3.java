package questions;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 本题与最长公共子字符串相似
 * <p>
 * Solution: dynamic programming
 * Reference: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
 */
public class Y2020M07D02_LC_Q718_S3 {

    public static void main(String args[]) {
        Y2020M07D02_LC_Q718_S3 instance = new Y2020M07D02_LC_Q718_S3();
        // new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}
        System.out.println(instance.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    /**
     * 改进暴力解法, 使得任意一对 A[i] 和 B[j] 都只比较一次
     * 如果 A[i] == B[j], 那么我们知道 A[i:] 与 B[j:] 的最长公共前缀为 A[i + 1:] 与 B[j + 1:] 的最长公共前缀的长度加1
     * 否则 A[i:] 与 B[j:] 的最长公共前缀为0
     * <p>
     * 这样我们就可以提出动态规划的解法: 令 dp[i][j] 表示 A[i:] 和 B[j:] 的最长公共前缀, 那么答案即为所有 dp[i][j] 中的最大值
     * 如果 A[i] == B[j], 那么 dp[i][j] = dp[i + 1][j + 1] + 1, 否则 dp[i][j] = 0
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int max = 0;
        int[][] arr = new int[n][m];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    // (i + 1 < n && j + 1 < m) 避免数组越界
                    arr[i][j] = i + 1 < n && j + 1 < m ? (arr[i + 1][j + 1] + 1) : 1;
                    max = arr[i][j] > max ? arr[i][j] : max;
                }
            }
        }
        return max;
    }
}
