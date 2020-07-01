package questions;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Y2020M06D24_LC_Q3_S3 {

    public static void main(String args[]) {
        // ""
        // "abba"
        // "dvdf"
        // "dvdff"
        // "666666"
        // "ppwwkew"
        // "anviaj"
        Y2020M06D24_LC_Q3_S3 instance = new Y2020M06D24_LC_Q3_S3();
        System.out.println(instance.lengthOfLongestSubstring("ppwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        // lower memory usage
        // char[] chars = s.toCharArray();

        int n = s.length();
        HashSet<Character> set = new HashSet<>();

        int max = 0;
        // 注意: 右指针从-1开始
        int right = -1;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                set.remove(s.charAt(i - 1));
            }

            while (right + 1 < n && !set.contains(s.charAt(right + 1))) {
                set.add(s.charAt(right + 1));
                ++right;
            }

            int length = right - i + 1;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
