package questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * Solution: Breadth First Search
 * Reference: https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
 * 时间复杂度: (待补充)
 * 空间复杂度: (待补充)
 */
public class Y2020M07D17_LC_Q22_S6 {

    public static void main(String args[]) {
        Y2020M07D17_LC_Q22_S6 instance = new Y2020M07D17_LC_Q22_S6();
        System.out.println(instance.generateParenthesis(2));
    }

    public List<String> generateParenthesis(int n) {
        List<String> combinations = new ArrayList<>();
        bfs(combinations, n);
        return combinations;
    }

    /**
     * 广度优先遍历
     * <p>
     * 注意: 在遍历某个层级的节点时, 必须首先保存当前层级的节点数量
     */
    public void bfs(List<String> combinations, int n) {
        // 利用队列先进先出的特性, 保证优先遍历层级最高的元素
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node("", n, n));

        // 树的层级为2n + 1, 取值范围是[0, 2n]
        int level = 0;
        while (level < 2 * n) {
            // 必须先保存当前层级的节点数量, 因为接下来的操作将会改变queue.size()
            int size = queue.size();
            // for (int i = 0; i < queue.size(); i++) {
            for (int i = 0; i < size; i++) {
                // 遍历树的level层级的所有节点
                Node node = queue.poll();

                if (node.left > node.right) {
                    // 剪枝, 移除此分支
                    // 注意: continue
                    continue;
                }
                if (node.left > 0) {
                    // NOTE: 此处会改变queue.size()
                    queue.offer(new Node(node.res + "(", node.left - 1, node.right));
                }
                if (node.right > 0) {
                    // NOTE: 此处会改变queue.size()
                    queue.offer(new Node(node.res + ")", node.left, node.right - 1));
                }
            }
            ++level;
        }

        // 当前在树的最后一层, 第2n层, 在这个层级的所有节点都是有效的值
        for (Node node : queue) {
            combinations.add(node.res);
        }
    }

    class Node {
        /**
         * 当前得到的字符串
         */
        private String res;
        /**
         * 剩余左括号数量
         */
        private int left;
        /**
         * 剩余右括号数量
         */
        private int right;

        public Node(String str, int left, int right) {
            this.res = str;
            this.left = left;
            this.right = right;
        }
    }
}
