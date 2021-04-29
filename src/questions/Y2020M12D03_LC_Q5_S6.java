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
 */
public class Y2020M12D03_LC_Q5_S6 {

    public static void main(String args[]) {
        Y2020M12D03_LC_Q5_S6 instance = new Y2020M12D03_LC_Q5_S6();

        // babad
        // fffffffffffffffffffggggggggggggggggggggg
        // abzdba
        // cccbbccd
        // cbabxdaad
        // cbabxdaadz
        // abcdxddcba

        System.out.println(instance.longestPalindrome("cccbbccd"));
    }

    /**
     * 遍历整个字符串 s 中每一个字符, 将这个字符放置中心位置并向左右两边展开
     * 如果这个字符左右两边的字符都相等, 由于单个字符是一个回文字符串, 那么这个字符和左右两边的字符组成的字符子串同样是一个回文字符串
     * 此时, 回文子串原本的长度增加 2
     * <p>
     * 根据这个思路, "babcd" 的最长的回文子字符串是 "bab", 长度是奇数, 比较好处理
     * 但是, 对于 "cbb", 其最长的回文子字符串是 "bb", 长度是偶数, 不好处理
     * <p>
     * 如果在每两个字符之间插入一个辅助的字符'#', 可得:
     * babad  ->  b # a # b # a # d
     * 01234  ->  0 1 2 3 4 5 6 7 8
     * <p>
     * cbb  ->  c # b # b
     * 012  ->  0 1 2 3 4
     * <p>
     * 可以发现, 字符比原本的下标增大了两倍, 偶数下标是正常的字符, 而奇数下标是辅助字符
     * 偶数下标 / 2, 可以得到字符在字符串中实际的下标
     * <p>
     * 此时将按 [0, 2 * (n - 1)] 的范围遍历每个字符, 可以轻松处理字符串 s 的最长回文子串是偶数的情况, 例如: "cbb", "cbbcd"
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }

        char[] chars = s.toCharArray();
        String ans = String.valueOf(chars[0]);

        for (int i = 0; i < (2 * s.length() - 1); i++) {
            int len = expandAroundCenter(chars, i);
            if (len > ans.length()) {
                // 当 i % 2 != 0 (len % 2 == 0) 时, beginIndex = i - ((len / 2) * 2 - 1) = i - (len - 1)
                // 当 i % 2 == 0 (len % 2 != 0) 时, beginIndex = i - ((len / 2) * 2) = i - (len - 1)
                // 综上所述, beginIndex = i - (len - 1) 总是成立
                // 必须注意, 此时得出的 index 的取值范围是: 0 <= index < (2 * s.length() - 1)
                // 子串的起始字符的实际下标 index = beginIndex / 2
                ans = s.substring(((i - (len - 1)) >> 1), ((i - (len - 1)) >> 1) + len);
            }
        }
        return ans;
    }

    public int expandAroundCenter(char[] chars, int centre) {
        // ((centre & 1) == 0) same as ((centre % 2) == 0)
        int max = (centre & 1) == 0 ? 1 : 0;
        int left = centre - 1;
        int right = centre + 1;

        while (left >= 0 && (right >> 1) < chars.length) {
            if ((left & 1) == 0) {
                // (left >> 1) same as (left / 2)
                if (chars[(left >> 1)] != chars[(right >> 1)]) {
                    break;
                }
                max += 2;
            }
            left--;
            right++;
        }
        return max;
    }
}
