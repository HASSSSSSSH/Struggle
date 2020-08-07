package questions;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 本题与最长公共子字符串相似
 * <p>
 * Solution: dynamic programming
 * Reference: https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/solution/zui-chang-zhong-fu-zi-shu-zu-by-leetcode-solution/
 * improve Y2020M07D02_LC_Q718_S3
 */
public class Y2020M07D02_LC_Q718_S4 {

    public static void main(String args[]) {
        Y2020M07D02_LC_Q718_S4 instance = new Y2020M07D02_LC_Q718_S4();
        // new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}
        System.out.println(instance.findLength(new int[]{1, 2, 3, 2, 1}, new int[]{3, 2, 1, 4, 7}));
    }

    public int findLength(int[] A, int[] B) {
        int n = A.length;
        int m = B.length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int max = 0;
        // (n + 1)(m + 1) - nm = n + m + 1
        // 增加 n + m + 1 的空间
        int[][] arr = new int[n + 1][m + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    // 增加 n + m + 1 的空间, 可以避免计算数组时的越界判断
                    arr[i][j] = arr[i + 1][j + 1] + 1;
                    max = arr[i][j] > max ? arr[i][j] : max;
                }
            }
        }
        return max;
    }
}
