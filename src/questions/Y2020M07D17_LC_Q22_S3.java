package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Solution: Depth First Search (backtrace)
 * Reference: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 时间复杂度: O(4^n / n^(1/2)), 类比 Y2020M07D14_LC_Q22_S2
 * 空间复杂度: O(n)
 */
public class Y2020M07D17_LC_Q22_S3 {

    public static void main(String args[]) {
        Y2020M07D17_LC_Q22_S3 instance = new Y2020M07D17_LC_Q22_S3();
        System.out.println(instance.generateParenthesis(2));
    }

    /**
     * 时间复杂度分析: 类比 Y2020M07D14_LC_Q22_S2
     * <p>
     * 空间复杂度分析: 除了答案数组之外, 我们所需要的空间取决于递归栈的深度,
     * 每一层递归函数需要 O(1) 的空间, 最多递归 2n 层, 因此空间复杂度为 O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        // 结果都存储在combinations当中
        dfs("", combinations, n, n);
        return combinations;
    }

    /**
     * 深度优先遍历
     *
     * @param left  左括号的剩余数量
     * @param right 右括号的剩余数量
     */
    public void dfs(String str, List<String> combinations, int left, int right) {
        if (left == 0 && right == 0) {
            combinations.add(str);
        }

        if (left > right) {
            return;
        }

        if (left > 0) {
            dfs(str + "(", combinations, left - 1, right);
            // str + "(" 相当于新建了一个String对象, 不影响上一个状态, 没必要删除最后一个字符
        }

        if (right > 0) {
            dfs(str + ")", combinations, left, right - 1);
            // str + "(" 相当于新建了一个String对象, 不影响上一个状态, 没必要删除最后一个字符
        }
    }
}
