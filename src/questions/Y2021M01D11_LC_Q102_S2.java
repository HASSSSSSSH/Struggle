package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * 二叉树的层序遍历
 * <p>
 * 给你一个二叉树, 请你返回其按 层序遍历 得到的节点值
 * 即逐层地, 从左到右访问所有节点
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}, {@link questions.tags.BreadthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.BreadthFirstSearch}
 * <p>
 * Reference: https://leetcode-cn.com/problems/binary-tree-level-order-traversal/solution/er-cha-shu-de-ceng-xu-bian-li-by-leetcode-solution/
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2021M01D11_LC_Q102_S2 {

    public static void main(String args[]) {
        Y2021M01D11_LC_Q102_S2 instance = new Y2021M01D11_LC_Q102_S2();

        // level 1
        TreeNode treeNode = new TreeNode(1);
        // level 2
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(4);
        // level 3
        treeNode.left.left = new TreeNode(3);
        treeNode.right.left = new TreeNode(5);
        treeNode.right.right = new TreeNode(6);
        // level 4
        treeNode.right.right.left = new TreeNode(7);

        System.out.println(instance.levelOrder(treeNode));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);

        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();

            // 注意, 需要首先保存 当前队列中元素的数量
            // 此时, 树在当前层序的元素数量 = 当前队列中元素的数量
            // 在遍历中, 队列中元素的数量 不一定等于 树在当前层序的元素的剩余数量
            int levelSize = deque.size();

            // 遍历树在当前层序上的每一个节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);

                if (node.left != null) {
                    deque.offerLast(node.left);
                }
                if (node.right != null) {
                    deque.offerLast(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
