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
 * Solution: Expand Around Center
 * <p>
 * 时间复杂度: O(N^2), N 为字符串的长度
 * <p>
 * 空间复杂度: O(1), 只使用常数个临时变量, 与字符串长度无关
 * <p>
 * Different implementation of {@link Y2020M12D03_LC_Q5_S6}
 */
public class Y2020M12D03_LC_Q5_S7 {

    public static void main(String args[]) {
        Y2020M12D03_LC_Q5_S7 instance = new Y2020M12D03_LC_Q5_S7();

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

        char[] chars = s.toCharArray();
        int begin = 0;
        int end = 0;

        for (int i = 0; i < chars.length; i++) {

            // 以字符 chars[i] 为中心, 向左右两边扩展
            int len1 = expandAroundCenter(chars, i, i);

            // 以字符 chars[i] 和字符 chars[i + 1] 的中间作为中心, 向左右两边扩展
            int len2 = expandAroundCenter(chars, i, i + 1);

            int maxLen = Math.max(len1, len2);

            // 注意到, begin 的取值范围是: 0 <= begin < s.length
            // end 的取值范围是: 0 <= end < s.length
            // 所以 当前最长回文子串的长度 = end - begin + 1
            if (maxLen > end - begin + 1) {

                // 当 len1 > len2 时, 此时 maxLen % 2 == 1, begin = i - (maxLen / 2) = i - ((maxLen - 1) / 2)
                // 当 len2 > len1 时, 此时 maxLen % 2 == 0, begin = i - ((maxLen - 1) / 2)
                // 综上所述, begin = i - ((maxLen - 1) / 2) 总是成立
                begin = i - ((maxLen - 1) >> 1);

                // 当 len1 > len2 时, 此时 maxLen % 2 == 1, end = i + ((maxLen - 1) / 2) = i + (maxLen / 2)
                // 当 len2 > len1 时, 此时 maxLen % 2 == 0, end = i + (maxLen / 2)
                // 综上所述, end = i + (maxLen / 2) 总是成立
                end = i + (maxLen >> 1);
            }
        }

        // 注意到, begin 的取值范围是: 0 <= begin < s.length
        // end 的取值范围是: 0 <= end < s.length
        // 所以最长回文子串的长度 maxLen = end - begin + 1
        return s.substring(begin, end + 1);
    }

    public int expandAroundCenter(char[] chars, int left, int right) {
        while (left >= 0 && right < chars.length && chars[left] == chars[right]) {
            left++;
            right--;
        }

        // 此时不满足条件: left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)
        // 指针 left 需要右移一位, 指针 right 需要左移一位
        // 此时字符串 s 在区间 [left, right] 组成的子串才是回文字符串
        // (right - 1) - (left + 1) + 1
        return right - left - 1;
    }
}
