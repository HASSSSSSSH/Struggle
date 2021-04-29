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
 * Optimization of {@link Y2020M12D03_LC_Q5_S4}
 */
public class Y2020M12D03_LC_Q5_S5 {

    public static void main(String args[]) {
        Y2020M12D03_LC_Q5_S5 instance = new Y2020M12D03_LC_Q5_S5();

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

        int begin = 0;
        int end = 0;

        // 事实上, 动态规划数组没必要定义为 int 类型
        // boolean 类型也能满足要求
        // 此时 dp[i][j] 表示字符串 s 在区间 [i, j] 组成的子串是不是一个回文字符串
        boolean[][] dp = new boolean[s.length()][s.length()];

        // 遍历字符串 s 中每一个长度为 i + 1 的子串
        for (int i = 1; i < s.length(); i++) {
            // 遍历每一个字符串 s 在区间 [j, j + i] 组成的子串
            for (int j = 0; j + i < s.length(); j++) {
                if (s.charAt(j) == s.charAt(j + i)) {
                    // same as (dp[j][j + i] = i < 3 || dp[j + 1][j + i - 1])
                    // if (i < 3) {
                    //     // 针对长度为 2 或者 3 的子串
                    //     // 如果子串的起始字符和结束字符时相等, 那么该子串必定是一个回文字符串
                    //     // dp[j][j + i] = i == 1 ? 2 : 3;
                    //     dp[j][j + i] = true;
                    // } else {
                    //     dp[j][j + i] = dp[j + 1][j + i - 1];
                    // }

                    dp[j][j + i] = i < 3 || dp[j + 1][j + i - 1];

                    // 判断回文子串的长度 是否大于 已知最长的回文子串的长度
                    // (i + 1) > (end - begin + 1)
                    if (dp[j][j + i] && i > end - begin) {
                        // 更新最长的回文子串的起始下标和结束下标
                        begin = j;
                        end = j + i;
                    }
                }
            }
        }
        return s.substring(begin, end + 1);
    }
}
