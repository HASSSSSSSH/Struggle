package questions;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class Y2020M06D23_LC_Q3_S2 {

    public static void main(String args[]) {
        // ""
        // "abba"
        // "dvdf"
        // "dvdff"
        // "666666"
        // "ppwwkew"
        // "anviaj"
        // "dvffd"
        Y2020M06D23_LC_Q3_S2 instance = new Y2020M06D23_LC_Q3_S2();
        System.out.println(instance.lengthOfLongestSubstring("dvffd"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int max = 0;
        // key -> 字符, value -> 字符在数组中的下标
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0;
        int start = 0;
        for (; i < s.length(); i++) {
            Integer old;
            if ((old = map.put(String.valueOf(s.charAt(i)), i)) != null) {
                // 注意: 此时必须更新子串的最大长度 (测试用例: "dvffd")
                max = i - start > max ? i - start : max;

                // 当遇到重复字符时, 更新起始字符的下标
                // 注意: 如果更新后的下标(old + 1), 小于当前起始字符的下标, 则不能更新起始字符的下标 (测试用例: "abba")
                start = old + 1 > start ? old + 1 : start;
            }
        }
        // 在遍历完成后必须重新计算最大值
        max = i - start > max ? i - start : max;
        return max;
    }
}
