package questions;

import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/valid-parentheses/
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * <p>
 * 注意空字符串可被认为是有效字符串。
 */
public class Y2020M07D08_LC_Q20_S1 {

    public static void main(String args[]) {
        Y2020M07D08_LC_Q20_S1 instance = new Y2020M07D08_LC_Q20_S1();
        // "()[]{}"
        System.out.println(instance.isValid("()[]{}"));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) {
            return true;
        }
        // 当字符串长度为奇数时, 则至少有一个字符不能匹配, 直接返回false
        if ((s.length() & 0x1) == 1) {
            return false;
        }
        int[] map = new int[128];
        map[')'] = '(';
        map['}'] = '{';
        map[']'] = '[';
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!stack.empty() && stack.peek() == map[c]) {
                stack.pop();
                continue;
            }
            stack.push(c);
        }
        return stack.empty();
    }
}
