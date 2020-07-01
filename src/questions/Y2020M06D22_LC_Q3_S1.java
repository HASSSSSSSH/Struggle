package questions;

import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Y2020M06D22_LC_Q3_S1 {

    public static void main(String args[]) {
        // ""
        // "abba"
        // "dvdf"
        // "dvdff"
        // "666666"
        // "ppwwkew"
        // "anviaj"
        Y2020M06D22_LC_Q3_S1 instance = new Y2020M06D22_LC_Q3_S1();
        System.out.println(instance.lengthOfLongestSubstring("anviaj"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>(s.length());

        int right = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                set.remove(chars[i - 1]);
            }
            set.add(chars[i]);
            if (right < i) {
                right = i;
            }
            int length = right - i + 1;
            while ((right + 1) < s.length() && !set.contains(chars[right + 1])) {
                set.add(chars[++right]);
                ++length;
            }
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
