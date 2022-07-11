package problems.leetcode;

/**
 * https://leetcode.cn/problems/reverse-string-ii/
 * 反转字符串 II
 * <p>
 * 给定一个字符串 s 和一个整数 k, 从字符串开头算起, 每计数至 2k 个字符, 就反转这 2k 字符中的前 k 个字符
 * 如果剩余字符少于 k 个, 则将剩余字符全部反转
 * 如果剩余字符小于 2k 但大于或等于 k 个, 则反转前 k 个字符, 其余字符保持原样
 * <p>
 * 示例 1:
 * 输入: s = "abcdefg", k = 2
 * 输出: "bacdfeg"
 * <p>
 * 示例 2:
 * 输入: s = "abcd", k = 2
 * 输出: "bacd"
 * <p>
 * 提示:
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.TwoPointers}
 * <p>
 * Solution: {@link questions.tags.Simulation}, {@link questions.tags.TwoPointers}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#B}
 * <p>
 * 时间复杂度: O(N), 其中 N 是字符串 s 的长度
 * <p>
 * 空间复杂度: O(1) 或 O(N), 取决于使用的语言中字符串类型的性质
 * 如果字符串是可修改的, 那么我们可以直接在原字符串上修改, 空间复杂度为 O(1)
 * 否则需要使用 O(N) 的空间将字符串临时转换为可以修改的数据结构 (例如数组), 空间复杂度为 O(N)
 */
public class Num541_Solution1 {

    public static void main(String[] args) {
        Num541_Solution1 instance = new Num541_Solution1();

        // "abcdefg", 2
        // "abcd", 2
        // "abc", 4

        System.out.println(instance.reverseStr("abc", 4));
    }

    /**
     * 题目的意思可以概括为: 每 2k 个字符反转前 k 个字符, 如果剩余字符不足 k 个, 则反转所有剩余字符
     */
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();

        int index = 0;
        while (index < chars.length) {
            int left = index;
            int right = Math.min(index + k - 1, chars.length - 1);

            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
            }

            index += 2 * k;
        }

        return new String(chars);
    }
}
