package questions;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 本题与最长公共子字符串相似
 * <p>
 * Solution: dynamic programming
 */
public class Y2020M07D01_LC_Q718_S1 {

    public static void main(String args[]) {
        Y2020M07D01_LC_Q718_S1 instance = new Y2020M07D01_LC_Q718_S1();
        // new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}
        System.out.println(instance.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    /**
     * 改进暴力解法, 使得任意一对 A[i] 和 B[j] 都只比较一次
     * 如果 A[i] == B[j], 那么我们知道 A[:i] 与 B[:j] 的最长公共后缀为 A[:i - 1] 与 B[:j - 1] 的最长公共后缀的长度加1
     * 否则 A[:i] 与 B[:j] 的最长公共后缀为0
     * <p>
     * 这样我们就可以提出动态规划的解法: 令 dp[i][j] 表示 A[:i] 和 B[:j] 的最长公共后缀, 那么答案即为所有 dp[i][j] 中的最大值
     * 如果 A[i] == B[j], 那么 dp[i][j] = dp[i - 1][j - 1] + 1, 否则 dp[i][j] = 0
     * 需要注意避免数组越界异常
     */
    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int max = 0;
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i] == B[j]) {
                    arr[i][j] = i - 1 >= 0 && j - 1 >= 0 ? (arr[i - 1][j - 1] + 1) : 1;
                    if (arr[i][j] > max) {
                        max = arr[i][j];
                    }
                }
                // 初始值为0, 没必要再次赋值
                // else {
                //     arr[i][j] = 0;
                // }
            }
        }
        return max;
    }
}
