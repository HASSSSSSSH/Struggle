package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Solution: brute force
 * Reference: https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 * 时间复杂度: O(2^2n * n)
 * 空间复杂度: O(n)
 */
public class Y2020M07D13_LC_Q22_S1 {

    public static void main(String args[]) {
        Y2020M07D13_LC_Q22_S1 instance = new Y2020M07D13_LC_Q22_S1();
        System.out.println(instance.generateParenthesis(5));
    }

    /**
     * 时间复杂度: O(2^2n)
     * <p>
     * 空间复杂度分析: 除了答案数组之外, 我们所需要的空间取决于递归栈的深度,
     * 每一层递归函数需要 O(1) 的空间, 最多递归 2n 层, 因此空间复杂度为 O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        if (n <= 0) {
            combinations.add("");
            return combinations;
        }
        // 结果都存储在combinations当中
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    public void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if (valid(current)) {
                result.add(new String(current));
            }
        } else {
            // 在这个位置的字符, 要么是'(', 要么是')'
            current[pos] = '(';
            generateAll(current, pos + 1, result);

            // 在这个位置的字符, 要么是'(', 要么是')'
            // 直接在pos位置赋值, 相当于先删除pos位置上的值, 再进行赋值
            current[pos] = ')';
            generateAll(current, pos + 1, result);
        }
    }

    /**
     * 时间复杂度: O(n)
     */
    public boolean valid(char[] chars) {
        int balance = 0;
        for (char c : chars) {
            if (c == '(') {
                balance++;
            } else {
                balance--;
            }
            if (balance < 0) {
                return false;
            }
        }
        return balance == 0;
    }
}
