package problems.leetcode;

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
 * 时间复杂度: O(n), 其中 n 为 s 的长度
 * <p>
 * 空间复杂度: O(S), 其中 S 为字符集大小, 此处 S = 26
 */
public class Num242_Solution1 {

    public static void main(String[] args) {
        Num242_Solution1 instance = new Num242_Solution1();

        // "anagram", "nagaram"
        // "rat", "cat"
        // "ab", "a"
        // "aacc", "ccac"

        System.out.println(instance.isAnagram("rat", "cat"));
    }

    /**
     * 需要注意到字符串 s 和 t 仅包含小写字母
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        // s 和 t 仅包含小写字母
        int[] hashMap = new int[26];

        for (int i = 0; i < s.length(); i++) {
            // int key = s.charAt(i) % hashMap.length;
            int key = s.charAt(i) - 'a';
            ++hashMap[key];
        }
        for (int i = 0; i < t.length(); i++) {
            // int key = t.charAt(i) % hashMap.length;
            int key = t.charAt(i) - 'a';
            --hashMap[key];

            // 注意到, 此时字符串 s 和 t 的长度是相同的
            // 如果 s 和 t 不是互为字母异位词, 那么必然会出现 hashMap[key] < 0 的情况
            if (hashMap[key] < 0) {
                return false;
            }
        }

        return true;
    }
}
