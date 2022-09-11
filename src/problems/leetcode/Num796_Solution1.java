package problems.leetcode;

/**
 * https://leetcode.cn/problems/rotate-string/
 * 旋转字符串
 * <p>
 * 给定两个字符串, s 和 goal
 * 如果在若干次旋转操作之后, s 能变成 goal, 那么返回 true
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边
 * 例如, 若 s = 'abcde', 在旋转一次之后结果就是 'bcdea'
 * <p>
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.StringMatching}
 * <p>
 * Solution: {@link questions.tags.Simulation}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: O(n^2), 其中 n 是字符串 s 的长度, 我们需要双重循环来判断
 * <p>
 * 空间复杂度: O(1)
 */
public class Num796_Solution1 {

    public static void main(String[] args) {
        Num796_Solution1 instance = new Num796_Solution1();

        // "abcde", "cdeab"
        // "abcde", "abced"

        System.out.println(instance.rotateString("abcde", "cdeab"));
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        int n = s.length();
        outer:
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (goal.charAt(j) != s.charAt((j + i) % n)) {
                    continue outer;
                }
            }
            return true;
        }

        return false;
    }
}
