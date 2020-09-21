package questions;

import java.util.ArrayDeque;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串, 找出最长的包含有效括号的子串的长度
 * <p>
 * Solution: Stack
 * Reference: https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2020M09D08_LC_Q32_S2 {

    public static void main(String args[]) {
        Y2020M09D08_LC_Q32_S2 instance = new Y2020M09D08_LC_Q32_S2();
        // String s = "()(()()";

        // String s = "()())()";

        // String s = "()(()())()";

        // String s = ")))(((";

        String s = "())()()(()";

        // String s = "()(()()(()";
        System.out.println(instance.longestValidParentheses(s));
    }

    /**
     * 不太好理解的方法
     * 具体做法是:
     * <p>
     * 始终保持栈底元素为当前已经遍历过的元素中「最后一个没有被匹配的右括号的下标」, 这样的做法主要是考虑了边界条件的处理
     * <p>
     * 栈里其他元素维护左括号的下标:
     * <p>
     * 对于遇到的每个 '(' , 我们将它的下标放入栈中
     * <p>
     * 对于遇到的每个 ')' , 我们 首先弹出 栈顶元素表示匹配了当前右括号:
     * 如果栈为空, 说明当前的右括号为没有被匹配的右括号, 我们将其下标放入栈中来更新我们之前提到的「最后一个没有被匹配的右括号的下标」
     * 如果栈不为空, 当前右括号的下标减去 当前 栈顶元素即为「以该右括号为结尾的最长有效括号的长度」
     * <p>
     * 需要注意的是, 如果一开始栈为空, 第一个字符为左括号的时候我们会将其放入栈中, 这样就不满足提及的「最后一个没有被匹配的右括号的下标」
     * 为了保持统一, 我们在一开始的时候往栈中放入一个值为 -1 的元素
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        stack.addLast(-1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                stack.addLast(i);
            } else if (stack.size() == 1) {
                stack.pollLast();
                stack.addLast(i);
            } else {
                stack.pollLast();
                int max = i - stack.peekLast();
                if (max > res) {
                    res = max;
                }
            }
        }
        return res;
    }
}
