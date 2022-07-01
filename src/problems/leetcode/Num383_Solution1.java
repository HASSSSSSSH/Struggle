package problems.leetcode;

/**
 * https://leetcode.cn/problems/ransom-note/
 * 赎金信
 * <p>
 * 给你两个字符串: ransomNote 和 magazine, 判断 ransomNote 能不能由 magazine 里面的字符构成
 * 如果可以, 返回 true, 否则返回 false
 * magazine 中的每个字符只能在 ransomNote 中使用一次
 * <p>
 * 示例 1:
 * 输入: ransomNote = "a", magazine = "b"
 * 输出: false
 * <p>
 * 示例 2:
 * 输入: ransomNote = "aa", magazine = "ab"
 * 输出: false
 * <p>
 * 示例 3:
 * 输入: ransomNote = "aa", magazine = "aab"
 * 输出: true
 * <p>
 * 提示:
 * 1 <= ransomNote.length, magazine.length <= 10^5
 * ransomNote 和 magazine 由小写英文字母组成
 * <p>
 * Tags: {@link questions.tags.HashTable}, {@link questions.tags.String}, {@link questions.tags.Counting}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#A}
 * <p>
 * 时间复杂度: O(m + n), 其中 m 是字符串 ransomNote 的长度, n 是字符串 magazine 的长度
 * 我们只需要遍历两个字符一次即可
 * <p>
 * 空间复杂度: O(|S|), S 是字符集, 这道题中 S 为全部小写英语字母, 因此 |S| = 26
 */
public class Num383_Solution1 {

    public static void main(String[] args) {
        Num383_Solution1 instance = new Num383_Solution1();

        // "a", "b"
        // "aa", "ab"
        // "aa", "aab"

        System.out.println(instance.canConstruct("aa", "aab"));
    }

    /**
     * 需要注意的是, ransomNote 和 magazine 由小写英文字母组成, 且 magazine 中的每个字符只能在 ransomNote 中使用一次
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        // 用于统计字符串 magazine 中字符的个数
        int[] hashMap = new int[26];

        // 先统计字符串 magazine 中字符的个数
        // 在遍历字符串 ransomNote 时使用 hashMap 能直接判断出 ransomNote 能不能由 magazine 里面的字符构成
        // 可以避免一次 hashMap 遍历
        for (int i = 0; i < magazine.length(); i++) {
            ++hashMap[magazine.charAt(i) - 'a'];
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int key = ransomNote.charAt(i) - 'a';
            --hashMap[key];

            // 如果 hashMap[key] < 0, 说明 ransomNote 不能由 magazine 里面的字符构成
            if (hashMap[key] < 0) {
                return false;
            }
        }

        return true;
    }
}
