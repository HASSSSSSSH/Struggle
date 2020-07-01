package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * Solution: dynamic programming
 * Simplify Y2020M06D29_LC_Q5_S2
 */
public class Y2020M06D30_LC_Q5_S4 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffggggggggggg
        // abzdba
        Y2020M06D30_LC_Q5_S4 instance = new Y2020M06D30_LC_Q5_S4();
        System.out.println(instance.longestPalindrome("abzdba"));
    }

    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        boolean[][] arr = new boolean[n][n];
        // 事实上没必要初始化arr[i][i], 因为当子串长度为3时, 不需要通过arr[j + 1][j + i - 1]判断是否是回文字符串
        // for (int i = 0; i < n; i++) {
        //     arr[i][i] = true;
        // }
        int start = 0;
        int end = 1;
        for (int i = 1; i < n; i++) {
            // (i + 1)实际上代表了子串的长度
            for (int j = 0; j < n - i; j++) {
                // 当子串长度 <= 3时, 只需判断左右两边的字符是否相等
                if ((i < 3 || arr[j + 1][j + i - 1]) && s.charAt(j) == s.charAt(j + i)) {
                    arr[j][j + i] = true;
                    if ((i + 1) > (end - start)) {
                        start = j;
                        end = j + i + 1;
                    }
                }
                // 初始值就是false, 没必要重复设置false
                // else {
                //     arr[j][j + i] = false;
                // }

                // if (s.charAt(j) != s.charAt(j + i)) {
                //     arr[j][j + i] = false;
                // } else {
                //     arr[j][j + i] = i < 3 || arr[j + 1][j + i - 1];
                //     if (arr[j][j + i] && (i + 1) > (end - start)) {
                //         start = j;
                //         end = j + i + 1;
                //     }
                // }
            }
        }
        return s.substring(start, end);
    }
}
