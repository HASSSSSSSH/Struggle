package questions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Solution: Depth First Search (backtrace)
 * Reference: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 时间复杂度: (待补充)
 * 空间复杂度: (待补充)
 */
public class Y2020M07D17_LC_Q22_S4 {

    public static void main(String args[]) {
        Y2020M07D17_LC_Q22_S4 instance = new Y2020M07D17_LC_Q22_S4();
        System.out.println(instance.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        // 结果都存储在combinations当中
        dfs(combinations, n);
        return combinations;
    }

    /**
     * 深度优先遍历
     */
    public void dfs(List<String> combinations, int n) {
        // JDK推荐通过Deque实现stack
        Deque<Node> stack = new ArrayDeque<>();
        stack.offerLast(new Node("", n, n));
        while (!stack.isEmpty()) {
            // 深度优先遍历, 取出最后一个元素, 后进先出
            Node node = stack.pollLast();

            if (node.left == 0 && node.right == 0) {
                combinations.add(node.str);
            }
            if (node.left > node.right) {
                continue;
            }
            if (node.left > 0) {
                // 深度优先
                stack.offerLast(new Node(node.str + "(", node.left - 1, node.right));
            }
            if (node.right > 0) {
                // 深度优先
                stack.offerLast(new Node(node.str + ")", node.left, node.right - 1));
            }
        }
    }

    class Node {
        /**
         * 当前得到的字符串
         */
        private String str;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.str = str;
            this.left = left;
            this.right = right;
        }
    }
}
