package questions;

/**
 * https://leetcode-cn.com/problems/maximum-length-of-repeated-subarray/
 * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
 * <p>
 * 本题与最长公共子字符串相似
 * <p>
 * Solution: brute force
 */
public class Y2020M07D02_LC_Q718_S2 {

    public static void main(String args[]) {
        Y2020M07D02_LC_Q718_S2 instance = new Y2020M07D02_LC_Q718_S2();
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
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int k = 0;
                while ((i + k) < n && (j + k) < m && A[i + k] == B[j + k]) {
                    k++;
                }
                if (k > max) {
                    max = k;
                }

                // can be simplified!!!
                // int p1 = i;
                // int p2 = j;
                // int length = 0;
                // while (p1 < n && p2 < m && A[p1] == B[p2]) {
                //     length++;
                //     max = length > max ? length : max;
                //     p1++;
                //     p2++;
                // }
            }
        }
        return max;
    }
}
