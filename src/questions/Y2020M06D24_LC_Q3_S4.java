package questions;

import java.util.HashMap;
import java.util.HashSet;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 * 无重复字符的最长子串
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 参考题解: https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-cshi-xian-/
 */
public class Y2020M06D24_LC_Q3_S4 {

    public static void main(String args[]) {
        // ""
        // "abba"
        // "dvdf"
        // "dvdff"
        // "666666"
        // "ppwwkew"
        // "anviaj"
        // "dvffd"
        Y2020M06D24_LC_Q3_S4 instance = new Y2020M06D24_LC_Q3_S4();
        System.out.println(instance.lengthOfLongestSubstring4("dvdff"));
    }

    /**
     * 通过for循环检查重复字符
     */
    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int max = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            for (int index = start; index < end; index++) {
                if (s.charAt(end) == s.charAt(index)) {
                    start = index + 1;
                    break;
                }
            }
            int length = end - start + 1;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    /**
     * 通过HashSet检查重复字符
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            for (int index = start; index < end; index++) {
                if (s.charAt(end) == s.charAt(index)) {
                    start = index + 1;
                    break;
                }
            }
            int length = end - start + 1;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    /**
     * 通过HashMap检查重复字符
     */
    public int lengthOfLongestSubstring3(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            Integer old;
            if ((old = map.put(s.charAt(end), end)) != null) {
                // 注意: 此时并不是从start~end这个区间中寻找重复字符, 如果更新后的下标(old + 1), 小于当前起始字符的下标, 则不应该更新 (测试用例: "abba")
                start = old + 1 > start ? old + 1 : start;
            }
            int length = end - start + 1;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }

    /**
     * 本题中没有明确说明字符集, 因此可以默认为所有ASCII码在[0, 128)内的字符
     * 通过1个拥有128个元素的整形数组实现简单的HashMap
     */
    public int lengthOfLongestSubstring4(String s) {
        int n = s.length();
        int[] bucket = new int[128];
        for (int i = 0; i < bucket.length; i++) {
            bucket[i] = -1;
        }

        int max = 0;
        int start = 0;
        for (int end = 0; end < n; end++) {
            int old;
            if ((old = bucket[s.charAt(end)]) != -1) {
                // 注意: 此时并不是从start~end这个区间中寻找重复字符, 如果更新后的下标(old + 1), 小于当前起始字符的下标, 则不应该更新 (测试用例: "abba")
                start = old + 1 > start ? old + 1 : start;
            }
            bucket[s.charAt(end)] = end;
            int length = end - start + 1;
            if (length > max) {
                max = length;
            }
        }
        return max;
    }
}
