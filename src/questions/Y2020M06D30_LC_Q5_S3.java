package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * Solution: dynamic programming
 * Reference: https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 */
public class Y2020M06D30_LC_Q5_S3 {

    public static void main(String args[]) {
        // babad
        // fffffffffffffffffffggggggggggg
        // abzdba
        Y2020M06D30_LC_Q5_S3 instance = new Y2020M06D30_LC_Q5_S3();
        System.out.println(instance.longestPalindrome("abzdba"));
    }

    public String longestPalindrome(String s) {
        // 特判
        int n = s.length();
        if (n < 2) {
            return s;
        }

        int maxLen = 1;
        int begin = 0;

        // arr[i][j] 表示 s[i, j] 是否是回文串
        boolean[][] arr = new boolean[n][n];
        char[] charArray = s.toCharArray();

        for (int i = 0; i < n; i++) {
            arr[i][i] = true;
        }
        // 按列初始化
        for (int j = 1; j < n; j++) {
            // 一列上最多有j个元素
            for (int i = 0; i < j; i++) {
                if (charArray[i] != charArray[j]) {
                    arr[i][j] = false;
                } else {
                    if (j - i < 3) {
                        arr[i][j] = true;
                    } else {
                        arr[i][j] = arr[i + 1][j - 1];
                    }
                }

                // 只要 arr[i][j] == true 成立，就表示子串 s[i..j] 是回文，此时记录回文长度和起始位置
                if (arr[i][j] && j - i + 1 > maxLen) {
                    maxLen = j - i + 1;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }
}
