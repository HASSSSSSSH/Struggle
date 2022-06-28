package problems.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/find-common-characters/
 * 查找共用字符
 * <p>
 * 给你一个字符串数组 words
 * 请你找出所有在 words 的每个字符串中都出现的共用字符 (包括重复字符), 并以数组形式返回
 * 你可以按 任意顺序 返回答案
 * <p>
 * 示例 1:
 * 输入: words = ["bella", "label", "roller"]
 * 输出: ["e","l","l"]
 * <p>
 * 示例 2:
 * 输入: words = ["cool", "lock", "cook"]
 * 输出: ["c","o"]
 * <p>
 * 提示:
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 100
 * words[i] 由小写英文字母组成
 * <p>
 * Tags: {@link questions.tags.Array}, {@link questions.tags.HashTable}, {@link questions.tags.String}
 * <p>
 * Solution: {@link questions.tags.HashTable}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#F}
 * <p>
 * 时间复杂度: O(n * (m + ∣Σ∣)), 其中 n 是数组 words 的长度 (即字符串的数目), m 是字符串的平均长度, Σ 为字符集
 * 在本题中字符集为所有小写字母, ∣Σ∣ = 26
 * <p>
 * 遍历所有字符串并计算 otherStrHashMap 的时间复杂度为 O(nm)
 * 使用 otherStrHashMap 更新 hashMap 的时间复杂度为 O(n * ∣Σ∣)
 * 由于最终答案包含的字符个数不会超过最短的字符串长度, 因此构造最终答案的时间复杂度为 O(m + ∣Σ∣), 这一项在渐进意义上小于前二者, 可以忽略
 * <p>
 * 空间复杂度: O(∣Σ∣), 这里只计算存储答案之外的空间
 * 我们使用了数组 hashMap 和 otherStrHashMap, 它们的长度均为 ∣Σ∣
 * <p>
 * Reference: https://github.com/youngyangyang04/leetcode-master/blob/master/problems/1002.%E6%9F%A5%E6%89%BE%E5%B8%B8%E7%94%A8%E5%AD%97%E7%AC%A6.md
 */
public class Num1002_Solution1 {

    public static void main(String[] args) {
        Num1002_Solution1 instance = new Num1002_Solution1();

        // new String[]{"bella", "label", "roller"}
        // new String[]{"cool", "lock", "cook"}

        System.out.println(instance.commonChars(new String[]{"cool", "lock", "cook"}));
    }

    public List<String> commonChars(String[] words) {
        List<String> ans = new ArrayList<>();

        // 注意到 words[i] 由小写英文字母组成, 所以初始大小为 26
        // 用于统计在 words 的每个字符串中共用字符的出现次数
        int[] hashMap = new int[26];

        // 首先统计第一个字符串所有字符的出现次数
        for (int i = 0; i < words[0].length(); i++) {
            ++hashMap[words[0].charAt(i) - 'a'];
        }

        // 统计除第一个字符串外, 其他字符串所有字符的出现次数
        for (int i = 1; i < words.length; i++) {
            // 用于统计字符串 words[i] 中所有字符的出现次数
            int[] otherStrHashMap = new int[26];

            for (int j = 0; j < words[i].length(); j++) {
                otherStrHashMap[words[i].charAt(j) - 'a']++;
            }

            // 如果某个字符属于共用字符, 那么这个字符作为共用字符出现的次数不可能大于 hashMap 当前统计的次数
            // 比较 hashMap[k] 和 otherStrHashMap[k], 取较小值, 然后更新 hashMap
            // Math.min(hashMap[k], otherStrHashMap[k]) 就是字符 ((char) (k + 'a')) 作为共用字符出现的次数
            for (int k = 0; k < hashMap.length; k++) {
                hashMap[k] = Math.min(hashMap[k], otherStrHashMap[k]);
            }
        }

        // 遍历 hashMap
        for (int i = 0; i < hashMap.length; i++) {
            // 如果 hashMap[i] > 0, 说明字符 ((char) (i + 'a')) 在每个字符串中都出现了 hashMap[i] 次
            while (hashMap[i] > 0) {
                ans.add(String.valueOf((char) (i + 'a')));
                hashMap[i]--;
            }
        }

        return ans;
    }
}
