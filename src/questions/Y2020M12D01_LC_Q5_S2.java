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
 * Reference: https://leetcode-cn.com/problems/longest-palindromic-substring/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
 * <p>
 * 时间复杂度: O(N^3), N 为字符串的长度
 * 枚举字符串的左边界和右边界, 然后继续验证子串是否是回文子串, 这三种操作都与 N 相关
 * <p>
 * 空间复杂度: O(1), 只使用到常数个临时变量, 与字符串长度无关
 * <p>
 * Result: Accepted
 * <p>
 * Optimization of {@link Y2020M12D01_LC_Q5_S1}
 */
public class Y2020M12D01_LC_Q5_S2 {

    public static void main(String args[]) {
        Y2020M12D01_LC_Q5_S2 instance = new Y2020M12D01_LC_Q5_S2();

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

        int begin = 0;
        int maxLen = 1;

        // s.charAt(int) 每次都会检查数组下标是否越界
        // 同样的, s.substring(int, int) 每次都会检查数组下标是否越界
        // 因此先转换成字符数组, 避免不必要的判断
        char[] chars = s.toCharArray();

        // 事实上, i 没有必要递增到 i = s.length() - 1
        // 所以 i 的取值范围应当是: 0 <= i < s.length() - 1
        for (int i = 0; i < s.length() - 1; i++) {

            // j 应该从 i + 1 开始
            // 注意, 此时 j 的取值范围是: i + 1 <= j < s.length()
            for (int j = i + 1; j < s.length(); j++) {
                // 首先判断字符串长度是否超过目前找到的最长的回文子串的长度
                if ((j + 1 - i) > maxLen
                        && isPalindrome(chars, i, j)) {
                    maxLen = j + 1 - i;
                    begin = i;
                }
            }
        }
        return s.substring(begin, begin + maxLen);
    }

    public boolean isPalindrome(char[] chars, int left, int right) {
        while (left < right) {
            if (chars[left++] != chars[right--]) {
                return false;
            }
        }
        return true;
    }
}
