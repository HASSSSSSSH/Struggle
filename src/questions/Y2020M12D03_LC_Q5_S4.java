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
 * 时间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * 空间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * Optimization of {@link Y2020M12D01_LC_Q5_S3}
 */
public class Y2020M12D03_LC_Q5_S4 {

    public static void main(String args[]) {
        Y2020M12D03_LC_Q5_S4 instance = new Y2020M12D03_LC_Q5_S4();

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

        // 事实上, 没必要每次都获得字符子串
        // String ans = s.substring(0, 1);

        // 记下最长回文子串的起始下标和结束下标
        // 只对字符串进行一次裁剪操作
        int begin = 0;
        int end = 0;

        // dp[i][j] > 0 表示字符串 s 在区间 [i, j] 组成的子串是一个回文子串
        // dp[i][j] 表示该回文子串的长度
        int[][] dp = new int[s.length()][s.length()];

        // 事实上, 没必要对子串长度为 1 的情况进行初始化
        // 在长度为 3 的子串计算过程中, 只需要比较第 1 个字符和第 3 个字符
        // 只要第 1 个字符和第 3 个字符是相等的, 那么这个长度为 3 的子串必定是一个回文字符串
        // for (int i = 0; i < s.length(); i++) {
        //     dp[i][i] = 1;
        // }

        // 遍历字符串 s 中每一个长度为 i + 1 的子串
        for (int i = 1; i < s.length(); i++) {
            // 遍历每一个字符串 s 在区间 [j, j + i] 组成的子串
            for (int j = 0; j + i < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    if (i < 3) {
                        // 针对长度为 2 或者 3 的子串
                        // 如果子串的起始字符和结束字符时相等, 那么该子串必定是一个回文字符串
                        dp[j][j + i] = i == 1 ? 2 : 3;
                    } else if (dp[j + 1][j + i - 1] > 0) {
                        dp[j][j + i] = 2 + dp[j + 1][j + i - 1];
                    }

                    if (dp[j][j + i] > end - begin + 1) {
                        // 更新最长的回文子串的起始下标和结束下标
                        begin = j;
                        end = j + i;
                    }
                }

                // 当 s.charAt(j) != s.charAt(j + i) 时, 说明字符串 s 在区间 [j, j + i] 组成的子串不可能是一个回文字符串
                // dp[j][j + i] = 0
            }
        }
        return s.substring(begin, end + 1);
    }
}
