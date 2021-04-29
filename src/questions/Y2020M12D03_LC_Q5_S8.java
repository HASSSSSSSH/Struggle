package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s, 找到 s 中最长的回文子串
 * 你可以假设 s 的最大长度为 1000
 * <p>
 * 实例1:
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案
 * <p>
 * 实例2:
 * 输入: "babad"
 * 输出: "bb"
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.DynamicProgramming}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#E}
 * <p>
 * Solution: {@link questions.tags.DynamicProgramming}
 * <p>
 * Reference: https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
 * <p>
 * 时间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * 空间复杂度: O(N), N 为字符串的长度
 */
public class Y2020M12D03_LC_Q5_S8 {

    public static void main(String args[]) {
        Y2020M12D03_LC_Q5_S8 instance = new Y2020M12D03_LC_Q5_S8();

        // babad
        // fffffffffffffffffffggggggggggggggggggggg
        // abzdba
        // cccbbccd
        // cbabxdaad
        // cbabxdaadz
        // abcdxddcba

        System.out.println(instance.longestPalindrome("cccbbccd"));
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        int start = 0;
        int end = 0;
        String reverse = new StringBuilder(s).reverse().toString();
        int maxLen = 0;

        // using two-dimensional array
        // int[][] arr = new int[s.length()][s.length()];
        // for (int i = 0; i < s.length(); i++) {
        //     for (int j = 0; j < s.length(); j++) {
        //         if (s.charAt(i) == reverse.charAt(j)) {
        //             arr[i][j] = i >= 1 && j >= 1 ? arr[i - 1][j - 1] + 1 : 1;
        //         } else {
        //             arr[i][j] = 0;
        //         }
        //         // think about it!
        //         if (arr[i][j] > maxLen && s.length() - 1 - j == i + 1 - arr[i][j]) {
        //             maxLen = arr[i][j];
        //             end = i;
        //             start = i - maxLen + 1;
        //         }
        //     }
        // }

        // just using one-dimensional array
        int[] arr = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j >= 0; j--) {
                if (s.charAt(i) == reverse.charAt(j)) {
                    arr[j] = j >= 1 ? arr[j - 1] + 1 : 1;
                } else {
                    arr[j] = 0;
                }
                // think about it!
                if (arr[j] > maxLen && s.length() - 1 - j == i + 1 - arr[j]) {
                    maxLen = arr[j];
                    end = i;
                    start = i - maxLen + 1;
                }
            }
        }

        return s.substring(start, end + 1);
    }
}
