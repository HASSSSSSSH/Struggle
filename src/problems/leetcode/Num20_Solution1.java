package problems.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 * 有效的括号
 * <p>
 * 给定一个只包括 '(', ')', '{', '}', '[', ']' 的字符串 s, 判断字符串是否有效
 * 有效字符串需满足:
 * 左括号必须用相同类型的右括号闭合
 * 左括号必须以正确的顺序闭合
 * 每个右括号都有一个对应的相同类型的左括号
 * <p>
 * 示例 1:
 * 输入: s = "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: s = "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: s = "(]"
 * 输出: false
 * <p>
 * 提示:
 * 1 <= s.length <= 10^4
 * s 仅由括号 '()[]{}' 组成
 * <p>
 * Tags: {@link questions.tags.String}, {@link questions.tags.Stack}
 * <p>
 * Solution: {@link questions.tags.Stack}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#C}
 * <p>
 * 时间复杂度: O(n), 其中 n 是字符串 s 的长度
 * <p>
 * 空间复杂度: O(n), 其中 n 是字符串 s 的长度
 * 在最坏的情况下, 栈的大小将是字符串 s 的长度
 */
public class Num20_Solution1 {

    public static void main(String[] args) {
        Num20_Solution1 instance = new Num20_Solution1();

        // "()"
        // "()[]{}"
        // "(]"

        System.out.println(instance.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        // 当字符串长度为奇数时, 则至少有一个字符不能匹配, 直接返回false
        if ((s.length() & 0x1) == 1) {
            return false;
        }

        int[] map = new int[128];
        map[')'] = '(';
        map['}'] = '{';
        map[']'] = '[';

        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.isEmpty() && map[c] == stack.peek()) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }

        return stack.isEmpty();
    }
}
