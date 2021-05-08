package questions;

import utils.TreeUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * 从上到下打印二叉树 III
 * <p>
 * 请实现一个函数按照之字形顺序打印二叉树, 即第一行按照从左到右的顺序打印, 第二层按照从右到左的顺序打印, 第三行再按照从左到右的顺序打印, 其他行以此类推
 * <p>
 * Tags: {@link questions.tags.Tree}, {@link questions.tags.BinaryTree}, {@link questions.tags.BreadthFirstSearch}
 * <p>
 * Review: {@link questions.tags.ReviewLevel#S}
 * <p>
 * Solution: {@link questions.tags.BreadthFirstSearch}
 * <p>
 * 时间复杂度: O(n)
 * <p>
 * 空间复杂度: O(n)
 */
public class Y2021M01D12_LCOF_Q32_3_S1 {

    public static void main(String args[]) {
        Y2021M01D12_LCOF_Q32_3_S1 instance = new Y2021M01D12_LCOF_Q32_3_S1();

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
        treeNode.left.left.right = new TreeNode(7);
        treeNode.right.left.right = new TreeNode(8);
        treeNode.right.right.left = new TreeNode(9);
        treeNode.right.right.right = new TreeNode(10);

        System.out.println(instance.levelOrder(treeNode));
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        deque.offerLast(root);
        int level = 1;

        while (!deque.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = deque.size();
            if ((level & 1) == 1) {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pollFirst();
                    list.add(node.val);
                    if (node.left != null) {
                        deque.offerLast(node.left);
                    }
                    if (node.right != null) {
                        deque.offerLast(node.right);
                    }
                }
            } else {
                for (int i = 0; i < size; i++) {
                    TreeNode node = deque.pollLast();
                    list.add(node.val);
                    if (node.right != null) {
                        deque.offerFirst(node.right);
                    }
                    if (node.left != null) {
                        deque.offerFirst(node.left);
                    }
                }
            }

            ans.add(list);
            level++;
        }

        return ans;
    }
}
