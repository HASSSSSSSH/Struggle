package questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Improve Y2020M07D13_LC_Q22_S1
 * Solution: backtrace
 * Reference: https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
 * 时间复杂度: O(4^n / n^(1/2))
 * 空间复杂度: O(n)
 */
public class Y2020M07D14_LC_Q22_S2 {

    public static void main(String args[]) {
        Y2020M07D14_LC_Q22_S2 instance = new Y2020M07D14_LC_Q22_S2();
        System.out.println(instance.generateParenthesis(2));
    }

    /**
     * 时间复杂度分析: https://leetcode-cn.com/problems/generate-parentheses/solution/gua-hao-sheng-cheng-by-leetcode-solution/
     * <p>
     * 空间复杂度分析: 除了答案数组之外, 我们所需要的空间取决于递归栈的深度,
     * 每一层递归函数需要 O(1) 的空间, 最多递归 2n 层, 因此空间复杂度为 O(n)
     */
    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();

        // redundant
        // if (n <= 0) {
        //     combinations.add("");
        //     return combinations;
        // }

        // 结果都存储在combinations当中
        backtrace(new StringBuilder(), combinations, 0, 0, n);
        return combinations;
    }

    /**
     * 我们可以只在序列仍然保持有效时才添加 '(' or ')'
     * 而不是像 Y2020M07D13_LC_Q22_S1 那样每次添加
     * 我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点:
     * 1.如果左括号数量不大于 n, 我们可以放一个左括号
     * 2.如果右括号数量小于左括号的数量, 我们可以放一个右括号
     * 按照此条件生成的序列, 总是有效的!!!
     *
     * @param open  字符串已使用的左括号数量
     * @param close 字符串已使用的右括号数量
     */
    public void backtrace(StringBuilder builder, List<String> combinations, int open, int close, int n) {
        if (builder.length() == 2 * n) {
            // 在生成的序列中, 总是有效的且不重复的
            combinations.add(builder.toString());
            return;
        }

        if (open < n) {
            builder.append('(');

            // 将open + 1 改成 ++open 是错误的, 因为接下来的if语句中可能会再次用到变量open
            backtrace(builder, combinations, open + 1, close, n);

            // 因为一个位置可能有两种符号, 将builder恢复到最初状态, 以便接下来赋值另外一种符号或者回溯到上一个状态
            builder.deleteCharAt(builder.length() - 1);
        }

        if (open > close) {
            builder.append(')');

            // 但是将close + 1 改成 ++close 却是可以的
            // backtrace(builder, combinations, open, ++close, n);
            backtrace(builder, combinations, open, close + 1, n);

            // 不能去掉这一步
            // 回溯法必须在最后将builder恢复到最初状态
            // 其实, 每个backtrace方法都有引用类型builder, builder都指向了内存中同一个对象
            // 而上面的步骤修改了builder指向的对象, 在回溯到上一个方法前, 需要撤销对builder的修改
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
