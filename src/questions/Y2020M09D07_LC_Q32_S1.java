package questions;

/**
 * https://leetcode-cn.com/problems/longest-valid-parentheses/
 * 最长有效括号
 * 给定一个只包含 '(' 和 ')' 的字符串, 找出最长的包含有效括号的子串的长度
 * <p>
 * Reference: https://leetcode-cn.com/problems/longest-valid-parentheses/solution/zui-chang-you-xiao-gua-hao-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(1)
 */
public class Y2020M09D07_LC_Q32_S1 {

    public static void main(String args[]) {
        Y2020M09D07_LC_Q32_S1 instance = new Y2020M09D07_LC_Q32_S1();
        // 正序无法判断多出的左括号'('
        // String s = "()(()()";

        // 逆序无法判断多出的右括号')'
        // String s = "()())()";

        // 正序逆序都可以判断
        // String s = "()(()())()";

        // 同时多出左括号和右括号, 完全不匹配
        // String s = ")))(((";

        // String s = "())()()(()";
        String s = "()(()()(()";
        System.out.println(instance.longestValidParentheses(s));
    }

    /**
     * 正序遍历可以判断多出的右括号')' , 但无法判断多出的左括号'('
     * 逆序遍历可以判断多出的左括号'(' , 但无法判断多出的右括号')'
     * 只有正序逆序各进行一次遍历, 则可涵盖所有情况
     * 对于同时多出左括号和右括号的情况, 只有完全匹配和完全不匹配两种情况
     */
    public int longestValidParentheses(String s) {
        int res = 0;
        int max = 0;
        int left = 0;
        int right = 0;

        // left to right
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c) {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = 2 * left;
            } else if (left < right) {
                max = 0;
                left = 0;
                right = 0;
            }
            if (max > res) {
                res = max;
            }
        }

        max = 0;
        left = 0;
        right = 0;
        // right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (')' == c) {
                right++;
            } else {
                left++;
            }
            if (left == right) {
                max = 2 * left;
            } else if (left > right) {
                max = 0;
                left = 0;
                right = 0;
            }
            if (max > res) {
                res = max;
            }
        }
        return res;
    }
}
