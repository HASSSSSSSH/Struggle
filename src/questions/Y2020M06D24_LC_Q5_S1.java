package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * Solution: dynamic programming
 */
public class Y2020M06D24_LC_Q5_S1 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffggggggggggg
        // abzdba
        Y2020M06D24_LC_Q5_S1 instance = new Y2020M06D24_LC_Q5_S1();
        System.out.println(instance.longestPalindrome("abzdba"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] arr = new boolean[n][n];
        int start = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            // (i + 1)实际上代表了子串的长度
            for (int j = 0; j < n - i; j++) {
                // Max J = n - i - 1
                // Max J + i = n - 1 < n
                if (i == 0) {
                    arr[j][j] = true;
                } else if (i < 3) {
                    if (s.charAt(j) == s.charAt(j + i)) {
                        arr[j][j + i] = true;
                    } else {
                        arr[j][j + i] = false;
                    }
                } else {
                    if (arr[j + 1][j + i - 1] && s.charAt(j) == s.charAt(j + i)) {
                        arr[j][j + i] = true;
                    } else {
                        arr[j][j + i] = false;
                    }
                }
                if (arr[j][j + i] && (i + 1) > (end - start)) {
                    start = j;
                    // j < n - i
                    end = j + i + 1;
                }
            }
        }
        return s.substring(start, end);
    }
}
