package questions;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-substring/
 * 最长回文子串
 * 给定一个字符串 s，找到 s 中最长的回文子串。
 * 你可以假设 s 的最大长度为 1000。
 * <p>
 * Solution: 中心扩展法
 */
public class Y2020M07D01_LC_Q5_S6 {

    public static void main(String args[]) {
        // babad
        // cbbd
        // fffffffffffffffffffggggggggggg
        // abzdba
        // abcda
        // a
        Y2020M07D01_LC_Q5_S6 instance = new Y2020M07D01_LC_Q5_S6();
        System.out.println(instance.longestPalindrome("abcda"));
    }

    /**
     * 单个字符是一个回文字符串
     * 那么遍历整个字符串中每一个字符, 将这个字符放置中心位置并向左右两边展开
     * 如果左右两边的字符相等, 那么和这两个字符组成的字符串同样是一个回文字符串, 此时原本的长度增加2
     * 按照这个逻辑, "babcd"的回文子字符串是"bab", 长度是奇数, 比较好处理
     * 但是, 对于"cbb", 其回文子字符串是"bb", 长度是偶数, 不好处理
     * <p>
     * 如果在每两个字符之间插入一个辅助的字符'#', 可得:
     * babad  ->  b # a # b # a # d
     * 01234  ->  0 1 2 3 4 5 6 7 8
     * <p>
     * cbb  ->  c # b # b
     * 012  ->  0 1 2 3 4
     * <p>
     * 观察到字符比原本的下标增大了两倍, 偶数下标是正常的字符, 而奇数下标是辅助字符
     * 偶数下标 / 2, 可以得到字符在字符串中实际的下标
     * 此时将按[0, 2 * (n - 1)]的范围遍历每个字符, 可以轻松处理"cbb", "cbbd"这种字符
     */
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) {
            return s;
        }
        int start = 0;
        int maxLen = 1;

        // i的范围是[0, 2 * (n - 1)]
        for (int i = 0; i < (2 * n - 1); i++) {
            int left = i - 1;
            int right = i + 1;
            // 偶数下标代表正常的字符, 长度加1
            int length = i % 2 == 0 ? 1 : 0;
            // 左右展开
            while (left >= 0 && right <= 2 * (n - 1)) {
                // 如果i是奇数, 那么(i - 1), (i + 1)必定是偶数, 反义亦然
                // 判断left的奇偶性就可以了
                if (left % 2 == 0) {
                    // 偶数下标 / 2, 可以得到字符在字符串中实际的下标
                    if (s.charAt(left / 2) != s.charAt(right / 2)) {
                        // NOTE: 当两边字符不相等时, 终结循环
                        break;
                    }
                    // 两边字符相等, 长度增加2
                    length += 2;
                    if (length > maxLen) {
                        start = left / 2;
                        maxLen = length;
                    }
                }
                left--;
                right++;
            }
        }
        return s.substring(start, start + maxLen);
    }
}
