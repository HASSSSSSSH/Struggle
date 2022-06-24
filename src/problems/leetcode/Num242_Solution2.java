package problems.leetcode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/valid-anagram/
 * 有效的字母异位词
 * <p>
 * 给定两个字符串 s 和 t, 编写一个函数来判断 t 是否是 s 的字母异位词
 * 注意: 若 s 和 t 中每个字符出现的次数都相同, 则称 s 和 t 互为字母异位词
 * <p>
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length, t.length <= 5 * 10^4
 * s 和 t 仅包含小写字母
 * <p>
 * 进阶: 考虑输入字符串包含 unicode 字符的情况
 * <p>
 * Tags: {@link questions.tags.HashTable}, {@link questions.tags.String}, {@link questions.tags.Sorting}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: ??
 * <p>
 * 空间复杂度: ??
 * <p>
 * Reference: https://leetcode.cn/problems/valid-anagram/solution/you-xiao-de-zi-mu-yi-wei-ci-by-leetcode-solution/
 */
public class Num242_Solution2 {

    public static void main(String[] args) {
        Num242_Solution2 instance = new Num242_Solution2();

        // "anagram", "nagaram"
        // "rat", "cat"
        // "ab", "a"
        // "aacc", "ccac"

        System.out.println(instance.isAnagram("rat", "cat"));
    }

    /**
     * 考虑输入字符串包含 unicode 字符的情况
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char key = t.charAt(i);
            int val = hashMap.getOrDefault(key, 0) - 1;
            hashMap.put(key, val);

            // 注意到, 此时字符串 s 和 t 的长度是相同的
            // 如果 s 和 t 不是互为字母异位词, 那么必然会出现 val < 0 的情况
            if (val < 0) {
                return false;
            }
        }

        return true;
    }
}
