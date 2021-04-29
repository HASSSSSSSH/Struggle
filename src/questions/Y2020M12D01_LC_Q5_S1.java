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
 * Solution: {@link questions.tags.BruteForce}
 * <p>
 * 时间复杂度: O(N^3), N 为字符串的长度
 * 枚举字符串的左边界和右边界, 然后继续验证子串是否是回文子串, 这三种操作都与 N 相关
 * <p>
 * 空间复杂度: O(1), 只使用到常数个临时变量, 与字符串长度无关
 * <p>
 * Result: Time Limit Exceeded
 */
public class Y2020M12D01_LC_Q5_S1 {

    public static void main(String args[]) {
        Y2020M12D01_LC_Q5_S1 instance = new Y2020M12D01_LC_Q5_S1();

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
        String answer = "";

        // 遍历字符串中所有的子串
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub) > answer.length()) {
                    answer = sub;
                }
            }
        }
        return answer;
    }

    public int isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return 0;
            }
        }
        return s.length();
    }
}
